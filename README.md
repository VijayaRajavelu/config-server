This is a Spring Boot microservice that manages CRUD operations for products and loads configuration dynamically from a Spring Cloud Config Server backed by a GitHub repository.

GitHub Links:
Config Server: https://github.com/VijayaRajavelu/config-server
Config Repository: https://github.com/VijayaRajavelu/config

Architecture:
Product CRUD Service – handles product creation, retrieval, update, and deletion
Config Server – provides centralized configuration from GitHub
GitHub Config Repository – stores environment-specific YAML files (dev, test, prod)

Tech Stack: Java 17, Spring Boot, Spring Data JPA (or your DB if you added one), Spring Cloud Config Client, Spring Boot Actuator (/actuator/refresh), GitHub (for externalized configuration)

How It Works?
The service starts and connects to the Config Server at: http://localhost:8888/product_crud/{profile}
The Config Server fetches the relevant config file from GitHub (e.g., product_crud-dev.yml)
Beans annotated with @RefreshScope automatically reload updated configuration when /actuator/refresh is called

Example Config Files (loaded from Config Server)
product_crud-dev.yml
product_crud-test.yml
product_crud-prod.yml

Run Locally
1. Clone repository:
git clone https://github.com/VijayaRajavelu/product-crud.git
cd product-crud

2. Ensure Config Server is running:
The Product CRUD service depends on the Config Server running at:
http://localhost:8888

3. Change active profile:
Command line:
mvn spring-boot:run -Dspring-boot.run.profiles=dev

IntelliJ IDEA
Run → Edit Configurations
Select ProductCrudApplication
Set Active profiles: dev
or VM options: -Dspring.profiles.active=dev
Run

Dynamic Refresh:
The service demonstrates environment-specific configuration, dynamic refresh with @RefreshScope, and microservice.
Beans using @RefreshScope automatically reload configuration values when the /actuator/refresh endpoint is called.
Example:
curl -X POST http://localhost:8080/actuator/refresh
curl http://localhost:8080/message
