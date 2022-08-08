BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO landmarks(landmark_name, category, description, up_ratings, down_ratings)
VALUES ('Art Deco Museum', 'Museum', 'Art stuff', 1, 5),
('Red Stadium', 'Sports', 'Sports stuff', 6, 2),
('Skyline Chili', 'Fast Food', 'Chili stuff', 9001, 0),
('Nether', 'Nowhere', 'Nonexistence', 10, 10),
('Esporta', 'Gym', 'Fitness stuff', 405, 135);

INSERT INTO schedules(landmark_id, open_time, close_time, day_of_week)
VALUES (1, '08:00:00', '20:00:00', 1),
(1, '08:00:00', '20:00:00', 2),
(1, '08:00:00', '20:00:00', 3),
(1, '08:00:00', '20:00:00', 4),
(1, '08:00:00', '20:00:00', 5),
(1, '10:00:00', '18:00:00', 6),
(1, '10:00:00', '14:00:00', 7),
(2, '05:00:00', '22:00:00', 1),
(2, '05:00:00', '22:00:00', 2),
(2, '05:00:00', '22:00:00', 3),
(2, '05:00:00', '22:00:00', 4),
(2, '05:00:00', '22:00:00', 5),
(2, '08:00:00', '18:00:00', 6),
(2, '08:00:00', '14:00:00', 7);

INSERT INTO city(city_name)
VALUES ('Cincinnati'), ('Columbus');

INSERT INTO city_landmarks(city_id, landmark_id)
VALUES (1, 1),
(1, 3),
(2, 3),
(2, 4),
(1, 2),
(1, 5);

COMMIT TRANSACTION;