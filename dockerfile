FROM amazoncorreto:11-alpine-jdk
MAINTAINER GM
COPY target/ap-0.0.1-SNAPSHOT.jar ap-app.jar
ENTRYPOINT ["java","-jar","/ap-app.jar"]


