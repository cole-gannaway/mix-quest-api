package com.mixquest.mixquestapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "songrequestsdislikes")
public class SongRequestDislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name="songUUID", nullable = false, unique = false)
    public String songUUID;
    @Column(name="username", nullable = false, unique = false)
    public String username;
    @Column(name="lobbyUUID", nullable = false, unique = false)
    public String lobbyUUID;

}
