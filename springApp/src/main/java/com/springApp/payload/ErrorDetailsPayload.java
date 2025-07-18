package com.springApp.payload;

import java.util.Date;

public class ErrorDetailsPayload {
    private String message;
    private Date date;
    private String url;

    public ErrorDetailsPayload(String message, Date date, String url) {
        this.message = message;
        this.date = date;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
