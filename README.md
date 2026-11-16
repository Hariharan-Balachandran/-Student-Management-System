# Student Management System

A web-based Student Management System developed using **Java, Spring Boot, Thymeleaf, Spring Data JPA, and MySQL**. The application provides student management functionality with role-based access for different users.

## 🚀 Features

- User login and authentication
- Role-based access for students and teachers
- Student management (Create, Read, Update, Delete)
- Teacher dashboard
- Student dashboard
- Centralized exception handling
- MySQL database integration

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 24 | Backend programming |
| Spring Boot 3.5.6 | Application framework |
| Spring Data JPA | Database operations |
| Spring Security | Authentication and authorization |
| Thymeleaf | Frontend templating |
| MySQL | Relational database |
| HTML & CSS | User interface |
| Maven | Dependency management |

## 📂 Project Structure

```text
sms/
├── src/
│   ├── main/
│   │   ├── java/com/example/sms/
│   │   │   ├── controller/
│   │   │   ├── exception/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── SmsApplication.java
│   │   └── resources/
│   │       ├── static/images/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## ⚙️ Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/YOUR-USERNAME/Student-Management-System.git
```

### 2. Open the project

Open the cloned project in IntelliJ IDEA or your preferred Java IDE.

### 3. Configure MySQL

Create a database in MySQL:

```sql
CREATE DATABASE your_database;
```

### 4. Configure environment variables

The application uses environment variables for database credentials.

Configure the following variables in your IDE's Run Configuration or your operating system:

```text
DB_URL=jdbc:mysql://localhost:3306/your_database
DB_USERNAME=root
DB_PASSWORD=your_password
```

Replace the example values with your local MySQL configuration.

**Note:** Never commit actual database credentials to GitHub.

### 5. Run the application

Run the main application class:

```text
SmsApplication.java
```

Alternatively, use Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

### 6. Access the application

Open your browser:

```text
http://localhost:9090
```

## 🔐 Security

- Database credentials are configured through environment variables.
- Sensitive configuration files are excluded using `.gitignore`.

## 👨‍💻 Developer

**Hariharan Balachandran**


---

⭐ If you find this project useful, feel free to explore the repository!
