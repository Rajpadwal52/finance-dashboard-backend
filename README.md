# Finance Dashboard Backend

## About this project

This project is a backend system developed using Spring Boot to manage financial data. It allows users to store income and expense records and view a simple dashboard summary.

The main goal of this project is to demonstrate backend development concepts such as API design, database integration, and access control.

---

## What this system does

Users can add financial records such as income and expenses.
The system calculates total income, total expenses, and the remaining balance.
Basic role-based access is implemented to control who can perform certain actions.

Admin users can add records, while other users can only view data.

---

## Technology used

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Postman (for API testing)

---

## API overview

### User APIs

* POST /users → create a user
* GET /users → fetch all users

### Financial record APIs

* POST /records?role=ADMIN → add a new record
* GET /records → view all records

### Dashboard API

* GET /dashboard/summary?role=VIEWER → get financial summary

---

## Example data

### Income record

```json
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-06",
  "notes": "Monthly salary"
}
```

### Expense record

```json
{
  "amount": 2000,
  "type": "EXPENSE",
  "category": "Food",
  "date": "2026-04-06",
  "notes": "Dinner"
}
```

---

## Example response

```json
{
  "totalIncome": 15000,
  "totalExpense": 3000,
  "balance": 12000
}
```

---

## How to run the project

1. Clone the repository
2. Open the project in Spring Tool Suite or Eclipse
3. Configure database details in `application.properties`
4. Run the application
5. Test APIs using Postman

---

## Important notes

* Only ADMIN role can create records
* Date format must be `yyyy-MM-dd`
* Amount should be a positive value
