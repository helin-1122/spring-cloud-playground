### spring-cloud-demo

1. reservation-service configured via reservation-service.properties
```
curl http://localhost:8000/message
```
2. If reservation-service.properties changed, we can refresh via spring-actuator endpoint
```
curl -d{} -H "Content-Type:application/json" http://localhost:8000/actuator/refresh
```
3. Service registration and discovery using spring-cloud-netflix-eureka

