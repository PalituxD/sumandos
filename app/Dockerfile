FROM openjdk:8-jdk-alpine
VOLUME ["/tmp"]
ADD ./target/sumandos-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]
RUN apk --no-cache add curl
CMD ["/bin/sh"]