#!/bin/bash

# Start MySQL Server
sudo service mysql start

# Start RabbitMQ Server
sudo rabbitmqctl start_app
sudo rabbitmq-plugins enable rabbitmq_stomp

# run
# mvn clean install
# mvn spring-boot:run