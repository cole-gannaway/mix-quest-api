package com.mixquest.mixquestapi.model;

import java.io.Serializable;
import java.util.Objects;

public class SongRequestCountByLobbyId implements Serializable {
    public String lobbyUUID;
    public String songUUID;
    public Long songCount;

    public String getLobbyUUID() {
        return lobbyUUID;
    }

    public void setLobbyUUID(String lobbyUUID) {
        this.lobbyUUID = lobbyUUID;
    }

    public String getSongUUID() {
        return songUUID;
    }

    public void setSongUUID(String songUUID) {
        this.songUUID = songUUID;
    }

    public Long getSongCount() {
        return songCount;
    }

    public void setSongCount(Long songCount) {
        this.songCount = songCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRequestCountByLobbyId that = (SongRequestCountByLobbyId) o;
        return Objects.equals(getLobbyUUID(), that.getLobbyUUID()) && Objects.equals(getSongUUID(), that.getSongUUID()) && Objects.equals(getSongCount(), that.getSongCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLobbyUUID(), getSongUUID(), getSongCount());
    }

    @Override
    public String toString() {
        return "SongRequestCountByLobbyId{" +
                "lobbyUUID='" + lobbyUUID + '\'' +
                ", songUUID='" + songUUID + '\'' +
                ", songCount=" + songCount +
                '}';
    }
}
