FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/record-service-0.0.1-SNAPSHOT.jar recordService.jar
ENTRYPOINT ["java", "-jar", "recordService.jar"]