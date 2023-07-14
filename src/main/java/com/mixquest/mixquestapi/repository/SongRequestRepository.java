package com.mixquest.mixquestapi.repository;

import com.mixquest.mixquestapi.model.SongRequest;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "song_requests")
@Qualifier("song_requests")
public interface SongRequestRepository extends JpaRepository<SongRequest, Long> {
    // add custom methods if necessary
}
