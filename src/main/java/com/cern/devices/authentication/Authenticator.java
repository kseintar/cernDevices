package com.cern.devices.authentication;

import com.cern.devices.error.UserError;
import com.cern.devices.exception.NotAuthenticatedException;
import com.cern.devices.session.SessionInfo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.joda.time.DateTime;



@Component
public class Authenticator {

    private Map<UUID, SessionInfo> sessions = new ConcurrentHashMap<>();

    private final static int SESSION_TIME_OUT = 1000 * 60 * 30;
    public final static int SESSION_TIME_OUT_MINUTES = SESSION_TIME_OUT / (1000 * 60);

    public UUID createSession(SessionInfo session) {
        UUID uuid = UUID.randomUUID();
        sessions.put(uuid, session);

        return uuid;
    }

    public SessionInfo getSession(UUID authToken) {
        return sessions.get(authToken);
    }

    public SessionInfo checkUpdateSession(UUID authToken)throws Exception{
        SessionInfo sessionInfo = sessions.get(authToken);
        Optional.ofNullable(sessionInfo).orElseThrow(() -> new NotAuthenticatedException(UserError.NOT_AUTHENTICATED));
        sessionInfo.setDate(DateTime.now().plusMinutes(Authenticator.SESSION_TIME_OUT_MINUTES));
        return sessionInfo;
    }

    @Scheduled(fixedDelay = SESSION_TIME_OUT)
    private void cleanUpSessions() {
        sessions.entrySet().removeIf(session -> session.getValue().getDate().isBefore(DateTime.now()));
    }

}

