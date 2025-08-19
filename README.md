# 📚 Library Management System (Pure Java)

![Java](https://img.shields.io/badge/Java-17+-blue.svg)
![Build](https://img.shields.io/badge/Build-Maven-red.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)
![Tests](https://img.shields.io/badge/Tests-JUnit%205-yellow.svg)

A **console-based Library Management System** built in **pure Java** to practice **OOP, SOLID principles, and Clean Architecture patterns** without relying on frameworks.  

This project simulates a small library where users can add, borrow, return, remove, and search for books. It’s designed as a **learning exercise** to bridge from **Java fundamentals** into **production-style design** that maps directly to Spring Boot and microservices.

---

## 🎯 Goals
- Strengthen **Java core skills** (OOP, collections, exceptions, testing).
- Apply **SOLID design principles** in practice.
- Learn **layered architecture** (domain, services, repositories, UI).
- Use **DTOs, validators, result wrappers** like real-world applications.
- Prepare for transition into **Spring Boot + REST microservices**.

---

## 🏗️ Project Structure
com.pm.library
├── app/ // Main entry point & configuration
├── domain/ // Entities (Book), validation, error codes
├── ports/ // Interfaces (repositories, id generators)
├── adapters/ // Implementations (in-memory repo, UUID generator, console logger)
├── services/ // Business logic (LibraryService, commands, DTOs)
├── shared/ // Reusable helpers (Result, Preconditions, Clock, Logger)
└── ui/ // Console-based menu & I/O

---

## ✨ Features
- Add, borrow, return, remove books.
- List all available books.
- Search by title or author (using **Specification pattern**).
- Input validation with clear error codes (e.g., `TITLE_REQUIRED`, `BOOK_NOT_FOUND`).
- **In-memory repository** (swap later with file/DB).
- **Result wrapper** for consistent error handling (instead of exceptions).
- Unit tests with **JUnit 5**.

---

## 🔧 Tech Stack
- **Language:** Java 17+  
- **Build Tool:** Maven  
- **Testing:** JUnit 5  

---

## 🧪 Example Console Menu
Add Book

Borrow Book

Return Book

Remove Book

List Books

Search Books

Exit

yaml
Copy
Edit

---

## 📘 Learning Outcomes
By completing this project, you’ll learn:
- How to **design a clean domain model** (`Book` with intent-driven methods like `borrow()` and `returnBook()`).
- How to write **validators** that enforce rules on DTOs before entity creation.
- How to **separate concerns** with interfaces, services, and adapters.
- How to **unit test** entities, validators, and services.
- How these patterns map directly to **Spring Boot** (e.g., service → `@Service`, repo → `@Repository`, UI → `@RestController`).

---

## 🚀 Next Steps
- Add persistence (file or database repository).  
- Replace console UI with REST API using **Spring Boot**.  
- Add advanced features: undo/redo, pagination, sorting, import/export.  

---

## 📝 License
This project is open-source and available under the [MIT License](LICENSE).
