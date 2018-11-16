package com.cern.devices.session;


import org.joda.time.DateTime;

public class SessionInfo {

    private final Long userId;
    private DateTime date;


    public SessionInfo(Long userId, DateTime date) {
        this.userId = userId;
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }


}

