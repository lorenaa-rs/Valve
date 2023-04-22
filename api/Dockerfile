FROM openjdk:17-jdk-alpine
LABEL maintainer="Lorena Ríos <lorerios.2000@gmail.com>"
ADD target/api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]