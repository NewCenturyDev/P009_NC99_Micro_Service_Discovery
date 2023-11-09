FROM openjdk:21-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY build/libs/P009_NC99_Micro_Service_Discovery-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
