package com.mixquest.mixquestapi.model;

import java.util.Objects;

public class SongRequestCursorMessage {
    public String lobbyUUID;
    public Long songCount;
    public String songUUID;

    public String getLobbyUUID() {
        return lobbyUUID;
    }

    public void setLobbyUUID(String lobbyUUID) {
        this.lobbyUUID = lobbyUUID;
    }

    public Long getSongCount() {
        return songCount;
    }

    public void setSongCount(Long songCount) {
        this.songCount = songCount;
    }

    public String getSongUUID() {
        return songUUID;
    }

    public void setSongUUID(String songUUID) {
        this.songUUID = songUUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRequestCursorMessage that = (SongRequestCursorMessage) o;
        return Objects.equals(getLobbyUUID(), that.getLobbyUUID()) && Objects.equals(getSongCount(), that.getSongCount()) && Objects.equals(getSongUUID(), that.getSongUUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLobbyUUID(), getSongCount(), getSongUUID());
    }

    @Override
    public String toString() {
        return "SongRequestCursorMessage{" +
                "lobbyUUID='" + lobbyUUID + '\'' +
                ", songCount=" + songCount +
                ", songUUID='" + songUUID + '\'' +
                '}';
    }
}
