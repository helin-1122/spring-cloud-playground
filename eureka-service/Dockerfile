FROM openjdk:8
ADD target/docker-eureka-service.jar docker-eureka-service.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "docker-eureka-service.jar"]