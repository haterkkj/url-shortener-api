# URL Shortener API

> 🇧🇷 This README is also available in [Portuguese (README_pt-BR.md)](./README_pt-BR.md)

This project is a Java Spring Boot API for URL shortening. It allows you to convert long URLs into short ones, making sharing and organizing easier.

## Features

This application allows you to:

- Register a long URL and get a shortened URL.
- Automatically redirect to the original URL when accessing the shortened one.
- Delete shortened URLs from the system.

## Technologies Used

- Java 17
- Spring Boot
- PostgreSQL
- Flyway (database migrations)
- Docker & Docker Compose

## How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/thiago-f-santos/url-shortener-api.git
cd .\url-shortener-api
```

### 2. Configure PostgreSQL

The application **does not start the PostgreSQL database automatically with Docker Compose**. You must either:

- Have PostgreSQL installed locally **or**
- Run a PostgreSQL container separately.

#### Using Docker Compose

Create a `.env` file in the root of the project with the following variables:

```env
DB_CONNECTION_STRING=jdbc:postgresql://DATABASE:PORT/urlshortener
DB_USERNAME=postgres
DB_PASSWORD=root
```

> 💡 `host.docker.internal` allows the application container to access PostgreSQL running outside of Docker. On Linux, you may need to use the host IP or set up a custom Docker network.

#### Without Docker Compose

You can configure the connection directly in your environment or by modifying the `application.yml` with the desired values:

```yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/urlshortener
    username: postgres
    password: root
```

The application also supports environment variables:

```yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: ${DB_CONNECTION_STRING:jdbc:postgresql://localhost:5432/urlshortener}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:root}
```

> ✅ The username, password, and port **can be customized**, as long as they match your database configuration.

Make sure the database is created and accessible before starting the application.

### 3. Run the Application with Docker Compose

```bash
docker-compose up --build
```

This will:

- Build the application image.
- Apply Flyway migrations.
- Start the Spring Boot application.

> 📌 **Reminder:** PostgreSQL **is not started by this Docker Compose**. You must ensure it's running beforehand.

### 4. Access the Application

The application will be available at:

```
http://localhost:8080
```

API documentation is available via Swagger UI:

```
http://localhost:8080/docs.html
```

## Notes

- Database migrations are located in: `src/main/resources/db/migration`
- Endpoints are documented at `/docs` using OpenAPI.

---

Feel free to customize the `.env` variables and configuration parameters as needed.