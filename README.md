# Digital Library API

This Spring Boot project provides RESTful endpoints for managing a library's resources including books, students, and transactions.

## Table of Contents

- [Introduction](#introduction)
- [Controllers](#controllers)
  - [Book Controller](#book-controller)
  - [Student Controller](#student-controller)
  - [Transaction Controller](#transaction-controller)
- [Request and Response Formats](#request-and-response-formats)
- [Usage](#usage)
- [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project implements a backend API for a library management system. It utilizes Spring Boot to provide a scalable and efficient solution for managing books, students, and transactions within a library.

## Controllers

### Book Controller

The Book Controller handles HTTP requests related to book management. It provides endpoints for creating, retrieving, updating, and deleting books.

Endpoints:
- `POST /api/v1/books`: Create a new book.
- `GET /api/v1/books/{bookId}`: Retrieve a book by ID.
- `GET /api/v1/books`: Retrieve all books.
- `DELETE /api/v1/books/{bookId}`: Delete a book by ID.
- `POST /api/v1/books/search`: Search for books based on criteria.

### Student Controller

The Student Controller handles HTTP requests related to student management. It provides endpoints for creating, retrieving, updating, and deleting students.

Endpoints:
- `POST /api/v1/students`: Create a new student.
- `GET /api/v1/students/{studentId}`: Retrieve a student by ID.
- `GET /api/v1/students`: Retrieve all students.
- `PUT /api/v1/students`: Update a student.
- `DELETE /api/v1/students/{studentId}`: Delete a student by ID.

### Transaction Controller

The Transaction Controller handles HTTP requests related to library transactions. It provides endpoints for issuing and returning books.

Endpoints:
- `GET /api/v1/transactions/issue`: Initiate a transaction for issuing a book.
- `GET /api/v1/transactions/return`: Initiate a transaction for returning a book.

## Request and Response Formats

The controllers accept and return data in JSON format. Refer to the respective controller's documentation for details on request and response formats.

## Usage

To use the API, make HTTP requests to the specified endpoints with the required parameters.

## Installation

To run the project locally, follow the installation instructions in the respective README files.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests to improve the project.

