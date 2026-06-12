# 🎓 Student Management AI System

An AI-powered Student Management System built using **Spring Boot**, **MySQL**, and **Python Machine Learning**. The project combines traditional student management features with a machine learning model that predicts whether a student is likely to pass or fail based on academic marks.

## 🚀 Features

* Student CRUD Operations
* Marks Management
* Result & Grade Calculation
* Student Ranking System
* AI-powered Pass/Fail Prediction
* RESTful APIs with Spring Boot
* Python Flask ML Service Integration
* MySQL Database Storage

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Data JPA

### Database

* MySQL

### Machine Learning

* Python
* Flask
* Scikit-learn
* NumPy
* Pandas
* Joblib

### Tools

* Git & GitHub
* Railway
* IntelliJ IDEA
* Postman

## 📂 Project Structure

```text
student-management-ai/
│
├── backend/
│   └── Spring Boot Application
│
├── ml-model/
│   └── Python Flask ML Service
│
└── README.md
```

## 🤖 AI Integration Flow

```text
Browser
    │
    ▼
Spring Boot Backend
    │
    ├── Stores student data in MySQL
    │
    └── Sends marks to Python ML API
                     │
                     ▼
        Logistic Regression Model
                     │
                     ▼
      Pass/Fail Prediction Returned
```

## 📌 REST API Endpoints

### Students

* `GET /students`
* `POST /students`
* `GET /students/{id}`
* `PUT /students/{id}`
* `DELETE /students/{id}`

### Results & Rankings

* `GET /students/{id}/result`
* `GET /students/rankings`

### Marks

* `POST /marks`
* `GET /marks`
* `GET /marks/student/{studentId}`

### Machine Learning

* `POST /ml/predict`

Example Request:

```json
{
  "math": 90,
  "science": 85,
  "english": 80
}
```

Example Response:

```json
{
  "prediction": 1,
  "confidence": 1.0
}
```

## ⚙️ Running Locally

### Clone the repository

```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/student-management-ai.git
```

### Start the Spring Boot backend

```bash
cd backend
mvn spring-boot:run
```

### Start the Python ML service

```bash
cd ml-model

python -m venv venv

# Windows
venv\Scripts\activate

pip install -r requirements.txt

python app.py
```

Open the application at:

```text
http://localhost:8080
```

## 🔮 Future Improvements

* JWT Authentication
* Responsive UI
* Dashboard Analytics
* Docker Support
* CI/CD Pipeline
* More Advanced ML Models

## 👨‍💻 Author

**Shivam Kumar Tripathi**

Built to explore Full Stack Java Development, REST APIs, and Machine Learning integration.
