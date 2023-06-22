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


INSERT INTO users (id, email, firstName, lastName) VALUES
  (1, 'user1@example.com', 'user-1', 'lastName-1'),
  (2, 'user2@example.com', 'user-2', 'lastName-2'),
  (3, 'user3@example.com', 'user-3', 'lastName-3'),
  (4, 'user4@example.com', 'user-4', 'lastName-4'),
  (5, 'user5@example.com', 'user-5', 'lastName-5'),
  (6, 'user6@example.com', 'user-6', 'lastName-6'),
  (7, 'user7@example.com', 'user-7', 'lastName-7'),
  (8, 'user8@example.com', 'user-8', 'lastName-8'),
  (9, 'user9@example.com', 'user-9', 'lastName-9'),
  (10, 'user10@example.com', 'user-10', 'lastName-10');
