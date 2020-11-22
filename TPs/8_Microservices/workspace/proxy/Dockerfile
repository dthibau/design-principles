FROM java:8-jre
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/proxy.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/proxy.jar"]

EXPOSE 8081
