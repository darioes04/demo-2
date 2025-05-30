# Etapa de compilación
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY build/books-app-0.0.1-SNAPSHOT.jar /app/books-app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/books-app.jar"]