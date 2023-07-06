package com.mixquest.mixquestapi.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Lobby
{
    @Id
    public long id;
    public String lobbyName;
    public long adminUserId;
}