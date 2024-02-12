FROM postgres:latest

RUN apt-get update && \
    apt-get install -y vim && \
    rm -rf /var/lib/apt/lists/*

ENV POSTGRES_DB birdpark
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD Start123!
ENV POSTGRES_PORT 5432

COPY src/main/resources/aviary_adventure_logo.jpg /docker-path-to-logo/
COPY src/main/resources/eagle_canyon_logo.jpg /docker-path-to-logo/
COPY src/main/resources/flug_show_logo.jpg /docker-path-to-logo/
COPY src/main/resources/park_logo.jpg /docker-path-to-logo/
COPY src/main/resources/parrot_paradise_logo.jpg /docker-path-to-logo/
COPY src/main/resources/penguin_cove_logo.jpg /docker-path-to-logo/
COPY src/main/resources/pinguin_gehege_logo.jpg /docker-path-to-logo/
COPY src/main/resources/toucan_trail_logo.jpg /docker-path-to-logo/
COPY src/main/resources/tropenhaus_logo.jpg /docker-path-to-logo/
COPY src/main/resources/vogelvoliere_logo.jpg /docker-path-to-logo/

COPY init.sql /docker-entrypoint-initdb.d/
