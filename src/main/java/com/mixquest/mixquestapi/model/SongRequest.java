package com.mixquest.mixquestapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "songrequests")
public class SongRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="songUUID", nullable = false, unique = false)
    public String songUUID;
    @Column(name="username", nullable = false, unique = false)
    public String username;
    @Column(name="lobbyUUID", nullable = false, unique = false)
    public String lobbyUUID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRequest request = (SongRequest) o;
        return Objects.equals(getId(), request.getId()) && Objects.equals(songUUID, request.songUUID) && Objects.equals(username, request.username) && Objects.equals(lobbyUUID, request.lobbyUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), songUUID, username, lobbyUUID);
    }

    @Override
    public String toString() {
        return "SongRequest{" +
                "id=" + id +
                ", songUUID='" + songUUID + '\'' +
                ", username='" + username + '\'' +
                ", lobbyUUID='" + lobbyUUID + '\'' +
                '}';
    }
}
