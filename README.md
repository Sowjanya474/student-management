# 🎓 Student Management System

A full-stack **Student Management System** built with Java Spring Boot.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![JWT](https://img.shields.io/badge/JWT-Security-red)

---

## 🚀 Features

- ✅ Add, Edit, Delete, Search Students
- ✅ REST API with full CRUD operations
- ✅ JWT Authentication & Authorization
- ✅ Role Based Access Control (ADMIN / USER)
- ✅ Swagger API Documentation
- ✅ Pagination & Sorting
- ✅ Form Validation & Error Handling
- ✅ Beautiful Web UI with Thymeleaf

---

## 🛠️ Tech Stack

| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.3 |
| Spring Security | JWT |
| Spring Data JPA | Hibernate |
| MySQL | 8.0 |
| Thymeleaf | Web UI |
| Swagger | OpenAPI 3 |
| Maven | Build Tool |

---

## 📁 Project Structure
```
src/main/java/com/guide/studentmanagement/
├── controller/
│   ├── StudentController.java      ← REST API
│   ├── StudentWebController.java   ← Web UI
│   └── AuthController.java         ← JWT Login
├── model/
│   └── Student.java                ← Entity
├── repository/
│   └── StudentRepository.java      ← Database
├── service/
│   └── StudentService.java         ← Business Logic
├── config/
│   ├── SecurityConfig.java         ← Spring Security
│   ├── JwtUtil.java                ← JWT Helper
│   ├── JwtFilter.java              ← JWT Filter
│   └── SwaggerConfig.java          ← API Docs
└── exception/
    ├── StudentNotFoundException.java
    └── GlobalExceptionHandler.java
```

---

## ⚙️ Setup & Run

### Prerequisites
- Java 21
- MySQL 8.0
- Maven

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/Sowjanya474/student-management.git
cd student-management
```

**2. Create MySQL database**
```sql
CREATE DATABASE student_db;
```

**3. Update `application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=your_password
```

**4. Run the application**
```bash
./mvnw spring-boot:run
```

**5. Open in browser**
```
http://localhost:8080/students
```

---

## 🔐 API Authentication

### Login
```
POST /auth/login
```
```json
{
  "username": "admin",
  "password": "admin123"
}
```

### Use Token
```
Authorization: Bearer <your_jwt_token>
```

### Users
| Username | Password | Role |
|---|---|---|
| admin | admin123 | ADMIN |
| user | user123 | USER |

---

## 📚 API Endpoints

| Method | Endpoint | Role | Description |
|---|---|---|---|
| POST | /auth/login | Public | Get JWT token |
| GET | /api/students | USER, ADMIN | Get all students |
| GET | /api/students/{id} | USER, ADMIN | Get student by ID |
| POST | /api/students | ADMIN | Add student |
| PUT | /api/students/{id} | ADMIN | Update student |
| DELETE | /api/students/{id} | ADMIN | Delete student |
| GET | /api/students/paged | USER, ADMIN | Paginated students |

---

## 📖 Swagger UI
```
http://localhost:8080/swagger-ui.html
```

---

## 👩‍💻 Author

**Sowjanya K S**
- GitHub: [@Sowjanya474](https://github.com/Sowjanya474)
- LinkedIn: www.linkedin.com/in/sowjanya-k-s-93b89b32b
