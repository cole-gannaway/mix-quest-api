package com.mixquest.mixquestapi.repository;
import com.mixquest.mixquestapi.model.ChatMessage;
import com.mixquest.mixquestapi.model.SongRequestCountByLobby;
import com.mixquest.mixquestapi.model.SongRequestCountByLobbyId;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@Table(name = "song_requests_count_by_lobby")
@Qualifier("song_requests_count_by_lobby")
public interface SongRequestCountByLobbyRepository extends JpaRepository<SongRequestCountByLobby, SongRequestCountByLobbyId> {
    @Query(
            value = "SELECT * FROM song_requests_count_by_lobby u WHERE u.lobbyUUID = ?1",
            nativeQuery = true)
    List<SongRequestCountByLobby> findAllSongRequestCountByLobbyId(String lobbyUUID);
}