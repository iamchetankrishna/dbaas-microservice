package com.thechetankrishna.DBaas.model;

public class LookupNumberPattern {

    private long id;
    private String lookupNumberPattern;
    private Action action;

    public LookupNumberPattern() {

    }

    public LookupNumberPattern(String lookupNumberPattern, Action action) {
        this.lookupNumberPattern = lookupNumberPattern;
        this.action = action;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLookupNumberPattern() {
        return lookupNumberPattern;
    }

    public void setLookupNumberPattern(String lookupNumberPattern) {
        this.lookupNumberPattern = lookupNumberPattern;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
