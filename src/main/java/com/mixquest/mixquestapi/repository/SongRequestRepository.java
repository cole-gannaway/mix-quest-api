package com.mixquest.mixquestapi.repository;

import com.mixquest.mixquestapi.model.SongRequest;
import com.mixquest.mixquestapi.model.User;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "songrequests")
@Qualifier("songrequests")
public interface SongRequestRepository extends JpaRepository<SongRequest, Long> {
    // Add any custom query methods if needed
}
