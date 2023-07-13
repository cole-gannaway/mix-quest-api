package com.mixquest.mixquestapi.model;

import jakarta.persistence.*;

import java.util.Objects;

public class SongRequestCombinedId {
    public String lobbyUUID;
    public String songUUID;
    public Long likeCount;
    public Long dislikeCount;

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

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRequestCombinedId that = (SongRequestCombinedId) o;
        return Objects.equals(getLobbyUUID(), that.getLobbyUUID()) && Objects.equals(getSongUUID(), that.getSongUUID()) && Objects.equals(getLikeCount(), that.getLikeCount()) && Objects.equals(getDislikeCount(), that.getDislikeCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLobbyUUID(), getSongUUID(), getLikeCount(), getDislikeCount());
    }

    @Override
    public String toString() {
        return "SongRequestCombined{" +
                "lobbyUUID='" + lobbyUUID + '\'' +
                ", songUUID='" + songUUID + '\'' +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                '}';
    }
}
