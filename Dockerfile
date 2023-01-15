FROM amazoncorretto:11-alpine-jdk
MAINTAINER GM
COPY target/ap-0.0.1-SNAPSHOT.jar GM-app.jar
ENTRYPOINT ["java","-jar","/ap-app.jar"]
