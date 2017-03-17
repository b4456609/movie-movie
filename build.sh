#!bin/bash
./gradlew bootRepackage
docker build -t movie-movie:latest .