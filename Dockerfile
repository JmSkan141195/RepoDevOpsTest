FROM openjdk:11
MAINTAINER Gaaieb youssef <gaaiebyoussef@gmail.com>


COPY ./target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "/tpAchatProject-1.0.jar"]
