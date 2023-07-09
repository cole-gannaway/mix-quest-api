package com.mixquest.mixquestapi.repository;

import com.mixquest.mixquestapi.model.SongRequest;
import com.mixquest.mixquestapi.model.SongRequestDislike;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "songrequestsdislikes")
@Qualifier("songrequestsdislikes")
public interface SongRequestDislikesRepository extends JpaRepository<SongRequestDislike, Long> {
    // Add any custom query methods if needed
}
