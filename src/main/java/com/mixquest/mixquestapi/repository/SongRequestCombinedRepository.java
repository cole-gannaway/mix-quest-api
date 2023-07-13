package com.mixquest.mixquestapi.repository;

import com.mixquest.mixquestapi.model.SongRequest;
import com.mixquest.mixquestapi.model.SongRequestCombined;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "song_requests_combined")
@Qualifier("song_requests_combined")
public interface SongRequestCombinedRepository extends JpaRepository<SongRequestCombined, Long> {
    @Query(
            value = "SELECT * FROM song_requests_combined u WHERE u.lobbyUUID = ?1 && u.songUUID = ?2",
            nativeQuery = true)
    List<SongRequestCombined> findSongRequestsCountByLobbyUUIDAndSongUUID(String lobbyUUID, String songUUID);

    @Query(
            value = "SELECT * FROM song_requests_combined u WHERE u.lobbyUUID = ?1 ORDER BY likeCount DESC, songUUID ASC LIMIT 25",
            nativeQuery = true)
    List<SongRequestCombined> findTop25SongRequestsCountByLobbyUUID(String lobbyUUID);
    @Query(
            value = "SELECT * FROM song_requests_combined u WHERE (u.lobbyUUID = ?1) AND (u.likeCount <= $2) AND (u.songUUID >= $3) ORDER BY likeCount DESC, songUUID ASC LIMIT 25",
            nativeQuery = true)
    @Description("Uses cursor pagination to find the next 25 song requests")
    List<SongRequestCombined> findNextPageTop25SongRequestsCountByLobbyUUID(String lobbyUUID, Long songCount, String songUUID);
}
