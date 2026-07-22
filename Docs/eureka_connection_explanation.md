# Microservices Connection to Eureka Server

In the `viva-academy` project, the microservices architecture uses **Spring Cloud Netflix Eureka** for service discovery. This allows microservices to register themselves and discover other services without hardcoding hostnames and ports.

Here is a step-by-step breakdown of how the connection is established, based on the current codebase:

## 1. The Eureka Server (`infrastructure/discovery`)

The `discovery` service acts as the central registry. 

**Dependencies:**
It includes the `spring-cloud-starter-netflix-eureka-server` dependency in its `pom.xml`.

**Annotations:**
In the main application class `DiscoveryApplication.java`, it is annotated with `@EnableEurekaServer`:
```java
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication { ... }
```
This tells Spring Boot to run this application as a Eureka Server registry.

**Configuration (`application.properties`):**
```properties
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```
- It runs on the default Eureka port `8761`.
- `register-with-eureka=false` and `fetch-registry=false` are set because this is the server itself; it doesn't need to register with another Eureka instance or fetch its own registry.

---

## 2. The Microservice Clients (e.g., `services/students`)

The microservices (like the `students` service) act as Eureka Clients that register themselves with the Eureka Server.

**Dependencies:**
They include the `spring-cloud-starter-netflix-eureka-client` dependency in their `pom.xml`.

**Annotations:**
In the main application class (e.g., `StudentsApplication.java`), the application is annotated with `@EnableDiscoveryClient`:
```java
@SpringBootApplication
@EnableDiscoveryClient
public class StudentsApplication { ... }
```
This enables the service to be automatically registered with the Eureka Server upon startup.

**Configuration (`application.properties`):**
```properties
spring.application.name=students
server.port=8080
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```
- `spring.application.name`: This is a crucial property. It defines the name under which the service will be registered in Eureka (e.g., `students`). Other services will use this name to look up its location.
- `eureka.client.service-url.defaultZone`: This property tells the microservice *where* the Eureka Server is located so it knows where to send its registration heartbeat. In this case, it points to `http://localhost:8761/eureka/`.

## 3. How the Connection Works in Practice

1. **Server Startup**: You start the `discovery` service first. It begins listening on port `8761`.
2. **Client Startup**: You start the `students` service. Upon startup, the `@EnableDiscoveryClient` annotation triggers the Eureka client libraries.
3. **Registration**: The `students` service reads `eureka.client.service-url.defaultZone` and sends an HTTP POST request to `http://localhost:8761/eureka/` containing its metadata (IP address, port `8080`, and app name `students`).
4. **Heartbeats**: The `students` service periodically sends heartbeats to the Eureka server to indicate it is still alive. If the Eureka server stops receiving these heartbeats, it will eventually remove the `students` service from its registry.
5. **Discovery**: If another service (like an `api-gateway` or `admin` service) needs to communicate with the `students` service, it will ask the Eureka Server: *"Where is the 'students' service located?"*. Eureka will respond with the IP and port, allowing the communication to happen dynamically.
