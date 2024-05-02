FROM openjdk:17

WORKDIR /app

COPY target/techfood-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "techfood-0.0.1-SNAPSHOT.jar"]
