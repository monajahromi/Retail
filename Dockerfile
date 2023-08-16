# Dockerfile for Retail
# Author: Mona Jahromi
#FROM openjdk:11-jre-slim
#WORKDIR /app
#COPY target/Retial.jar /app/Retial.jar
#CMD ["java", "-jar", "Retial.jar"]


# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-17-slim AS build
# Set the working directory inside the container
WORKDIR /app
# Copy the project's pom.xml file into the container
COPY pom.xml .
# Download the project dependencies
RUN mvn dependency:go-offline
COPY src/ /app/src/
COPY retailDB*/ /app/
RUN mvn package
# Use the OpenJDK runtime as the final image
FROM openjdk:17-slim
# Set the working directory inside the container
WORKDIR /app
# Copy the compiled JAR file from the build stage
COPY --from=build /app/target/Retail-0.0.1.jar /app/Retail-0.0.1.jar

# Specify the command to run your application
CMD ["java", "-jar", "Retail-0.0.1.jar"]