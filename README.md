# 📚 Library Management System (LMS)

A console-based Java application that helps manage library patrons. Built as part of an SDLC (Software Development Life Cycle) assignment, this project includes reading patron data from a file, adding/removing patrons, displaying them, and calculating total fines.

---

## 🛠️ Project Overview

- **Course:** CEN-3024C - Software Development I  
- **Professor:** Ashley Evans  
- **Student:** Minh Ngoc Tran  
- **Date:** May 18, 2025  
- **Package:** SDLC  

---

## 📁 Features

- ✅ Load patron data from a CSV file  
- ➕ Add a new patron  
- ➖ Remove an existing patron by ID  
- 📋 List all patrons  
- 💰 Calculate total fines  
- 🗂 Organized using object-oriented programming (OOP) principles  
- 📄 Clean, readable file input/output

---
## 🧩 Project Structure

SDLC_Assignment/<br>
├── .idea/<br>
├── out/<br>
│ └── production/<br>
│ └── SDLC/<br>
│ ├── Main.class<br>
│ ├── Patron.class<br>
│ └── PatronManager.class<br>
├── src/<br>
│ └── SDLC/<br>
│ ├── Main.java<br>
│ ├── Patron.java<br>
│ └── PatronManager.java<br>
├── patrons.txt<br>
├── manifest.txt<br>
├── SDLC_Assignment.jar<br>
├── SDLC_Assignment.iml<br>
└── README.md<br>

---

## 🚀 How to Run the Application
### 📦 Using the Executable JAR:

1. Download or clone this repository.
2. Open a terminal/command prompt and navigate to the project directory.
3. Run the following command:
   ```bash
java -jar SDLC_Assignment.jar



---

### 📜 Files Included:

- src/SDLC/ — Source code files (Main.java, Patron.java, PatronManager.java)

- out/production/SDLC/ — Compiled .class files

- patrons.txt — Sample patron data file

- manifest.txt — Manifest specifying the main class for the JAR

- SDLC_Assignment.jar — Executable JAR file

- README.md — This documentation file

- .idea/, .iml — IntelliJ IDEA project configuration files

---

## 🧪 Example Input/Output

- Current working directory: /path/to/project
- Enter path to patron data file (or press Enter to use 'patrons.txt'): 
- Patrons loaded successfully.
- ID: 1, Name: John Doe, Address: 123 Main St, Fine: $2.50
- ID: 2, Name: Jane Smith, Address: 456 Elm St, Fine: $1.25
- ID: 3, Name: Bob Johnson, Address: 789 Oak St, Fine: $10.00

---

  ## 📋 Menu Options

1. Add new patron  
2. Remove patron  
3. List all patrons  
4. Calculate total fines  
5. Exit

---
## 📊 UML Diagram

![image](https://github.com/user-attachments/assets/7b0b1139-125c-4531-922e-7c0d45f674e8)

---

### 📦 Deployment:

The application is deployed locally via the SDLC_Assignment.jar file. Ensure you have Java SE 8 or higher installed to run the JAR file.

---

## 📌 Notes

- The patrons data file should be named patrons.txt and placed in the same directory as the JAR when executing.
- If no file path is entered at launch, the program defaults to using patrons.txt.
- Designed following best practices in modular design and SDLC methodology.
  
---

## ✅ Future Improvements

- Add support for books and checkouts.
- GUI interface using JavaFX or Swing.
- Persistent database storage using JDBC/SQLite.

---
