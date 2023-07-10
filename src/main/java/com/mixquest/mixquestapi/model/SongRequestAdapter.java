package com.mixquest.mixquestapi.model;

public class SongRequestAdapter {

    public static SongRequest convertToSongRequest(SongRequestMessage message) {
        SongRequest songRequest = new SongRequest();
        songRequest.setSongUUID(message.getSongUUID());
        songRequest.setUsername(message.getUsername());
        songRequest.setLobbyUUID(message.getLobbyUUID());
        return songRequest;
    }

    public static SongRequestDislike convertToSongRequestDislike(SongRequestMessage message) {
        SongRequestDislike songRequestDislike = new SongRequestDislike();
        songRequestDislike.setSongUUID(message.getSongUUID());
        songRequestDislike.setUsername(message.getUsername());
        songRequestDislike.setLobbyUUID(message.getLobbyUUID());
        return songRequestDislike;
    }
}
