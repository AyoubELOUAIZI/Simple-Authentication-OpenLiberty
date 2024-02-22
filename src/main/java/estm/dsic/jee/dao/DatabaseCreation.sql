CREATE DATABASE IF NOT EXISTS testAuthDatabase;

USE testAuthDatabase;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

INSERT INTO users (email, username, password) VALUES
('ayoub@example.com', 'ELOUAIZI AYOUB', 'pass'),
('user2@example.com', 'user2', 'password2'),
('user3@example.com', 'user3', 'password3');

select * from users;
