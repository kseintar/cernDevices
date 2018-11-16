package com.cern.devices.error;


public enum UserError {
    USER_DOES_NOT_EXIST("User does not exist."),
    INVALID_DATA("Invalid data."),
    MISSING_DATA("Missing data."),
    MISSING_PASSWORD("Missing password."),
    MISSING_USERNAME("Missing username."),
    MISSING_FIRSTNAME("Missing first name."),
    MISSING_LASTNAME("Missing last name."),
    INVALID_CREDENTIALS("Invalid credentials"),
    UNAUTHORIZED("Unauthorized user."),
    NOT_AUTHENTICATED("User is not authenticated.");



    private final String description;

    UserError(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

