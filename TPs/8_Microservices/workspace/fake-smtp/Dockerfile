FROM java:8-jre
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./fakeSMTP-2.0.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/fakeSMTP-2.0.jar", "-s", "-b", "-p", "2525"]

EXPOSE 2525
