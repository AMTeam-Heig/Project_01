cp  ./target/*.war ./docker/images/openliberty/
# shellcheck disable=SC2164
cd docker/topologies/openliberty/
docker-compose  build
