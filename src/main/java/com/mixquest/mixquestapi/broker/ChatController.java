package com.mixquest.mixquestapi.broker;

import com.mixquest.mixquestapi.model.ChatMessage;
import com.mixquest.mixquestapi.repository.ChatRepository;
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
    private ChatRepository chatRepository;

    @MessageMapping("/messages/{lobbyId}")
    @SendTo("/topic/messages.{lobbyId}")
    /**
     * Receives all messages and stores it to the database. Then it broadcasts the message to all other clients in that lobby
     */
    public ChatMessage handleReceiveMessage(@Payload ChatMessage message, @DestinationVariable String lobbyId) {
        chatRepository.save(message);
        return message;
    }
}