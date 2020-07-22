package com.thechetankrishna.DBaas.model;

import java.io.Serializable;

public class LookNumberWithPattern implements Serializable {

    private long id;
    private String phoneNumber;
    private Action action;
    private Boolean isPattern;
    public LookNumberWithPattern() {

    }

    public LookNumberWithPattern(String phoneNumber, Action action) {
        this.phoneNumber = phoneNumber;
        this.action = action;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Boolean getPattern() {
        return isPattern;
    }

    public void setPattern(Boolean pattern) {
        isPattern = pattern;
    }
}
