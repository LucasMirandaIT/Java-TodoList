# ToDo List Application

A ToDo List application built with Spring Boot, MySQL, and following clean architecture principles for Stefanini FullStack Developer Test.

## Features
- CRUD operations for tasks
- Task status management (PENDING, IN_PROGRESS, COMPLETED, CANCELED)
- MySQL database integration
- RESTful API endpoints
- GitHub Actions CI/CD pipeline
- Validation and error handling

## Technology Stack

- **Backend**: Java 17, Spring Boot 3.2
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **CI/CD**: GitHub Actions

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6 or later
- MySQL 8.0 or later

### Setup

1. Clone the repository
2. Create a MySQL database named `todo_db`
3. Update database credentials in `application.properties`
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
## Endpoints

/api/tasks

| Method        | Description       | Example URL         | 
| ------------- |------------------ |:------------------: |
| @GET          | Fetch All Tasks   | /api/tasks          |
| @GET          | Fetch Task by ID  | /api/tasks/{id}     | 
| @POST         | Create new Task   | /api/tasks          |
| @PUT          | Update Task by ID | /api/tasks/{id}     |
| @DELETE       | Delete Task by ID | /api/tasks/{id}     | 

### Tasks Model (use on Post and Put)
```
{
  "title": "Task Title",
  "description": "Task Description",
  "status": "PENDING"
}
```

### Status Enum (Values that are valid for Status field)

| ENUM              | Description                                              |
| ----------------- |:-------------------------------------------------------: |
| PENDING           | New task, waiting to be done                             | 
| IN_PROGRESS       | Task In Progress                                         | 
| FINISHED          | Task Completed (Will add dueDate to its record on DB)    | 
| CANCELED          | Task Canceled (Will add dueDate to its record on DB)     | 