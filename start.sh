#!/bin/bash
# Запускаем MySQL
service mysql start

for script in /sql-scripts/*.sql
do
  mysql < "$script"
done

java -jar /app/my-spring-app.jar