CREATE DATABASE mix_quest_db;

-- Select database
USE mix_quest_db;

CREATE TABLE song_requests (
  songUUID VARCHAR(255) NOT NULL,
  lobbyUUID VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  isLike BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (songUUID, lobbyUUID, username, isLike)
);

CREATE VIEW song_requests_combined AS
SELECT lobbyUUID, songUUID, 
       SUM(CASE WHEN isLike = 1 THEN 1 ELSE 0 END) AS likeCount,
       SUM(CASE WHEN isLike = 0 THEN 1 ELSE 0 END) AS dislikeCount
FROM song_requests
GROUP BY lobbyUUID, songUUID;
