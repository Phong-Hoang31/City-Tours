BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO landmarks(landmark_name, category, description, up_ratings, down_ratings)
VALUES ('Art Deco Museum', 'Museum', 'Art stuff', 1, 5),
('Red Stadium', 'Sports', 'Sports stuff', 6, 2),
('Skyline Chili', 'Fast Food', 'Chili stuff', 9001, 0);

COMMIT TRANSACTION;