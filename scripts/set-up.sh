# install dependencies
sudo apt install maven
sudo apt-get install openjdk-17-jdk

# clone repos
git clone https://github.com/cole-gannaway/mix-quest-api.git
git clone https://github.com/cole-gannaway/mix-quest-front-end.git

# install dependencies
cd mix-quest-front-end/
npm install

cd ../mix-quest-api
mvn clean install -DskipTests

# MYSQL
sudo mysql
CREATE USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';

# RabbitMQ 
sudo rabbitmq-plugins enable rabbitmq_management
sudo rabbitmqctl add_user root root
sudo rabbitmqctl set_user_tags root administrator
sudo rabbitmqctl set_permissions -p / root ".*" ".*" ".*"