package com.microservices.EmployeeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = "com.microservices.*")
@EnableDiscoveryClient
//@ComponentScan(value={"com.microservices.EmployeeService.*","com.microservices.EmployeeService.controller"})
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}

/*
 * 3. Implement Service Discovery and Registry
Eureka Server: Create a Eureka server application that acts as the service registry. Other microservices will register with this server.
Define @EnableEurekaServer in your main class.
Configure application.yml to set server port and any other necessary configurations.

4. Create Config Server
Spring Cloud Config Server: Set up a centralized configuration server.
Create a Spring Boot application with @EnableConfigServer.
Configure it to fetch configurations from a Git repository or local file system.

5. Implement Microservices
Microservice Applications: Create multiple microservices that will register with Eureka Server and fetch configurations from Config Server.
Each microservice should have @EnableDiscoveryClient to register with Eureka.
Use @RefreshScope where necessary to enable dynamic configuration refresh.

6. Implement API Gateway
Spring Cloud Gateway: Create an API gateway for routing requests to microservices.
Configure routes in application.yml or via Java configuration.
Add filters for logging, rate limiting, etc.

7. Add Distributed Tracing
Spring Cloud Sleuth with Zipkin: Implement distributed tracing for monitoring and debugging.
Configure Sleuth to send traces to a Zipkin server.
Start a Zipkin server to collect and display traces.

8. Implement Resilience / Hystrix Patterns
Resilience4j: Add resilience patterns like circuit breakers, retry, rate limiting, etc., to your microservices.
Configure resilience behaviors using annotations or programmatically.

9. Implement Load Balancer
Ribbon (optional): Use Ribbon for client-side load balancing.
Configure Ribbon to work with Eureka for service discovery.

10. Testing and Documentation
Unit and Integration Testing: Write unit tests for each microservice and integration tests for the system.
Documentation: Document your APIs, architecture, and any specific configurations.

11. Build and Deployment
Build: Package your applications as JAR files using Maven or Gradle.
Deployment: Deploy your microservices to a cloud platform (e.g., AWS, Azure, GCP) or container orchestration platform (e.g., Kubernetes).

12. Monitoring and Metrics
Actuator and Prometheus (optional): Use Spring Boot Actuator for monitoring and Prometheus for metrics collection.
Configure Actuator endpoints and Prometheus server.

Example Project Structure
ConfigServer (Spring Cloud Config Server)
EurekaServer (Eureka Discovery Server)
Gateway (Spring Cloud Gateway)
ServiceA (Microservice A)
ServiceB (Microservice B)
ZipkinServer (Zipkin Server for Distributed Tracing)

Additional Tips
Versioning: Use version control (Git) for your codebase and follow best practices.
Clean Code: Ensure your code follows clean code principles and best practices.
Security: Implement security measures such as OAuth2, JWT, or SSL/TLS depending on your project requirements.
 *
 * */
