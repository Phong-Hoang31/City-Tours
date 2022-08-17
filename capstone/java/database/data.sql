BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO landmark(landmark_name, category, description, up_ratings, down_ratings, address, price)
VALUES ('Cincinnati Art Museum', 'Art Museum', 'The Cincinnati Art Museum is an art museum in the Eden Park neighborhood of Cincinnati, Ohio. Founded in 1881, it was the first purpose-built art museum west of the Alleghenies, and is one of the oldest in the United States.', 101, 15,'953 Eden Park Dr, Cincinnati, OH 45202','$'),
('Reds Stadium', 'Stadium', 'Great American Ball Park is a baseball stadium in Cincinnati, Ohio. It serves as the home stadium of the Cincinnati Reds of Major League Baseball, and opened on March 31, 2003, replacing Cinergy Field, the Reds home field from 1970 to 2002.', 245, 12,'100 Joe Nuxhall Way, Cincinnati, OH 45202','$$$'),
('Skyline Chili', 'Restaurant', 'Skyline Chili is a chain of Cincinnati-style chili restaurants based in Cincinnati, Ohio. Founded in 1949 by Greek immigrant Nicholas Lambrinides, Skyline Chili is named for the view of Cincinnatis skyline that Lambrinides could see from his first restaurant, opened in the section of town now known as Price Hill.', 9001, 10,'290 Ludlow Ave, Cincinnati, OH 45220','$$'),
('Roebling Suspension Bridge', 'Suspension Bridge', 'The John A. Roebling Suspension Bridge, originally known as the Cincinnati-Covington Bridge, spans the Ohio River between Cincinnati, Ohio, and Covington, Kentucky. ', 6001, 82,'John A. Roebling Suspension Bridge, Covington, KY 41011','$'),
('Cincinnati Zoo & Botanical Garden', 'Zoo', 'The Cincinnati Zoo & Botanical Garden is the second oldest zoo in the United States, founded in 1873 and officially opening in 1875, after the Roger Williams Park Zoo. It is located in the Avondale neighborhood of Cincinnati, Ohio.', 405, 11,' 3400 Vine St, Cincinnati, OH 45220','$$$'),
('Lindner Family Tennis Center', 'Stadium', 'The Lindner Family Tennis Center is a tennis facility in Mason, Ohio. It is the home of the Western & Southern Open and is owned by Tennis for Charity, Inc.', 1027, 56, '5460 Courseview Dr, Mason, OH 45040', '$$$');


INSERT INTO schedule(landmark_id, open_time, close_time, day_of_week)
VALUES (1, '8:00 AM', '8:00 PM', 'Monday'),
(1, '8:00 AM', '8:00 PM', 'Tuesday'),
(1, '8:00 AM', '8:00 PM', 'Wednesday'),
(1, '8:00 AM', '8:00 PM', 'Thursday'),
(1, '8:00 AM', '8:00 PM', 'Friday'),
(1, '10:00 AM', '8:00 PM', 'Saturday'),
(1, '10:00 AM', '2:00 PM', 'Sunday'),
(2, '5:00 AM', '10:00 PM', 'Monday'),
(2, '5:00 AM', '10:00 PM', 'Tuesday'),
(2, '5:00 AM', '10:00 PM', 'Wednesday'),
(2, '5:00 AM', '10:00 PM', 'Thursday'),
(2, '5:00 AM', '10:00 PM', 'Friday'),
(2, '8:00 AM', '6:00 PM', 'Saturday'),
(2, '8:00 AM', '2:00 PM', 'Sunday'),
(3, '6:00 AM', '10:00 PM', 'Monday'),
(3, '6:00 AM', '10:00 PM', 'Tuesday'),
(3, '6:00 AM', '10:00 PM', 'Wednesday'),
(3, '6:00 AM', '10:00 PM', 'Thursday'),
(3, '6:00 AM', '10:00 PM', 'Friday'),
(3, '9:00 AM', '7:00 PM', 'Saturday'),
(3, '9:00 AM', '3:00 PM', 'Sunday'),
(4, '10:00 AM', '6:00 PM', 'Monday'),
(4, '10:00 AM', '6:00 PM', 'Tuesday'),
(4, '10:00 AM', '6:00 PM', 'Wednesday'),
(4, '10:00 AM', '6:00 PM', 'Thursday'),
(4, '10:00 AM', '6:00 PM', 'Friday'),
(4, '4:00 PM', '12:00 AM', 'Saturday'),
(4, '4:00 PM', '12:00 AM', 'Sunday'),
(5, '9:00 AM', '11:00 PM', 'Monday'),
(5, '9:00 AM', '11:00 PM', 'Tuesday'),
(5, '9:00 AM', '11:00 PM', 'Wednesday'),
(5, '9:00 AM', '11:00 PM', 'Thursday'),
(5, '9:00 AM', '11:00 PM', 'Friday'),
(5, '10:00 AM', '6:00 PM', 'Saturday'),
(5, '10:00 AM', '6:00 PM', 'Sunday'),
(6, '7:00 AM', '9:00 PM', 'Monday'),
(6, '7:00 AM', '9:00 PM', 'Tuesday'),
(6, '7:00 AM', '9:00 PM', 'Wednesday'),
(6, '7:00 AM', '9:00 PM', 'Thursday'),
(6, '7:30 AM', '8:00 PM', 'Friday'),
(6, '8:00 AM', '7:30 PM', 'Saturday'),
(6, '8:00 AM', '7:30 PM', 'Sunday');

