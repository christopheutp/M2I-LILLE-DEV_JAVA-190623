# Étape 1 : Utiliser l'image Maven avec OpenJDK 15 comme image de base, en nommant cette étape "builder"
FROM maven:3.6.3-openjdk-15-slim as builder

# Définir le répertoire de travail à "/app" dans le conteneur
WORKDIR /app

# Copier le fichier "pom.xml" depuis le répertoire local (du contexte de build) vers le répertoire de travail du conteneur
COPY pom.xml .

# Copier le répertoire "src" depuis le répertoire local (du contexte de build) vers le sous-répertoire "/app/src" du conteneur
COPY src/ /app/src/

# Exécuter la commande "mvn package" pour construire l'application Java à partir des sources et générer le fichier JAR
RUN mvn package

# Étape 2 : Utiliser l'image AdoptOpenJDK 15 comme image de base pour l'étape de production (pas de nom d'étape)
FROM adoptopenjdk/openjdk15:jre-15.0.1_9

# Copier le fichier JAR généré lors de l'étape précédente ("builder") vers le répertoire racine du conteneur et le renommer en "app.jar"
COPY --from=builder /app/target/*.jar /app.jar

# Définir la commande par défaut à exécuter lorsque le conteneur est démarré
CMD ["java", "-jar", "/app.jar"]

