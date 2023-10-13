#!/bin/bash

echo Maven clean install
mvn clean install -U -DskipTests=true

echo Springboot run
mvn spring-boot:run
