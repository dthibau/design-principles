FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./imperative-controller.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/imperative-controller.jar"]

EXPOSE 8080
