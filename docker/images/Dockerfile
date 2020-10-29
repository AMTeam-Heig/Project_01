#multistage
FROM openliberty/open-liberty:kernel-java11-openj9-ubi AS openliberty

# ---
COPY --chown=1001:0 ./openliberty/liberty/config/ /config/
COPY --chown=1001:0 ./openliberty/liberty/artifact/*.war /config/apps
EXPOSE 9080
#mysql
FROM mysql:8.0.21 AS mysql

ADD ./mysql/database/ /docker-entrypoint-initdb.d
EXPOSE  3306:3306
#phpmyadmin
FROM phpmyadmin/phpmyadmin:latest  AS phpmyadmin
EXPOSE 6060:80
