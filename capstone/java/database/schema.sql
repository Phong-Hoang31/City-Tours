BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, landmarks, images, schedules, city, city_landmarks, images;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE landmarks (
    landmark_id SERIAL PRIMARY KEY,
    landmark_name varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    description varchar(500) NOT NULL,
    up_ratings integer NOT NULL,
    down_ratings integer NOT NULL
    );

CREATE TABLE images (
    landmark_id integer,
    url varchar(8000),
    PRIMARY KEY(url),
    FOREIGN KEY(landmark_id) references landmarks(landmark_id)
);

CREATE TABLE schedules (
    landmark_id integer,
    open_time time NOT NULL,
    close_time time NOT NULL,
    day_of_week varchar(50) NOT NULL,
    FOREIGN KEY(landmark_id) references landmarks(landmark_id)
);

CREATE TABLE city (
    city_id SERIAL PRIMARY KEY,
    city_name varchar(50)
);

CREATE TABLE city_landmarks (
    city_id integer,
    landmark_id integer,
    PRIMARY KEY(city_id, landmark_id)
);

COMMIT TRANSACTION;
