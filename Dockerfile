FROM postgres:latest

ENV POSTGRES_DB birdpark
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD Start123!
ENV POSTGRES_PORT 5432

COPY init.sql /docker-entrypoint-initdb.d/
