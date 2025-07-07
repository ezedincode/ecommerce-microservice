# 🛒 Microservices E-Commerce Application

This is a full-stack microservices-based e-commerce application built with Spring Boot using a robust set of tools and technologies. Each core functionality of the system is isolated into its own service and containerized using Docker.

---

## 📦 Services Overview

| Service                  | Description                                                                 |
| ------------------------ | --------------------------------------------------------------------------- |
| **Product Service**      | Manages product-related operations (CRUD, listing). Uses MongoDB.           |
| **Order Service**        | Handles order placement and management. Uses MySQL.                         |
| **Inventory Service**    | Manages stock levels and product availability. Uses MySQL.                  |
| **Notification Service** | Sends out notifications (email/message broker integration). Uses Kafka.     |
| **API Gateway**          | Acts as the entry point for all clients using **Spring Cloud Gateway MVC**. |

---

## ⚙️ Technologies Used

* **Java 17**
* **Spring Boot**
* **Spring Cloud Gateway MVC**
* **Angular**
* **MongoDB**
* **MySQL**
* **Apache Kafka**
* **Keycloak** (for authentication and authorization)
* **Docker & Docker Compose**

---

## 🚀 How to Run the App (Docker Compose)

### 🧾 Prerequisites

Make sure you have the following installed:

* [Docker](https://docs.docker.com/get-docker/)
* [Docker Compose](https://docs.docker.com/compose/)
* [Java 17](https://adoptium.net/) (required for building the Spring Boot services if you plan to build manually)

---

### 🧑‍💻 Steps to Run

1. **Build Docker images** (if not already built)

   ```bash
   docker-compose build
   ```

2. **Start all containers**

   ```bash
   docker-compose up
   ```

3. **Access Key Services:**

| Component         | URL                                              |
| ----------------- | ------------------------------------------------ |
| API Gateway       | [http://localhost:8080](http://localhost:8080)   |
| Keycloak Admin    | [http://localhost:8181](http://localhost:8181)   |
| RabbitMQ UI       | [http://localhost:15672](http://localhost:15672) |
| Zipkin Tracing    | [http://localhost:9411](http://localhost:9411)   |
| MongoDB           | localhost:27017                                  |
| MySQL (Orders DB) | localhost:3308                                   |
| MySQL (Inventory) | localhost:3307                                   |

---

## 🔐 Authentication

Keycloak is used to secure the services.

* **Admin Console:** [http://localhost:8181](http://localhost:8181)
* **Username:** `admin`
* **Password:** `admin`

---

## 🧹 Clean Up

To stop and remove containers, networks, and volumes:

```bash
docker-compose down -v
```

---

## 📬 Feedback or Contributions

Feel free to open issues or pull requests to improve this project.

Let me know your actual email if you want to replace `ezedinahmed2021@example.com`. I’ll help update it again or export the README file for you.

