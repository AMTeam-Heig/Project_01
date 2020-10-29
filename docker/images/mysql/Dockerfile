FROM mysql:8.0.21
ENV MYSQL_DATABASE=MySqlLib \
    MYSQL_ROOT_PASSWORD=root

ADD database/ /docker-entrypoint-initdb.d
EXPOSE 3306:3306