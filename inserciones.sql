INSERT INTO game (description, name, rating, release_date) 
VALUES 
("Grand Theft Auto V is an action-adventure game developed by Rockstar North and published by Rockstar Games.", "Grand Theft Auto V", 9.3, "2013-09-17"),
("Minecraft is a sandbox video game developed and published by Mojang Studios.", "Minecraft", 9.1, "2011-11-18"),
("The Witcher 3: Wild Hunt is a 2015 action role-playing game developed and published by CD Projekt.", "The Witcher 3: Wild Hunt", 9.2, "2015-05-19"),
("Overwatch is a team-based multiplayer first-person shooter developed and published by Blizzard Entertainment.", "Overwatch", 8.8, "2016-05-24"),
("League of Legends is a multiplayer online battle arena video game developed and published by Riot Games.", "League of Legends", 8.7, "2009-10-27"),
("Red Dead Redemption 2 is a 2018 action-adventure game developed and published by Rockstar Games.", "Red Dead Redemption 2", 9.5, "2018-10-26"),
("Super Mario Odyssey is a platform game developed and published by Nintendo for the Nintendo Switch.", "Super Mario Odyssey", 9.2, "2017-10-27"),
("FIFA 22 is a football simulation video game developed by EA Vancouver and published by EA Sports.", "FIFA 22", 8.4, "2021-10-01"),
("Assassin's Creed Valhalla is a 2020 action role-playing video game developed by Ubisoft Montreal and published by Ubisoft.", "Assassin's Creed Valhalla", 8.5, "2020-11-10"),
("Horizon Zero Dawn is a 2017 action role-playing game developed by Guerrilla Games and published by Sony Interactive Entertainment.", "Horizon Zero Dawn", 9.1, "2017-02-28");


INSERT INTO player (age, email, first_name, gender, last_name, username) 
VALUES 
(24, "johndoe@gmail.com", "John", "Male", "Doe", "johndoe88"),
(32, "janedoe@hotmail.com", "Jane", "Female", "Doe", "janedoe92"),
(18, "lucasjones@yahoo.com", "Lucas", "Male", "Jones", "lucasjones01"),
(29, "susanmiller@gmail.com", "Susan", "Female", "Miller", "susanmiller80"),
(21, "michaelsmith@gmail.com", "Michael", "Male", "Smith", "michaelsmith92"),
(26, "sarahthompson@hotmail.com", "Sarah", "Female", "Thompson", "sarahthompson89"),
(19, "davidbrown@yahoo.com", "David", "Male", "Brown", "davidbrown00"),
(35, "jessicajohnson@hotmail.com", "Jessica", "Female", "Johnson", "jessicajohnson77"),
(23, "brianwilson@gmail.com", "Brian", "Male", "Wilson", "brianwilson93"),
(28, "amandarobinson@yahoo.com", "Amanda", "Female", "Robinson", "amandarobinson85");


INSERT INTO player_game_hours (hours, game_id, player_id) 
VALUES 
(50, 1, 1),
(20, 2, 1),
(100, 3, 1),
(30, 4, 2),
(60, 5, 2),
(80, 6, 3),
(10, 7, 3),
(90, 8, 4),
(40, 9, 5),
(70, 10, 6),
(55, 1, 7),
(25, 2, 8),
(45, 3, 9),
(15, 4, 10),
(85, 5, 10);
