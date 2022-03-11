### Steps

1. Go to folder /config-service, and start applications with docker compose
```
docker-compose up --build
```
2. Show reservation-service  message from spring cloud config server (see reservation-service.properties)
```
curl http://localhost:8000/message
```
3. If reservation-service.properties changed, we can refresh via spring-actuator endpoint
```
curl -d{} -H "Content-Type:application/json" http://localhost:8000/actuator/refresh
```
4. Service registration and discovery using spring-cloud-netflix-eureka



