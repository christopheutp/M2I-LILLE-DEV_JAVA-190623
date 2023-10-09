FROM maven:3.6.3 as build
WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN mvn clean package

FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=todo-0.0.1-SNAPSHOT.war
WORKDIR /opt/app
COPY --from=build  /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT [ "java","-jar","todo-0.0.1-SNAPSHOT.war"]