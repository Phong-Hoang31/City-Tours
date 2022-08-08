BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, landmarks, images;

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
    venue varchar(50) NOT NULL,
    description varchar(500) NOT NULL,
    up_ratings integer,
    down_ratings integer
    );

CREATE TABLE images (
    landmark_id integer FOREIGN KEY,
    url varchar(200) PRIMARY KEY
);

COMMIT TRANSACTION;
