cd asanja
bash ./gradlew clean
bash ./gradlew bootJar
sudo docker build -t asanja-server .
cd ..
sudo docker-compose up
