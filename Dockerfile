FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.14_9

EXPOSE 8080

ENV INSTANCE_NUM=3

WORKDIR appDirdock

COPY target/ServiceAutorizate-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]