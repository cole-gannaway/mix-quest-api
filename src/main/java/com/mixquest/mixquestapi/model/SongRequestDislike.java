package com.mixquest.mixquestapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(SongRequestDislikeId.class)
@Table(name = "songrequestsdislikes")
public class SongRequestDislike {
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
        SongRequestDislike that = (SongRequestDislike) o;
        return Objects.equals(getSongUUID(), that.getSongUUID()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getLobbyUUID(), that.getLobbyUUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongUUID(), getUsername(), getLobbyUUID());
    }

    @Override
    public String toString() {
        return "SongRequestDislike{" +
                "songUUID='" + songUUID + '\'' +
                ", username='" + username + '\'' +
                ", lobbyUUID='" + lobbyUUID + '\'' +
                '}';
    }
}
