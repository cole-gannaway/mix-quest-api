package com.mixquest.mixquestapi.model;

import java.io.Serializable;
import java.util.Objects;

public class SongRequestId implements Serializable {
    public String songUUID;
    public String username;
    public String lobbyUUID;
    public Boolean isLike;

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

    public Boolean getLike() {
        return isLike;
    }

    public void setLike(Boolean like) {
        isLike = like;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRequestId that = (SongRequestId) o;
        return Objects.equals(getSongUUID(), that.getSongUUID()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getLobbyUUID(), that.getLobbyUUID()) && Objects.equals(isLike, that.isLike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongUUID(), getUsername(), getLobbyUUID(), isLike);
    }

    @Override
    public String toString() {
        return "SongRequestId{" +
                "songUUID='" + songUUID + '\'' +
                ", username='" + username + '\'' +
                ", lobbyUUID='" + lobbyUUID + '\'' +
                ", isLike=" + isLike +
                '}';
    }
}