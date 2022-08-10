BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO landmarks(landmark_name, category, description, up_ratings, down_ratings)
VALUES ('Cincinnati Art Museum', 'Art Museum', 'The Cincinnati Art Museum is an art museum in the Eden Park neighborhood of Cincinnati, Ohio. Founded in 1881, it was the first purpose-built art museum west of the Alleghenies, and is one of the oldest in the United States.', 101, 15),
('Reds Stadium', 'Stadium', 'Great American Ball Park is a baseball stadium in Cincinnati, Ohio. It serves as the home stadium of the Cincinnati Reds of Major League Baseball, and opened on March 31, 2003, replacing Cinergy Field, the Reds home field from 1970 to 2002.', 245, 12),
('Skyline Chili', 'Restaurant', 'Skyline Chili is a chain of Cincinnati-style chili restaurants based in Cincinnati, Ohio. Founded in 1949 by Greek immigrant Nicholas Lambrinides, Skyline Chili is named for the view of Cincinnatis skyline that Lambrinides could see from his first restaurant, opened in the section of town now known as Price Hill.', 9001, 10),
('Roebling Suspension Bridge', 'Suspension Bridge', 'The John A. Roebling Suspension Bridge, originally known as the Cincinnati-Covington Bridge, spans the Ohio River between Cincinnati, Ohio, and Covington, Kentucky. ', 6001, 82),
('Esporta', 'Gym', 'LA Fitness is an American gym chain with more than 700 clubs across the United States and Canada. The company was formed in 1984 and is based in Irvine, California.', 405, 135);

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
(2, '08:00:00', '14:00:00', 7),
(3, '06:00:00', '22:00:00', 1),
(3, '06:00:00', '22:00:00', 2),
(3, '06:00:00', '22:00:00', 3),
(3, '06:00:00', '22:00:00', 4),
(3, '06:00:00', '22:00:00', 5),
(3, '09:00:00', '19:00:00', 6),
(3, '09:00:00', '15:00:00', 7),
(4, '10:00:00', '18:00:00', 1),
(4, '10:00:00', '18:00:00', 2),
(4, '10:00:00', '18:00:00', 3),
(4, '10:00:00', '18:00:00', 4),
(4, '10:00:00', '18:00:00', 5),
(4, '16:00:00', '24:00:00', 6),
(4, '16:00:00', '24:00:00', 7),
(5, '09:00:00', '11:00:00', 1),
(5, '09:00:00', '11:00:00', 2),
(5, '09:00:00', '11:00:00', 3),
(5, '09:00:00', '11:00:00', 4),
(5, '09:00:00', '11:00:00', 5),
(5, '10:00:00', '18:00:00', 6),
(5, '10:00:00', '18:00:00', 7);

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
(5, 'https://s3-media0.fl.yelpcdn.com/bphoto/WFQInBZ_kCCrr7KxMfSf-g/348s.jpg'),
(5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHS7qwt5xgRwb6V_9229am9PE781F5rCGh7gTgXFtZoPNdncaPFXoNDNLgTLM4Zlj5l8g&usqp=CAU'),
(5, 'https://images.fitnessintl.com/images/CMS/ESP/HomePage/TopCarousel_VideoBG/JoinNow_Rate_Desktop_20220404.jpg');

COMMIT TRANSACTION;