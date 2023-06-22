package com.mixquest.mixquestapi.broker;

public class ChatMessage {
    private String userName;
    private String content;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
