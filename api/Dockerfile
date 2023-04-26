FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENV DB_URL=jdbc:mysql://mysql:3306/steam_api
ENV DB_USERNAME=prueba
ENV DB_PASSWORD=prueba
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
