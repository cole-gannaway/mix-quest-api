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

    public SongRequestDislike(String songUUID, String username, String lobbyUUID) {
        this.songUUID = songUUID;
        this.username = username;
        this.lobbyUUID = lobbyUUID;
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
        SongRequestDislike that = (SongRequestDislike) o;
        return Objects.equals(getSongUUID(), that.getSongUUID()) && Objects.equals(username, that.username) && Objects.equals(lobbyUUID, that.lobbyUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongUUID(), username, lobbyUUID);
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
