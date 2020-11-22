FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./reactive-controller.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/reactive-controller.jar"]

EXPOSE 8080
