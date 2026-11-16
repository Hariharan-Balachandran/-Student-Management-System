# Student Management System

A web-based **Student Management System** developed using Java, Spring Boot, Thymeleaf, Spring Data JPA, and MySQL. The application provides student management functionality with separate access for Teachers and Students through role-based login.

## 🚀 Features

### Authentication & Access Control
- User login with username and password.
- Role selection for Teacher and Student.
- Password encryption using BCrypt.
- Automatic creation of demo accounts when the application starts.
- Session-based login management.
- Role-based dashboard access.
- Prevents unauthenticated users from accessing protected pages.
- Prevents users from accessing dashboards belonging to another role.

### Student Management
- Add new student records.
- View student details.
- Update existing student information.
- Delete student records.
- Paginated student listing.

### Dashboards
- Separate Teacher dashboard.
- Separate Student dashboard.

### Additional Features
- Centralized exception handling.
- MySQL database integration.
- Thymeleaf-based dynamic user interface.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 24 | Backend programming |
| Spring Boot 3.5.6 | Application framework |
| Spring Data JPA | Database operations |
| Spring Security / BCrypt | Password hashing |
| Thymeleaf | Frontend templating |
| MySQL | Relational database |
| HTML & CSS | User interface |
| Maven | Dependency management |

## 🔐 Demo Login Credentials

The application automatically creates the following demo accounts when it starts, provided those usernames do not already exist in the database.

### Teacher Account

| Field | Value |
|---|---|
| Username | `teacher` |
| Password | `tea159` |
| Role | TEACHER |

### Student Account

| Field | Value |
|---|---|
| Username | `student` |
| Password | `stud357` |
| Role | STUDENT |

**Note:** These are public demo credentials intended for testing the application. Passwords are stored in the database as BCrypt hashes, not plain text.

## 📂 Project Structure

```text
sms/
├── src/
│   ├── main/
│   │   ├── java/com/example/sms/
│   │   │   ├── config/
│   │   │   │   ├── DemoUserInitializer.java
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── LoginController.java
│   │   │   │   ├── TeacherController.java
│   │   │   │   └── StudentController.java
│   │   │   ├── exception/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── SmsApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── images/
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

Open the cloned project using IntelliJ IDEA or your preferred Java IDE.

### 3. Configure MySQL

Create a database in MySQL:

```sql
CREATE DATABASE your_database;
```

### 4. Configure environment variables

The application uses environment variables for database credentials.

Configure the following variables in your IDE's Run Configuration or operating system:

```text
DB_URL=jdbc:mysql://localhost:3306/your_database
DB_USERNAME=root
DB_PASSWORD=your_password
```

Replace the example values with your local MySQL configuration.

**Important:** Never upload actual database credentials or passwords to GitHub.

### 5. Run the application

Run the main application class:

```text
SmsApplication.java
```

Alternatively, use Maven:

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

**Linux / macOS:**
```bash
./mvnw spring-boot:run
```

### 6. Access the application

Open your browser:

```text
http://localhost:9090
```

### 7. Login and explore

Use the demo credentials provided above to explore the Teacher and Student dashboards.

- Login as Teacher to explore student management functionality.
- Login as Student to access the student dashboard.

## 🔒 Security

- Passwords are hashed using BCrypt before being stored.
- Database credentials are configured through environment variables.
- Session-based role validation protects dashboard and teacher operations.
- Unauthenticated users are redirected to the login page.
- Users cannot access dashboards belonging to another role.
- Sensitive configuration files are excluded using `.gitignore`.

## 👨‍💻 Developer

**Hariharan Balachandran**

---

⭐ If you find this project useful, feel free to explore the repository!
