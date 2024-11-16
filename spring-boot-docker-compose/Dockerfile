FROM eclipse-temurin:21.0.4_7-jre
VOLUME /tmp
ADD target/spring-boot-docker-compose-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java -jar app.jar