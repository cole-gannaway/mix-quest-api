package com.mixquest.mixquestapi.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@IdClass(SongRequestCountByLobbyId.class)
@Table(name = "song_requests_count_by_lobby")
public class SongRequestCountByLobby {
    @Id
    @Column(name="lobbyUUID", nullable = false, unique = false)
    public String lobbyUUID;
    @Id
    @Column(name="songUUID", nullable = false, unique = false)
    public String songUUID;
    @Id
    @Column(name="songCount", nullable = false, unique = false)
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
        SongRequestCountByLobby that = (SongRequestCountByLobby) o;
        return Objects.equals(getLobbyUUID(), that.getLobbyUUID()) && Objects.equals(getSongUUID(), that.getSongUUID()) && Objects.equals(getSongCount(), that.getSongCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLobbyUUID(), getSongUUID(), getSongCount());
    }

    @Override
    public String toString() {
        return "SongRequestCountByLobby{" +
                "lobbyUUID='" + lobbyUUID + '\'' +
                ", songUUID='" + songUUID + '\'' +
                ", songCount=" + songCount +
                '}';
    }
}
