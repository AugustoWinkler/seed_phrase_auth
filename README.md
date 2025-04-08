# Seed Phrase Generator API 🛡️


![Project](https://img.shields.io/badge/Project-grey?style=for-the-badge)
![Name](https://img.shields.io/badge/seed__phrase__auth🛡️-blue?style=for-the-badge)
![Version](https://img.shields.io/badge/v1.0-purple?style=for-the-badge)


The **Seed Phrase Generator API** is a Spring Boot application designed to generate and authenticate seed phrases. These phrases are commonly used in secure authentication systems, such as cryptocurrency wallets.

---

## Features

- Generate a unique seed phrase for each user  
- Authenticate user-provided seed phrases  
- Securely store seed phrases using SHA-256 hashing  
- Prevent multiple seed phrases per user  

---

## Table of Contents

- Endpoints  
- Technologies Used  
- Project Structure


---

## Endpoints

### 1. Generate Seed Phrase

**POST /seed**

**Description:**  
Generates and stores a new seed phrase for the specified user.

**Query Parameters:**  
- `userId` (required): Positive number representing the user ID.

**Responses:**  
| Status Code | Status      | Description                                |
|-------------|-------------|--------------------------------------------|
| 200         | OK          | Returns the generated seed phrase.         |
| 400         | Bad Request | If the userId is invalid.                  |
| 409         | Conflict    | If the user already has a seed phrase.     |


**Example Request:** 
```bash
curl -X POST "http://localhost:8080/seed?userId=123"
```
**Example Response:**  
```bash
"java python kotlin dart go rust ruby"
```

---

### 2. Authenticate Seed Phrase

**GET /seed/{userId}**

**Description:**  
Authenticates a seed phrase provided by the user.

**Path Parameters:**  
- `userId` (required): The ID of the user.

**Query Parameters:**  
- `seed` (required): The seed phrase to authenticate.

**Responses:**  
| Status Code | Status        | Description                               |
|-------------|---------------|-------------------------------------------|
| 200         | OK            | If the seed phrase is valid.              |
| 400         | Bad Request   | If the userId or seed is invalid.         |
| 401         | Unauthorized  | If the seed phrase is incorrect.          |


**Example Request:** 
```bash
curl -X GET "http://localhost:8080/seed/123?seed=java%20python%20kotlin%20dart%20go%20rust%20ruby"
```


**Example Response:**
```bash
"User Auth Success"
```

---

## Technologies Used
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)

---

## Project Structure

```bash
src/
├── main/
│   ├── java/
│   │   └── seed_phrase_generator/
│   │       ├── SeedgenApplication.java      # Main application entry point
│   │       ├── config/                      # Database configuration
│   │       ├── controller/                  # REST controllers
│   │       ├── dto/                         # Data Transfer Objects
│   │       ├── exception/                   # Custom exceptions and handlers
│   │       ├── factory/                     # Seed phrase generation logic
│   │       ├── model/                       # JPA entities
│   │       ├── repository/                  # Database repositories
│   │       └── service/                     # Business logic
│           └── service/impl/                # implementations
│   └── resources/
│       └── application.properties           # Application configuration

```
