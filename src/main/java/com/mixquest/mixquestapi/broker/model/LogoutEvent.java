package com.mixquest.mixquestapi.broker.model;

import java.util.Date;

public class LogoutEvent {

    private String username;
    private String lobbyUUID;
    private Date time;

    public LogoutEvent(String username, String lobbyUUID) {
        this.username = username;
        this.lobbyUUID = lobbyUUID;
        time = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLobbyUUID() {
        return lobbyUUID;
    }

    public void setLobbyUUID(String lobbyUUID) {
        this.lobbyUUID = lobbyUUID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LogoutEvent{" +
                "username='" + username + '\'' +
                ", lobbyUUID='" + lobbyUUID + '\'' +
                ", time=" + time +
                '}';
    }
}