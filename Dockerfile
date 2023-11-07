FROM openjdk:17-jdk-alpine

COPY target/SpringDocker-0.0.1-SNAPSHOT.jar app-1.0.0-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "app-1.0.0-SNAPSHOT.jar" ]