INSERT INTO city(city_name)
VALUES ('Cincinnati'), ('Columbus');

INSERT INTO city_landmark(city_id, landmark_id)
VALUES (1, 1),
(1, 3),
(2, 3),
(2, 4),
(1, 2),
(1, 5);

INSERT INTO itinerary(itinerary_name, user_id, starting_point, itinerary_date)
VALUES ('itinerary_1', 1, '42 Starting St.', '20220811');
VALUES ('itinerary_2', 2, '43 Starting St.', '20220812');


INSERT INTO itinerary_landmark(itinerary_id, landmark_id, landmark_order)
VALUES (1, 1, 1),
(1, 2, 2),
(1, 3, 3),
(2,4, 1),
(2,5, 2);

INSERT INTO image(landmark_id, url)
VALUES (1, 'https://cdn2.cincinnatimagazine.com/wp-content/uploads/sites/5/2019/07/AUG19_Tourist_CAM03.jpg'),
(1, 'https://www.gannett-cdn.com/presto/2019/04/19/PCIN/6191cc52-e391-4560-bbb1-59ad42119450-Burning8.JPG?crop=5530,3138,x0,y566&width=3200&height=1816&format=pjpg&auto=webp'),
(1, 'https://thewalters.org/wp-content/uploads/topic_collections.jpg'),
(2, 'https://cloudfront-us-east-1.images.arcpublishing.com/coxohio/4EXWDQ5EWNYM6JL7UYDUHTMD5U.jpg'),
(2, 'https://images.fineartamerica.com/images/artworkimages/mediumlarge/3/the-great-american-ball-park-at-sunset-library-of-congress.jpg'),
(2, 'https://img.mlbstatic.com/mlb-images/image/private/t_16x9/t_w1024/mlb/djdwciyccf0fdnfuhxjd'),
(3, 'https://www.skylinechili.com/wp-content/uploads/2019/03/menu-coney-rotated90.png'),
(3, 'https://cincinnatiusa.com/sites/default/files/styles/Array/public/Venues/2%20ConeyMed.jpg'),
(3, 'https://media.wdwnt.com/2022/07/skyline-chili.jpeg'),
(4, 'https://render.fineartamerica.com/images/images-profile-flow/400/images/artworkimages/mediumlarge/3/roebling-to-cincy-sunset-mountain-dreams.jpg'),
(4, 'https://roeblingbridge.org/Portals/0/EasyDNNRotator/1769/x3bgnbmb.jpg'),
(4, 'https://www.soapboxmedia.com/images/Features/bridge05.jpg'),
(5, 'https://www.turnerconstruction.com/Files/ProjectImage?url=%2Fsites%2Fmarketingstories%2FMarketing%20Story%20Images%2Foriginal.4c4ef000-53a6-4820-b71b-9a9d81ca9df0.jpg&width=707&height=470&crop=True&jpegQuality=95'),
(5, 'https://img2.10bestmedia.com/Images/Photos/315493/p-Cincinnati-Zoo_55_660x440.JPG'),
(5, 'https://cincinnatizoo.org/wp-content/uploads/2014/12/annnuals.jpg'),
(6, 'https://www.gannett-cdn.com/presto/2018/07/19/PCIN/e9efd373-f244-4bd2-92ba-f86460016725-071918_TENNIS_336B.JPG?crop=4991,2794,x0,y0&width=3200&height=1792&format=pjpg&auto=webp'),
(6, 'https://www.tennistours.com/img/seating-guides/ws-open/image5.jpg'),
(6, 'https://s3.amazonaws.com/ustaassets/assets/663/15/event_info_header.jpg');

COMMIT TRANSACTION;