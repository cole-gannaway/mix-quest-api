package com.mixquest.mixquestapi.broker;

import com.mixquest.mixquestapi.model.SongRequest;
import com.mixquest.mixquestapi.repository.SongRequestDislikesRepository;
import com.mixquest.mixquestapi.repository.SongRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Description("Listens to RabbitMQ routes")
public class ChatController {
    @Autowired
    private SongRequestRepository songRequestRepository;

    @Autowired
    private SongRequestDislikesRepository songRequestDislikesRepository;

    @MessageMapping("/songs/{lobbyId}")
    @SendTo("/topic/songs.{lobbyId}")
    /**
     * Receives all messages and stores it to the database. Then it broadcasts the message to all other clients in that lobby
     */
    public SongRequest handleReceiveSongRequest(@Payload SongRequest message, @DestinationVariable String lobbyId) {
        System.out.println(message.toString());
        songRequestRepository.save(message);
        return message;
    }
}