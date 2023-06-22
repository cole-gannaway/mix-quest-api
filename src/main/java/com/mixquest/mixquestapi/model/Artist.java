package com.mixquest.mixquestapi.model;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    public long id;
    public String artistName;
}