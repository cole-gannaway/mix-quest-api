package com.mixquest.mixquestapi.repository;
import com.mixquest.mixquestapi.model.SongRequestCountByLobby;
import com.mixquest.mixquestapi.model.SongRequestCountByLobbyId;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "song_requests_dislikes_count_by_lobby")
@Qualifier("song_requests_dislikes_count_by_lobby")
public interface SongRequestDislikeCountByLobbyRepository extends JpaRepository<SongRequestCountByLobby, SongRequestCountByLobbyId> {
    @Query(
            value = "SELECT * FROM song_requests_dislikes_count_by_lobby u WHERE u.lobbyUUID = ?1",
            nativeQuery = true)
    List<SongRequestCountByLobby> findSongRequestsCountByLobbyUUID(String lobbyUUID);
    @Query(
            value = "SELECT * FROM song_requests_dislikes_count_by_lobby u WHERE u.lobbyUUID = ?1 && u.songUUID = ?2",
            nativeQuery = true)
    List<SongRequestCountByLobby> findSongRequestsCountByLobbyUUIDAndSongUUID(String lobbyUUID, String songUUID);
}
