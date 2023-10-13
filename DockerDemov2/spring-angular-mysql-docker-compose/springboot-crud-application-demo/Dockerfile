# Etape de build avec Maven
FROM maven:3.6.3-openjdk-8 as builder

WORKDIR /app

# Copie du fichier pom.xml et téléchargement des dépendances
COPY springboot-crud-application-demo/pom.xml .
RUN mvn dependency:go-offline

# Copie des fichiers sources et exécution de la construction
COPY springboot-crud-application-demo/src ./src
RUN mvn package -DskipTests


FROM adoptopenjdk/openjdk8:alpine-jre

WORKDIR /app

# Copie de l'artifact JAR depuis l'étape précédente
COPY --from=builder /app/target/crudapplication-0.0.1-SNAPSHOT.jar .

# Exécution de l'application Spring Boot
ENTRYPOINT ["java", "-jar", "crudapplication-0.0.1-SNAPSHOT.jar"]