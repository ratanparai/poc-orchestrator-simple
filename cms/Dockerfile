FROM openjdk:8-jdk-alpine
EXPOSE 8080
WORKDIR /app
COPY target/cms-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "cms-0.0.1-SNAPSHOT.jar" ]