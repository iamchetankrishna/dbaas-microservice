package com.thechetankrishna.DBaas.model;

public class LookupNumberResponse {

    private long id;
    private long phoneNumber;
    private Action action;
    private long responseTime;

    public LookupNumberResponse() {

    }

    public LookupNumberResponse(long id, long phoneNumber, Action action, long responseTime) {
        this.id = id;
        this.action = action;
        this.phoneNumber = phoneNumber;
        this.responseTime = responseTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }
}
