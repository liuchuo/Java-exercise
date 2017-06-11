CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username CHAR(16) NOT NULL,
  password CHAR(16) NOT NULL
);

CREATE TABLE profile (
  avatar VARCHAR(100),
  nickname char(6),
  user_id INT REFERENCES user(id)
);

CREATE TABLE task (
  checked BOOLEAN DEFAULT FALSE,
  content VARCHAR(200),
  id int AUTO_INCREMENT PRIMARY KEY,
  user_id INT REFERENCES user(id)
);