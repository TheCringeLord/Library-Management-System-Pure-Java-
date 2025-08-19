# 📚 Library Management System (Pure Java)

![Java](https://img.shields.io/badge/Java-17+-blue.svg) ![Build](https://img.shields.io/badge/Build-Maven-red.svg) ![Tests](https://img.shields.io/badge/Tests-JUnit%205-yellow.svg) ![License](https://img.shields.io/badge/License-MIT-green.svg)

A console-based Library Management System written in pure Java. This project is a compact learning exercise that focuses on OOP, SOLID principles, and a clean layered architecture (domain → services → ports → adapters) without any external frameworks.

--

## Table of contents
- [Goals](#-goals)
- [Project structure](#-project-structure)
- [Features](#-features)
- [Tech stack](#-tech-stack)
- [Example console menu](#-example-console-menu)
- [How to run](#-how-to-run)
- [Learning outcomes](#-learning-outcomes)
- [Next steps](#-next-steps)
- [License](#-license)

--

## 🎯 Goals

- Strengthen Java core skills (OOP, collections, exceptions, testing).
- Apply SOLID design principles in practice.
- Learn layered architecture with clear separation of concerns.
- Prepare for an easy transition to Spring Boot + REST microservices.

## 🏗️ Project structure

com.pm.library
- app/ — Main entry point & configuration
- domain/ — Entities (Book), validation, error codes
- ports/ — Interfaces (repositories, id generators)
- adapters/ — Implementations (in-memory repo, UUID generator, console logger)
- services/ — Business logic (LibraryService, commands, DTOs)
- shared/ — Reusable helpers (Result, Preconditions, Clock, Logger)
- ui/ — Console-based menu & I/O

## ✨ Features

- Add, borrow, return, and remove books
- List all books
- Search by title or author (lightweight specification/search)
- Input validation with clear error codes (e.g., `TITLE_REQUIRED`, `BOOK_NOT_FOUND`)
- In-memory repository (easy to swap for file or DB later)
- Result wrapper for consistent error handling instead of throwing exceptions
- Unit tests with JUnit 5

## 🔧 Tech stack

- Language: Java 17+
- Build: Maven
- Tests: JUnit 5

## 🧪 Example console menu

The app presents a simple console menu. Example:

```text
Library Menu
1) Add Book
2) Borrow Book
3) Return Book
4) Remove Book
5) List Books
6) Search Books
0) Exit
```

## 🚀 How to run

Build with Maven and run the main class. From the project root:

```powershell
mvn -q package
java -cp target/classes com.pm.library.app.Main
```

If you prefer an IDE (IntelliJ, Eclipse), import as a Maven project and run `com.pm.library.app.Main`.

## 📘 Learning outcomes

By exploring this project you'll learn how to design a small, concrete domain model (e.g. `Book` with intent-driven methods like `borrow()` and `returnBook()`), implement validators, and compose services that are easy to unit test and later map into Spring components.

## � Next steps

- Add persistence (file or database repository).
- Expose a REST API using Spring Boot.
- Add features: pagination, sorting, import/export, or a simple CLI persistence layer.

## 📝 License

This project is open-source and available under the [MIT License](LICENSE).
