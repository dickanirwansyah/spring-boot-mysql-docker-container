FROM openjdk:8
ADD target/backend-service.jar backend-service.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "backend-service.jar"]