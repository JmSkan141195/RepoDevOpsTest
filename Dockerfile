FROM openjdk:11
MAINTAINER Mohammed Iskander Jouini <mohammediskander.jouini@esprit.tn>


COPY ./target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "/tpAchatProject-1.0.jar"]
