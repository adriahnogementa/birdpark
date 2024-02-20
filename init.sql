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

CREATE TABLE tour (
  tour_id INT PRIMARY KEY,
  logo BYTEA,
  price DECIMAL(10, 2),
  duration_in_minutes INT,
  name VARCHAR(255) NOT NULL,
  begin_time TIME,
  end_time TIME
);

CREATE TABLE attractions (
  attraction_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  logo BYTEA,
  description TEXT,
  duration_in_minutes INT
);


CREATE TABLE tags (
  tag_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);


CREATE TABLE attractionTags (
  attraction_id INT,
  tag_id INT,
  PRIMARY KEY (attraction_id, tag_id),
  FOREIGN KEY (attraction_id) REFERENCES Attractions(attraction_id) ON DELETE CASCADE,
  FOREIGN KEY (tag_id) REFERENCES Tags(tag_id) ON DELETE CASCADE
);

CREATE TABLE attractionTours (
  attraction_id INT,
  tour_id INT,
  tour_order INT,
  PRIMARY KEY (attraction_id, tour_id),
  FOREIGN KEY (attraction_id) REFERENCES Attractions(attraction_id) ON DELETE CASCADE,
  FOREIGN KEY (tour_id) REFERENCES Tour(tour_id) ON DELETE CASCADE
);


\set park_logo `cat '/docker-path-to-logo/park_logo.jpg' | xxd -p | tr -d '\n'`

\set flugshow_logo `cat '/docker-path-to-logo/flug_show_logo.jpg' | xxd -p | tr -d '\n'`

\set pinguin_gehege_logo `cat '/docker-path-to-logo/pinguin_gehege_logo.jpg' | xxd -p | tr -d '\n'`

\set tropenhaus_logo `cat '/docker-path-to-logo/tropenhaus_logo.jpg' | xxd -p | tr -d '\n'`

\set toucan_trail_logo `cat '/docker-path-to-logo/toucan_trail_logo.jpg' | xxd -p | tr -d '\n'`

\set vogelvoliere_logo `cat '/docker-path-to-logo/vogelvoliere_logo.jpg' | xxd -p | tr -d '\n'`

\set eagle_canyon_logo `cat '/docker-path-to-logo/eagle_canyon_logo.jpg' | xxd -p | tr -d '\n'`

\set parrot_paradise_logo `cat '/docker-path-to-logo/parrot_paradise_logo.jpg' | xxd -p | tr -d '\n'`

\set penguin_cove_logo `cat '/docker-path-to-logo/penguin_cove_logo.jpg' | xxd -p | tr -d '\n'`

\set aviary_adventure_logo `cat '/docker-path-to-logo/aviary_adventure_logo.jpg' | xxd -p | tr -d '\n'`

\set vogeltour_logo `cat '/docker-path-to-logo/vogeltour_logo.jpg' | xxd -p | tr -d '\n'`

\set showtour_logo `cat '/docker-path-to-logo/showtour_logo.jpg' | xxd -p | tr -d '\n'`

\set tropentour_logo `cat '/docker-path-to-logo/tropentour_logo.jpg' | xxd -p | tr -d '\n'`


INSERT INTO parkInformation (parkname, parklocation, parkdescription, parklogo)
VALUES ('Vogelpark Hannover', 'Arpker Str. 21, 30519 Hannover', 'Willkommen im Vogelpark Hannover! Unser Park bietet eine Vielzahl von Vogelarten aus der ganzen Welt. Sogar Emus!', decode(:'park_logo', 'hex'));


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

INSERT INTO tour (tour_id,logo, price, name, begin_time)
VALUES
  (1, decode(:'vogeltour_logo','hex'), 25.00 ,'Vogeltour', '10:00:00'),
  (2, decode(:'showtour_logo','hex'), 30.00 ,'Showtour', '12:00:00'),
  (3, decode(:'tropentour_logo','hex'), 35.00 ,'Tropentour', '14:00:00');


INSERT INTO attractions (attraction_id, name, logo, description, duration_in_minutes)
VALUES
  (1, 'Vogelvoliere', decode(:'vogelvoliere_logo', 'hex'), 'Eine große Voliere, in der verschiedene Vogelarten leben.',45),
  (2, 'Flugshow', decode(:'flugshow_logo', 'hex'), 'Eine spektakuläre Flugshow mit verschiedenen Vogelarten.',30),
  (3, 'Pinguin-Gehege', decode(:'pinguin_gehege_logo', 'hex'), 'Ein Gehege, in dem Pinguine leben und schwimmen.',20),
  (4, 'Tropenhaus', decode(:'tropenhaus_logo', 'hex'), 'Ein Tropenhaus mit exotischen Vögeln, Pflanzen und Wasserfällen.', 60),
  (5, 'Toucan Trail', decode(:'toucan_trail_logo', 'hex'), 'Ein gewundener Pfad durch einen üppigen Dschungel voller bunter Tukane und anderer tropischer Vögel.', 15),
  (6, 'Eagle Canyon', decode(:'eagle_canyon_logo', 'hex'), 'Ein weitläufiger Canyon, in dem majestätische Adler hoch oben schweben.', 30),
  (7, 'Parrot Paradise', decode(:'parrot_paradise_logo', 'hex'), 'Ein lebendiges Paradies, in dem verspielte Papageien die Besucher mit ihren Possen unterhalten.', 30),
  (8, 'Pingu Höhle', decode(:'penguin_cove_logo', 'hex'), 'Eine kühle Bucht, in der niedliche Pinguine im eisigen Wasser watscheln und schwimmen.', 40),
  (9, 'Flug Abenteuer', decode(:'aviary_adventure_logo', 'hex'), 'Ein beeindruckendes Volierenerlebnis, bei dem die Besucher zwischen frei fliegenden Vögeln aus aller Welt spazieren können.', 60);


