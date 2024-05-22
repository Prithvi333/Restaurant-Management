package com.restaurant.restaurant.exception;

import java.time.LocalDateTime;

public class ErrorDataTransfer {

    String errorMessage;
    LocalDateTime localDateTime;

    public ErrorDataTransfer(){
        super();
    }

    public ErrorDataTransfer(String errorMessage, LocalDateTime localDateTime) {
        this.errorMessage = errorMessage;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
