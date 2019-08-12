FROM openjdk:8-jdk-alpine
VOLUME ["/tmp"]
EXPOSE 8090
ADD ./target/sumandos-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""

HEALTHCHECK --interval=5m --timeout=3s \
CMD curl -f http://localhost:8090/actuator/health || exit 1

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]