
GRANT ALL PRIVILEGES ON DATABASE birdpark TO postgres;

\c birdpark;

CREATE TABLE parkInformation (
    id SERIAL PRIMARY KEY,
    parkname VARCHAR(255) NOT NULL,
    parklogo BYTEA,
    parklocation VARCHAR(255) NOT NULL,
    parkdescription TEXT
);

CREATE TABLE openingTime (
    id SERIAL PRIMARY KEY,
    bird_park_id INT,
    day_of_week VARCHAR(20) NOT NULL,
    opening_time TIME,
    closing_time TIME,
    FOREIGN KEY (bird_park_id) REFERENCES parkInformation(id)
);

CREATE TABLE ticketPrice (
    id SERIAL PRIMARY KEY,
    bird_park_id INT,
    ticket_type VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2),
    FOREIGN KEY (bird_park_id) REFERENCES parkInformation(id)
);

CREATE TABLE attractions (
  attraction_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  logo VARCHAR(255),
  description TEXT,
  tags VARCHAR(255),
  tours VARCHAR(255)
);


CREATE TABLE tours (
  tour_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);


CREATE TABLE tags (
  tag_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);


CREATE TABLE attractionTags (
  attraction_id INT,
  tag_id INT,
  PRIMARY KEY (attraction_id, tag_id),
  FOREIGN KEY (attraction_id) REFERENCES Attractions(attraction_id),
  FOREIGN KEY (tag_id) REFERENCES Tags(tag_id)
);


\set image_data `cat '/docker-path-to-logo/park_logo.jpg' | xxd -p | tr -d '\n'`


INSERT INTO parkInformation (parkname, parklocation, parkdescription, parklogo)
VALUES ('Vogelpark Hannover', 'Arpker Str. 21, 30519 Hannover', 'Willkommen im Vogelpark Hannover! Unser Park bietet eine Vielzahl von Vogelarten aus der ganzen Welt. Sogar Emus!', decode(:'image_data', 'hex'));


INSERT INTO openingTime (bird_park_id, day_of_week, opening_time, closing_time)
VALUES (1, 'Montag', '09:00:00', '18:00:00'),
       (1, 'Dienstag', '09:00:00', '18:00:00'),
       (1, 'Mittwoch', '09:00:00', '18:00:00'),
       (1, 'Donnerstag', '09:00:00', '18:00:00'),
       (1, 'Freitag', '09:00:00', '18:00:00'),
       (1, 'Samstag', '10:00:00', '20:00:00'),
       (1, 'Sonntag', '10:00:00', '20:00:00');


INSERT INTO ticketPrice (bird_park_id, ticket_type, price)
VALUES (1, 'Erwachsener', 15.00),
       (1, 'Kind', 8.00),
       (1, 'Senioren', 12.00);


INSERT INTO attractions (attraction_id, name, logo, description, tags, tours)
VALUES
  (1, 'Vogelvoliere', 'vogelvoliere_logo.jpg', 'Eine große Voliere, in der verschiedene Vogelarten leben.', 'Vögel, Voliere, Tropisch', 'Vogeltour'),
  (2, 'Flugshow', 'flugshow_logo.jpg', 'Eine spektakuläre Flugshow mit verschiedenen Vogelarten.', 'Vögel, Show, Flug', 'Vogeltour, Showtour'),
  (3, 'Pinguin-Gehege', 'pinguin_gehege_logo.jpg', 'Ein Gehege, in dem Pinguine leben und schwimmen.', 'Pinguine, Gehege, Wasser', 'Vogeltour'),
  (4, 'Tropenhaus', 'tropenhaus_logo.jpg', 'Ein Tropenhaus mit exotischen Vögeln, Pflanzen und Wasserfällen.', 'Vögel, Tropisch, Tiere, Pflanzen', 'Tropentour, Vogeltour');


INSERT INTO tours (tour_id, name)
VALUES
  (1, 'Vogeltour'),
  (2, 'Showtour'),
  (3, 'Tropentour');


INSERT INTO tags (tag_id, name)
VALUES
  (1, 'Vögel'),
  (2, 'Voliere'),
  (3, 'Tropisch'),
  (4, 'Show'),
  (5, 'Flug'),
  (6, 'Pinguine'),
  (7, 'Gehege'),
  (8, 'Wasser'),
  (9, 'Tiere'),
  (10, 'Pflanzen');


INSERT INTO attractionTags (attraction_id, tag_id)
VALUES
  (1, 1), -- Vögel
  (1, 2), -- Voliere
  (1, 3), -- Tropisch
  (2, 1), -- Vögel
  (2, 4), -- Show
  (2, 5), -- Flug
  (3, 1), -- Vögel
  (3, 6), -- Pinguine
  (3, 7), -- Gehege
  (3, 8), -- Wasser
  (4, 1), -- Vögel
  (4, 3), -- Tropisch
  (4, 9), -- Tiere
  (4, 10); -- Pflanzen

