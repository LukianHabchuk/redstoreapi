FROM openjdk:11.0.10-jdk
COPY target/redstoreapi.jar redstoreapi.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "redstoreapi.jar"]