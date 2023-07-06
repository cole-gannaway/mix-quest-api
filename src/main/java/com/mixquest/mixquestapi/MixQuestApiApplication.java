package com.mixquest.mixquestapi;

import com.mixquest.mixquestapi.broker.session.ParticipantRepository;
import com.mixquest.mixquestapi.broker.session.PresenceEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Description;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.mixquest.mixquestapi.*")
public class MixQuestApiApplication {
	@Bean
	@Description("Tracks user presence (join / leave) and broacasts it to all connected users")
	public PresenceEventListener presenceEventListener(SimpMessagingTemplate messagingTemplate) {
		PresenceEventListener presence = new PresenceEventListener(messagingTemplate, participantRepository());
		presence.setLoginDestination("/topic/users");
		presence.setLogoutDestination("/topic/users");
		return presence;
	}

	@Bean
	@Description("Keeps connected users")
	public ParticipantRepository participantRepository() {
		return new ParticipantRepository();
	}
	public static void main(String[] args) {
		SpringApplication.run(MixQuestApiApplication.class, args);
	}

}
