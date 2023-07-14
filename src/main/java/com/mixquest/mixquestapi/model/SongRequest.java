package com.mixquest.mixquestapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(SongRequestId.class)
@Table(name = "song_requests")
public class SongRequest {
    @Id
    @Column(name="songUUID", nullable = false, unique = false)
    public String songUUID;
    @Id
    @Column(name="username", nullable = false, unique = false)
    public String username;
    @Id
    @Column(name="lobbyUUID", nullable = false, unique = false)
    public String lobbyUUID;
    @Id
    @Column(name="isLike", nullable = false, unique = false)
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
        SongRequest request = (SongRequest) o;
        return Objects.equals(getSongUUID(), request.getSongUUID()) && Objects.equals(getUsername(), request.getUsername()) && Objects.equals(getLobbyUUID(), request.getLobbyUUID()) && Objects.equals(isLike, request.isLike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongUUID(), getUsername(), getLobbyUUID(), isLike);
    }

    @Override
    public String toString() {
        return "SongRequest{" +
                "songUUID='" + songUUID + '\'' +
                ", username='" + username + '\'' +
                ", lobbyUUID='" + lobbyUUID + '\'' +
                ", isLike=" + isLike +
                '}';
    }
}
