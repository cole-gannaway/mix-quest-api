package com.mixquest.mixquestapi.model;


import java.util.Objects;

public class SongRequestMessage {
    public String songUUID;
    public String username;
    public String lobbyUUID;

    public String getSongUUID() {
        return songUUID;
    }

    public void setSongUUID(String songUUID) {
        this.songUUID = songUUID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRequestMessage message = (SongRequestMessage) o;
        return Objects.equals(getSongUUID(), message.getSongUUID()) && Objects.equals(getUsername(), message.getUsername()) && Objects.equals(getLobbyUUID(), message.getLobbyUUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongUUID(), getUsername(), getLobbyUUID());
    }

    @Override
    public String toString() {
        return "SongRequestMessage{" +
                "songUUID='" + songUUID + '\'' +
                ", username='" + username + '\'' +
                ", lobbyUUID='" + lobbyUUID + '\'' +
                '}';
    }
}
