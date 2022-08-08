BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, landmarks, images, schedules;

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
    url varchar(200),
    PRIMARY KEY(url),
    FOREIGN KEY(landmark_id) references landmarks(landmark_id)
);

CREATE TABLE schedules (
    landmark_id integer,
    open_time time NOT NULL,
    close_time time NOT NULL,
    day_of_week integer NOT NULL,
    FOREIGN KEY(landmark_id) references landmarks(landmark_id)
);

COMMIT TRANSACTION;
