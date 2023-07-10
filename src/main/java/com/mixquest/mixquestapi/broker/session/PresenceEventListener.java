package com.mixquest.mixquestapi.broker.session;

import java.util.List;
import java.util.Optional;

import com.mixquest.mixquestapi.broker.model.LoginEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

public class PresenceEventListener {
    Logger logger = LoggerFactory.getLogger(PresenceEventListener.class);

    private ParticipantRepository participantRepository;

    private SimpMessagingTemplate messagingTemplate;

    public PresenceEventListener(SimpMessagingTemplate messagingTemplate, ParticipantRepository participantRepository) {
        this.messagingTemplate = messagingTemplate;
        this.participantRepository = participantRepository;
    }

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        Object nativeHeaders = headers.getHeader("nativeHeaders");
        List<String> userNameList = ((LinkedMultiValueMap) nativeHeaders).get("username");
        String username = userNameList.get(0);
        List<String> lobbyUUIDList = ((LinkedMultiValueMap) nativeHeaders).get("lobbyUUID");
        String lobbyUUID = lobbyUUIDList.get(0);
        LoginEvent loginEvent = new LoginEvent(username, lobbyUUID);

        logger.info("User: " + username + " logged in to lobbyUUID: " + lobbyUUID);

        // We store the session as we need to be idempotent in the disconnect event processing
        participantRepository.add(headers.getSessionId(), loginEvent);

        // Send via STOMP
        String topic = "/topic/users." + lobbyUUID;
        messagingTemplate.convertAndSend(topic, participantRepository.getSessionCountForLobby(lobbyUUID));
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        LoginEvent participant = participantRepository.getParticipant(event.getSessionId());
        String username = participant.getUsername();
        String lobbyUUID = participant.getLobbyUUID();
        String topic = "/topic/users." + lobbyUUID;

        logger.info("User: " + username + " logging out of to lobbyUUID: " + lobbyUUID);

        Optional.ofNullable(participant)
                .ifPresent(login -> {
                    participantRepository.removeParticipant(event.getSessionId());
                    messagingTemplate.convertAndSend(topic, participantRepository.getSessionCountForLobby(lobbyUUID));
                });
    }




}