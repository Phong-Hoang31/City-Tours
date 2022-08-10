BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO landmarks(landmark_name, category, description, up_ratings, down_ratings)
VALUES ('Cincinnati Art Museum', 'Art Museum', 'The Cincinnati Art Museum is an art museum in the Eden Park neighborhood of Cincinnati, Ohio. Founded in 1881, it was the first purpose-built art museum west of the Alleghenies, and is one of the oldest in the United States.', 101, 15),
('Reds Stadium', 'Stadium', 'Great American Ball Park is a baseball stadium in Cincinnati, Ohio. It serves as the home stadium of the Cincinnati Reds of Major League Baseball, and opened on March 31, 2003, replacing Cinergy Field, the Reds home field from 1970 to 2002.', 245, 12),
('Skyline Chili', 'Restaurant', 'Skyline Chili is a chain of Cincinnati-style chili restaurants based in Cincinnati, Ohio. Founded in 1949 by Greek immigrant Nicholas Lambrinides, Skyline Chili is named for the view of Cincinnatis skyline that Lambrinides could see from his first restaurant, opened in the section of town now known as Price Hill.', 9001, 10),
('Roebling Suspension Bridge', 'Suspension Bridge', 'The John A. Roebling Suspension Bridge, originally known as the Cincinnati-Covington Bridge, spans the Ohio River between Cincinnati, Ohio, and Covington, Kentucky. ', 6001, 82),
('Cincinnati Zoo & Botanical Garden', 'Zoo', 'The Cincinnati Zoo & Botanical Garden is the second oldest zoo in the United States, founded in 1873 and officially opening in 1875, after the Roger Williams Park Zoo. It is located in the Avondale neighborhood of Cincinnati, Ohio.', 405, 11);

INSERT INTO schedules(landmark_id, open_time, close_time, day_of_week)
VALUES (1, '08:00:00', '20:00:00', 'Monday'),
(1, '08:00:00', '20:00:00', 'Tuesday'),
(1, '08:00:00', '20:00:00', 'Wednesday'),
(1, '08:00:00', '20:00:00', 'Thursday'),
(1, '08:00:00', '20:00:00', 'Friday'),
(1, '10:00:00', '18:00:00', 'Saturday'),
(1, '10:00:00', '14:00:00', 'Sunday'),
(2, '05:00:00', '22:00:00', 'Monday'),
(2, '05:00:00', '22:00:00', 'Tuesday'),
(2, '05:00:00', '22:00:00', 'Wednesday'),
(2, '05:00:00', '22:00:00', 'Thursday'),
(2, '05:00:00', '22:00:00', 'Friday'),
(2, '08:00:00', '18:00:00', 'Saturday'),
(2, '08:00:00', '14:00:00', 'Sunday'),
(3, '06:00:00', '22:00:00', 'Monday'),
(3, '06:00:00', '22:00:00', 'Tuesday'),
(3, '06:00:00', '22:00:00', 'Wednesday'),
(3, '06:00:00', '22:00:00', 'Thursday'),
(3, '06:00:00', '22:00:00', 'Friday'),
(3, '09:00:00', '19:00:00', 'Saturday'),
(3, '09:00:00', '15:00:00', 'Sunday'),
(4, '10:00:00', '18:00:00', 'Monday'),
(4, '10:00:00', '18:00:00', 'Tuesday'),
(4, '10:00:00', '18:00:00', 'Wednesday'),
(4, '10:00:00', '18:00:00', 'Thursday'),
(4, '10:00:00', '18:00:00', 'Friday'),
(4, '16:00:00', '24:00:00', 'Saturday'),
(4, '16:00:00', '24:00:00', 'Sunday'),
(5, '09:00:00', '11:00:00', 'Monday'),
(5, '09:00:00', '11:00:00', 'Tuesday'),
(5, '09:00:00', '11:00:00', 'Wednesday'),
(5, '09:00:00', '11:00:00', 'Thursday'),
(5, '09:00:00', '11:00:00', 'Friday'),
(5, '10:00:00', '18:00:00', 'Saturday'),
(5, '10:00:00', '18:00:00', 'Sunday');

INSERT INTO city(city_name)
VALUES ('Cincinnati'), ('Columbus');

INSERT INTO city_landmarks(city_id, landmark_id)
VALUES (1, 1),
(1, 3),
(2, 3),
(2, 4),
(1, 2),
(1, 5);

INSERT INTO images(landmark_id, url)
VALUES (1, 'https://cdn2.cincinnatimagazine.com/wp-content/uploads/sites/5/2019/07/AUG19_Tourist_CAM03.jpg'),
(2, 'https://cloudfront-us-east-1.images.arcpublishing.com/coxohio/4EXWDQ5EWNYM6JL7UYDUHTMD5U.jpg'),
(3, 'https://www.skylinechili.com/wp-content/uploads/2019/03/menu-coney-rotated90.png'),
(3, 'https://www.gannett-cdn.com/presto/2019/12/13/PCIN/79fb37ba-cf5b-48bc-a1c0-d1e6e909cdd6-Kaple.jpg?crop=2047,1151,x1,y597&width=2047&height=1151&format=pjpg&auto=webp'),
(4, 'https://render.fineartamerica.com/images/images-profile-flow/400/images/artworkimages/mediumlarge/3/roebling-to-cincy-sunset-mountain-dreams.jpg'),
(5, 'https://www.turnerconstruction.com/Files/ProjectImage?url=%2Fsites%2Fmarketingstories%2FMarketing%20Story%20Images%2Foriginal.4c4ef000-53a6-4820-b71b-9a9d81ca9df0.jpg&width=707&height=470&crop=True&jpegQuality=95');
COMMIT TRANSACTION;