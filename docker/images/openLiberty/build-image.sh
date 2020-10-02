#!/bin/bash

#make sure that we generate the WAR
mvn  -f ../../../pom.xml clean package
#build the image by the Dockerfile
docker build -t project_01/stackovergoat