INSERT INTO attractionTours (attraction_id, tour_id, tour_order)
VALUES
  (1, 1, 1),
  (2, 1, 2),
  (3, 1, 3),
  (9 ,1, 4),
  (4, 3, 1),
  (5, 3, 2),
  (6, 3, 3),
  (9, 3, 4),
  (7, 2, 1),
  (8, 2, 2),
  (9, 2, 3),
  (1, 2, 4);

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
  (10, 'Pflanzen'),
  (11, 'Jungle'),
  (12, 'Toucans'),
  (13, 'Adler'),
  (14, 'Panoramablick'),
  (15, 'Papageien'),
  (16, 'Interaktiv'),
  (17, 'Niedlich'),
  (18, 'Eisiges Wasser'),
  (19, 'Freifliegend');

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
  (4, 10),  --  Pflanzen
  (5, 11), -- Jungle
  (5, 12), -- Toucans
  (5, 3),  -- Tropical
  (5, 1),  -- Birds
  (6, 13), -- Eagles
  (6, 14), -- Scenic Views
  (6, 1),  -- Birds
  (7, 15), -- Parrots
  (7, 17), -- Adorable
  (7, 16), -- Interactive
  (8, 6),  -- Penguins
  (8, 8),  -- Icy Waters
  (8, 1),  -- Birds
  (8, 18), -- Icy Waters
  (9, 1),  -- Birds
  (9, 16), -- Interactive
  (9, 19); -- Free-flying

UPDATE tour AS t
SET duration_in_minutes = subquery.total_duration
FROM (
    SELECT
        attt.tour_id,
        SUM(att.duration_in_minutes) AS total_duration
    FROM
        attractionTours AS attt
    JOIN
        attractions AS att ON attt.attraction_id = att.attraction_id
    GROUP BY
        attt.tour_id
) AS subquery
WHERE
    t.tour_id = subquery.tour_id;

    UPDATE tour AS t
SET end_time = t.begin_time + INTERVAL '1 minute' * (
    SELECT COALESCE(SUM(a.duration_in_minutes), 0)
    FROM attractions AS a
    JOIN attractionTours AS at ON at.attraction_id = a.attraction_id
    WHERE at.tour_id = t.tour_id
);


CREATE OR REPLACE FUNCTION update_tour_duration()
RETURNS TRIGGER AS $$
DECLARE
    tour_duration INT;
BEGIN
    UPDATE tour AS t
    SET duration_in_minutes = subquery.total_duration
    FROM (
        SELECT
            attt.tour_id,
            SUM(att.duration_in_minutes) AS total_duration
        FROM
            attractionTours AS attt
        JOIN
            attractions AS att ON attt.attraction_id = att.attraction_id
        GROUP BY
            attt.tour_id
    ) AS subquery
    WHERE
        t.tour_id = subquery.tour_id;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_tour_duration_trigger_on_attraction_change
AFTER INSERT OR UPDATE OR DELETE ON attractions
FOR EACH STATEMENT
EXECUTE FUNCTION update_tour_duration();

CREATE TRIGGER update_tour_duration_trigger_on_attractiontour_change
AFTER INSERT OR UPDATE OR DELETE ON attractionTours
FOR EACH STATEMENT
EXECUTE FUNCTION update_tour_duration();

CREATE OR REPLACE FUNCTION update_tour_end_time_on_begin_time_change()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE tour
    SET end_time = NEW.begin_time + 
                   INTERVAL '1 minute' * (SELECT COALESCE(SUM(duration_in_minutes), 0)
                                          FROM attractions AS a
                                          JOIN attractionTours AS at ON at.attraction_id = a.attraction_id
                                          WHERE at.tour_id = NEW.tour_id)
    WHERE tour_id = NEW.tour_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_tour_end_time_trigger_on_begin_time_change
AFTER UPDATE OF begin_time ON tour
FOR EACH ROW
EXECUTE FUNCTION update_tour_end_time_on_begin_time_change();

CREATE TRIGGER update_tour_end_time_trigger_on_duration_change
AFTER UPDATE OF duration_in_minutes ON tour
FOR EACH ROW
EXECUTE FUNCTION update_tour_end_time_on_begin_time_change();

CREATE TRIGGER update_tour_duration_trigger_on_tour_change
AFTER UPDATE OF begin_time ON tour
FOR EACH STATEMENT
EXECUTE FUNCTION update_tour_duration();