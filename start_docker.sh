mvn clean package

cp  ./target/*.war ./docker/images/openliberty/

cd docker/topologies/openliberty/

docker-compose up --build
