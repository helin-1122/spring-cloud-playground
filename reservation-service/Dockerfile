FROM openjdk:8
ADD target/docker-reservation-service.jar docker-reservation-service.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "docker-reservation-service.jar"]