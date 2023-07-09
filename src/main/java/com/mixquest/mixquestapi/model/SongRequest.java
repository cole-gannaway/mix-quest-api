package com.mixquest.mixquestapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(SongRequestId.class)
@Table(name = "songrequests")
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
        SongRequest request = (SongRequest) o;
        return Objects.equals(getSongUUID(), request.getSongUUID()) && Objects.equals(username, request.username) && Objects.equals(lobbyUUID, request.lobbyUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongUUID(), username, lobbyUUID);
    }

    @Override
    public String toString() {
        return "SongRequest{" +
                "songUUID='" + songUUID + '\'' +
                ", username='" + username + '\'' +
                ", lobbyUUID='" + lobbyUUID + '\'' +
                '}';
    }
}
