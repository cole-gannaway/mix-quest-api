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

    private String loginDestination;

    private String logoutDestination;

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
        String topic = loginDestination + "." + lobbyUUID;
        messagingTemplate.convertAndSend(topic, participantRepository.getActiveSessions().size() + 1);

        logger.info("User: " + username + " logged in to lobbyUUID: " + lobbyUUID);

        // We store the session as we need to be idempotent in the disconnect event processing
        participantRepository.add(headers.getSessionId(), loginEvent);
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        LoginEvent participant = participantRepository.getParticipant(event.getSessionId());
        String username = participant.getUsername();
        String lobbyUUID = participant.getLobbyUUID();
        String topic = logoutDestination + "." + lobbyUUID;

        logger.info("User: " + username + " logging out of to lobbyUUID: " + lobbyUUID);

        Optional.ofNullable(participant)
                .ifPresent(login -> {
                    messagingTemplate.convertAndSend(topic, participantRepository.getActiveSessions().size() - 1);
                    participantRepository.removeParticipant(event.getSessionId());
                });
    }

    public void setLoginDestination(String loginDestination) {
        this.loginDestination = loginDestination;
    }

    public void setLogoutDestination(String logoutDestination) {
        this.logoutDestination = logoutDestination;
    }
}