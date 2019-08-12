#!/bin/bash

source env.sh

sh ./shutdown.sh

echo "Starting... Build Application Jar"
mvn clean install
sleep 1
echo "End... Build Application Jar"

echo "Starting... Build docker images"
docker-compose build
sleep 1
echo "End... Build docker images"

echo "Starting... Run the database"
docker-compose up -d ${ENV_DATABASE_SERVER}
sleep 10
echo "End... Run the database"

echo "Starting... Run the application"
docker-compose up -d ${ENV_APPLICATION_SERVER}
sleep 20
echo "End... Run the application"

echo "Starting... Run other tools"
docker-compose up -d
sleep 10
echo "End... Run other tools"

sleep 1
echo "Enjoy the application"

# -DMY_DATABASE_SERVER=localhost -DMY_DATABASE_DATABASE=testdb -DMY_DATABASE_PORT=3306 -DMY_DATABASE_USER=user -DMY_DATABASE_PASSWORD=password