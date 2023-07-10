package com.mixquest.mixquestapi.controller;

import com.mixquest.mixquestapi.model.ChatMessage;
import com.mixquest.mixquestapi.broker.session.ParticipantRepository;

import com.mixquest.mixquestapi.model.SongRequestCountByLobby;
import com.mixquest.mixquestapi.model.SongRequestCountByLobbyId;
import com.mixquest.mixquestapi.model.User;
import com.mixquest.mixquestapi.repository.ChatRepository;
import com.mixquest.mixquestapi.repository.SongRequestCountByLobbyRepository;
import com.mixquest.mixquestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppRestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private SongRequestCountByLobbyRepository songRequestCountByLobbyRepository;
    @GetMapping("/getMessages")
    @CrossOrigin(origins = "*")
    public List<ChatMessage> getMessages() {
        List<ChatMessage> result = chatRepository.findAll();
        return result;
    }

    @GetMapping("/getUsers")
    @CrossOrigin(origins = "*")
    public List<User> getUsers(){
        List<User> result = userRepository.findAll();
        return result;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/getSessions")
    public Integer printSessions(){
        return participantRepository.getActiveSessions().size();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getSongRequestsByLobby/{lobbyUUID}")
    public List<SongRequestCountByLobby> getSongRequestsByLobby(@PathVariable String lobbyUUID){
        return songRequestCountByLobbyRepository.findAllSongRequestCountByLobbyId(lobbyUUID);
    }

}

