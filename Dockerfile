FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/recordservice.jar recordservice.jar
ENTRYPOINT ["java", "-jar", "recordservice.jar"]
