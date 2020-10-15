#mvn clean install

mvn clean package

cp ./target/Project_01.war ./docker/images/openliberty/liberty/artifact

cd docker/topologies/

docker-compose up --build
