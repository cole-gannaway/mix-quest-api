CREATE DATABASE mix_quest_db;

-- Select database
USE mix_quest_db;

CREATE TABLE songrequests (
  songUUID VARCHAR(255) NOT NULL,
  lobbyUUID VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  PRIMARY KEY (songUUID, lobbyUUID, username)
);

CREATE TABLE songrequestsdislikes (
  songUUID VARCHAR(255) NOT NULL,
  lobbyUUID VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  PRIMARY KEY (songUUID, lobbyUUID, username)
);

CREATE VIEW song_requests_count_by_lobby AS
SELECT lobbyUUID, songUUID, COUNT(songUUID) AS songCount
FROM songrequests
GROUP BY lobbyUUID, songUUID;

CREATE VIEW song_requests_dislikes_count_by_lobby AS
SELECT lobbyUUID, songUUID, COUNT(songUUID) AS songCount
FROM songrequestsdislikes
GROUP BY lobbyUUID, songUUID;
