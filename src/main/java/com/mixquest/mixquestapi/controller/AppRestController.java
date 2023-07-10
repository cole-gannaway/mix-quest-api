package com.mixquest.mixquestapi.controller;

import com.mixquest.mixquestapi.broker.model.LoginEvent;
import com.mixquest.mixquestapi.broker.session.PresenceEventListener;
import com.mixquest.mixquestapi.model.*;
import com.mixquest.mixquestapi.broker.session.ParticipantRepository;

import com.mixquest.mixquestapi.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.PUT})
public class AppRestController {
    Logger logger = LoggerFactory.getLogger(AppRestController.class);

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private SongRequestRepository songRequestRepository;
    @Autowired
    private SongRequestDislikesRepository songRequestDislikesRepository;
    @Autowired
    private SongRequestCountByLobbyRepository songRequestCountByLobbyRepository;
    @Autowired
    private SongRequestDislikeCountByLobbyRepository songRequestDislikeCountByLobbyRepository;
    private SimpMessagingTemplate messagingTemplate;

    public AppRestController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PutMapping("/addSongRequest")
    public Boolean addSongRequest(@RequestBody SongRequestMessage message){
        logger.info("Received addSongRequest for " + message);
        songRequestRepository.save(SongRequestAdapter.convertToSongRequest(message));
        // send update to front end
        messagingTemplate.convertAndSend(
                "/topic/song_request." + message.getLobbyUUID(),
                songRequestCountByLobbyRepository.findSongRequestsCountByLobbyUUIDAndSongUUID(message.getLobbyUUID(),message.getSongUUID())
        );
        return true;
    }

    @PutMapping("/addSongRequestDislike")
    public Boolean addSongRequestDislike(@RequestBody SongRequestMessage message){
        logger.info("Received addSongRequestDislike for " + message);
        songRequestDislikesRepository.save(SongRequestAdapter.convertToSongRequestDislike(message));
        // send update to front end
        messagingTemplate.convertAndSend(
                "/topic/song_request_dislike." + message.getLobbyUUID(),
                songRequestDislikeCountByLobbyRepository.findSongRequestsCountByLobbyUUIDAndSongUUID(message.getLobbyUUID(),message.getSongUUID())
        );
        return true;
    }

    @GetMapping("/getSessions/{lobbyUUID}")
    public Long getSessions(@PathVariable final String lobbyUUID){
        logger.info("Received getSessions for lobbyUUID: " + lobbyUUID);
        return participantRepository.getSessionCountForLobby(lobbyUUID);
    }

    @GetMapping("/getSongRequestsByLobby/{lobbyUUID}")
    public List<SongRequestCountByLobby> getSongRequestsByLobby(@PathVariable String lobbyUUID){
        logger.info("Received getSongRequestsByLobby for lobbyUUID: " + lobbyUUID);
        return songRequestCountByLobbyRepository.findSongRequestsCountByLobbyUUID(lobbyUUID);
    }
    @GetMapping("/getSongRequestDislikesByLobby/{lobbyUUID}")
    public List<SongRequestCountByLobby> getSongRequestDislikesByLobby(@PathVariable String lobbyUUID){
        logger.info("Received getSongRequestsByLobby for lobbyUUID: " + lobbyUUID);
        return songRequestDislikeCountByLobbyRepository.findSongRequestsCountByLobbyUUID(lobbyUUID);
    }
}

