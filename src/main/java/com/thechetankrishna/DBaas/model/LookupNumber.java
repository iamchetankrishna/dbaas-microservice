package com.thechetankrishna.DBaas.model;

import lombok.Data;

import java.io.Serializable;

public class LookupNumber implements Serializable {

    private long id;
    private long phoneNumber;
    private Action action;

    public LookupNumber() {

    }

    public LookupNumber(long phoneNumber, Action action) {
        this.phoneNumber = phoneNumber;
        this.action = action;
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
}
