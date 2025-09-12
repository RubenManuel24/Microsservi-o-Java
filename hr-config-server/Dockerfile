FROM openjdk:17
VOLUME /tmp
EXPOSE 8888
WORKDIR /app
COPY ./target/hr-config-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]