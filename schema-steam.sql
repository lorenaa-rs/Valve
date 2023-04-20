CREATE TABLE player(
  id INT PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  username VARCHAR(255),
  age INT,
  gender VARCHAR(10)
);

CREATE TABLE game(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description TEXT,
  release_date DATE,
  rating FLOAT
);

CREATE TABLE player_game_hours(
  id INT PRIMARY KEY AUTO_INCREMENT,
  player_id INT,
  game_id INT,
  hours_played FLOAT,
  FOREIGN KEY (player_id) REFERENCES player(id),
  FOREIGN KEY (game_id) REFERENCES game(id)
);
