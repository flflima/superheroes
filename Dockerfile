FROM openjdk:11

WORKDIR /app
COPY ./build/libs/superheroes-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "superheroes-0.0.1-SNAPSHOT.jar"]