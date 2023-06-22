package com.mixquest.mixquestapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    public long id;
    public String title;
    public String albumUrl;
    public long artistId;
}