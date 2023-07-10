CREATE DATABASE mix_quest_db;

-- Select database
USE mix_quest_db;


-- Create users table
CREATE TABLE users (
  id BIGINT PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  firstName VARCHAR(255),
  lastName VARCHAR(255)
);

-- Create lobbies table
CREATE TABLE lobbies (
  id BIGINT PRIMARY KEY,
  lobbyName VARCHAR(255) NOT NULL,
  adminUserId BIGINT NOT NULL,
  FOREIGN KEY (adminUserId) REFERENCES users(id) ON DELETE CASCADE
);

-- Create artsits table
CREATE TABLE artists (
  id BIGINT PRIMARY KEY,
  artistName VARCHAR(255) NOT NULL
);

-- Create songs table with foreign key constraint
CREATE TABLE songs (
  id BIGINT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  albumUrl VARCHAR(255),
  artistId BIGINT NOT NULL,
  FOREIGN KEY (artistId) REFERENCES artists(id)
);

-- Create chats, TODO adjust primary key
CREATE TABLE chats (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  content VARCHAR(255) NOT NULL,
  timeMillis BIGINT NOT NULL
);

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


INSERT INTO users (id, email, firstName, lastName) VALUES
  (1, "user1@example.com", "user-1", "lastName-1"),
  (2, "user2@example.com", "user-2", "lastName-2"),
  (3, "user3@example.com", "user-3", "lastName-3"),
  (4, "user4@example.com", "user-4", "lastName-4"),
  (5, "user5@example.com", "user-5", "lastName-5"),
  (6, "user6@example.com", "user-6", "lastName-6"),
  (7, "user7@example.com", "user-7", "lastName-7"),
  (8, "user8@example.com", "user-8", "lastName-8"),
  (9, "user9@example.com", "user-9", "lastName-9"),
  (10, "user10@example.com", "user-10", "lastName-10");

INSERT INTO chats (id, username, content, timeMillis)
VALUES
  (1,"User1", "Hello there!", 1654321000),
  (2,"User2", "Hi, how are you?", 1654322000),
  (3,"User1", "I'm doing great. Thanks!", 1654323000),
  (4,"User2", "That's good to hear!", 1654324000),
  (5,"User1", "What are you up to?", 1654325000),
  (6,"User2", "Just working on a project.", 1654326000),
  (7,"User1", "Sounds interesting.", 1654327000),
  (8,"User2", "Yes, it's quite challenging.", 1654328000),
  (9,"User1", "Well, best of luck!", 1654329000),
  (10,"User2", "Thank you!", 1654330000);
