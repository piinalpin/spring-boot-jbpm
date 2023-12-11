# Use the official Maven image as the base image
FROM maven:3.9.4-eclipse-temurin-11-alpine AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml /app

# Copy the rest of the application code to the container
COPY src /app/src

# Build the Maven project
RUN mvn clean package -DskipTests

FROM eclipse-temurin:11-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Copy the application.properties from the build stage
COPY --from=build /app/src/config/application.yaml application.yaml

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar", "-Dspring.config.location=application.yaml"]