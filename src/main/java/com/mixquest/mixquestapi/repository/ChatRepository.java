package com.mixquest.mixquestapi.repository;
import com.mixquest.mixquestapi.model.ChatMessage;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "chats")
@Qualifier("chats")
public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
    // Add any custom query methods if needed

}
