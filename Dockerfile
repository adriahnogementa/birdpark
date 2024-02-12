FROM postgres:latest

RUN apt-get update && \
    apt-get install -y vim && \
    rm -rf /var/lib/apt/lists/*

ENV POSTGRES_DB birdpark
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD Start123!
ENV POSTGRES_PORT 5432

COPY src/main/resources/park_logo.jpg /docker-path-to-logo/

COPY init.sql /docker-entrypoint-initdb.d/
