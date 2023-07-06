package com.mixquest.mixquestapi.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "chats")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String content;
    private Long timeMillis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(Long timeMillis) {
        this.timeMillis = timeMillis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getContent(), that.getContent()) && Objects.equals(getTimeMillis(), that.getTimeMillis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getContent(), getTimeMillis());
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", timeMillis=" + timeMillis +
                '}';
    }
}

