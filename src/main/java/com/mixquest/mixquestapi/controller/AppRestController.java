package com.mixquest.mixquestapi.controller;

import com.mixquest.mixquestapi.model.*;
import com.mixquest.mixquestapi.broker.session.ParticipantRepository;

import com.mixquest.mixquestapi.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

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
    private SongRequestCombinedRepository songRequestCombinedRepository;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public AppRestController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PutMapping("/addSongRequest")
    public Boolean addSongRequest(@RequestBody SongRequest message){
        logger.info("Received addSongRequest for " + message);
        songRequestRepository.save(message);
        // send update to front end
        messagingTemplate.convertAndSend(
                "/topic/song_request_update." + message.getLobbyUUID(),
                songRequestCombinedRepository.findSongRequestsCountByLobbyUUIDAndSongUUID(message.getLobbyUUID(),message.getSongUUID())
        );
        return true;
    }

    @PutMapping("/addSongRequestDislike")
    public Boolean addSongRequestDislike(@RequestBody SongRequest message){
        logger.info("Received addSongRequestDislike for " + message);
        songRequestRepository.save(message);
        // send update to front end
        messagingTemplate.convertAndSend(
                "/topic/song_request_update." + message.getLobbyUUID(),
                songRequestCombinedRepository.findSongRequestsCountByLobbyUUIDAndSongUUID(message.getLobbyUUID(),message.getSongUUID())
        );
        return true;
    }

    @GetMapping("/getSessions/{lobbyUUID}")
    public Long getSessions(@PathVariable final String lobbyUUID){
        logger.info("Received getSessions for lobbyUUID: " + lobbyUUID);
        return participantRepository.getSessionCountForLobby(lobbyUUID);
    }

    @GetMapping("/getSongRequestsByLobby/{lobbyUUID}")
    @Description("Get song request data from the lobby on initializing the front end")
    public List<SongRequestCombined> getSongRequestsByLobby(@PathVariable String lobbyUUID){
        logger.info("Received getSongRequestsByLobby for lobbyUUID: " + lobbyUUID);
        return songRequestCombinedRepository.findTop25SongRequestsCountByLobbyUUID(lobbyUUID);
    }
    @PostMapping("/getSongRequestsByLobbyPagination")
    @Description("Paginate through the data 25 at a time")
    public List<SongRequestCombined> getSongRequestsByLobbyPagination(@RequestBody SongRequestCursorMessage message){
        logger.info("Received getSongRequestsByLobby for lobbyUUID: " + message.getLobbyUUID());
        return songRequestCombinedRepository.findNextPageTop25SongRequestsCountByLobbyUUID(message.getLobbyUUID(), message.getSongCount(), message.getSongUUID());
    }
}

