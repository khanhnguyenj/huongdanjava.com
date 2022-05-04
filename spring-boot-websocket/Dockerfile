FROM openjdk:11.0.15-jre

VOLUME /tmp

ADD target/spring-boot-websocket-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT exec java -jar app.war