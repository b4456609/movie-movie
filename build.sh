#!bin/bash
./gradlew bootRepackage
docker build -t movie-movie:latest -t movie-movie:${1} .