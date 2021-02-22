package com.igor.CarSystemIdea.task;

import com.igor.CarSystemIdea.service.Facade;

public class ClientSession {

    private Facade facade;
    private long lastAccessed;


    public Facade getFacade() {
        return facade;
    }
    public void setFacade(Facade facade) {
        this.facade = facade;
    }
    public long getLastAccessed() {
        return lastAccessed;
    }
    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
}
