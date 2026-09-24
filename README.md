🚌 Java Bus Reservation System

📌 Project Overview

The Java Bus Reservation System is a console-based application developed using Java to manage bus registration, customer registration, bus searching, seat reservations, cancellations, and waiting-list management.

The system demonstrates practical implementation of Data Structures and Algorithms (DSA) together with Object-Oriented Programming (OOP) concepts.

The project was developed as part of Unit 19 – Data Structures and Algorithms. The system uses data structures such as Stack, Queue, Array, Linked List, and Graph, together with sorting and shortest-path algorithms.

---

✨ Main Features

👨‍💼 Admin Features

- 🔐 Admin Login
- 🚌 Register New Bus
- 📋 View All Buses
- 👥 View All Customers
- 📑 Display Reservations
- 🔄 Display Customers using LIFO Stack
- 🔢 Sort Customers by Age using Bubble Sort
- ⚡ Sort Customers by Age using Quick Sort
- 🗑️ Clear System Data
- 🚪 Admin Logout

👤 Customer Features

- 📝 Customer Registration
- 🔐 Customer Login
- 🚌 Search Available Buses
- 💺 Reserve Bus Seats
- ❌ Cancel Reservation
- 🔄 Request a New Seat
- ⏳ Waiting List Management
- 📋 View My Reservations
- 🚪 Customer Logout

---

🧠 Data Structures Used

The system demonstrates several data structures for different operations.

📚 Stack

A Stack is used to display customer information in Last-In-First-Out (LIFO) order.

The most recently registered customer can therefore be accessed first.

🚶 Queue

A Queue is used to manage customers waiting for available seats.

The system follows the First-In-First-Out (FIFO) principle so that customers are processed according to their waiting order.

🔗 Linked List

A linked-list-based structure is used for dynamic data management, particularly for queue-related operations.

📦 Array

Arrays are used for storing and accessing collections of data such as seats and records.

🌐 Graph

Graphs are used to represent network connections and support shortest-path algorithm analysis.

---

⚡ Algorithms Used

🔄 Bubble Sort

Bubble Sort is implemented to arrange customer records according to age.

Time Complexity:

- Best Case: "O(n)"
- Average Case: "O(n²)"
- Worst Case: "O(n²)"

🚀 Quick Sort

Quick Sort is implemented to sort customer records by age using a divide-and-conquer approach.

Time Complexity:

- Best Case: "O(n log n)"
- Average Case: "O(n log n)"
- Worst Case: "O(n²)"

🗺️ Shortest Path Algorithms

The project also analyses shortest-path algorithms including:

- Dijkstra's Algorithm
- Bellman-Ford Algorithm

These algorithms are demonstrated using graph-based route examples.

---

🏗️ Object-Oriented Programming

The system applies the main principles of Object-Oriented Programming:

- 🔒 Encapsulation
- 🎭 Abstraction
- 🧬 Inheritance
- 🔄 Polymorphism

Classes such as Customer, Bus, and Reservation are used to organise system responsibilities and data.

Encapsulation is used to protect internal data, while abstraction hides unnecessary implementation details.

Polymorphism is demonstrated through different sorting implementations such as Bubble Sort and Quick Sort.

---

📋 System Requirements

The system was developed according to the following requirements:

Customer Registration

Customer information includes:

- Customer Name
- Mobile Number
- Email ID
- City
- Age

Bus Registration

Bus information includes:

- Bus Number
- Total Seats
- Starting Point
- Ending Point
- Starting Time
- Fare

Reservation Management

Customers can:

- Search for buses
- Reserve seats
- Cancel reservations
- Request new seats
- Join the waiting queue
- View reservations

The system also maintains reservation information for future use.

---

## 🛠️ Technologies Used

### ☕ Programming Language

- ☕ Java

### 💡 Concepts

- 🗂️ Data Structures
- 🧮 Algorithms
- 🧩 Object-Oriented Programming
- 📦 Abstract Data Types
- ⚠️ Error Handling
- 📊 Algorithm Complexity Analysis

### 🧰 Development Tools

- ☕ Java JDK
- 💻 Visual Studio Code / IntelliJ IDEA
- 🐙 Git
- 🐙 GitHub

---

📂 Project Structure

Bus-Reservation-System/
│
├── src/
│   ├── Customer.java
│   ├── Bus.java
│   ├── Reservation.java
│   ├── Stack.java
│   ├── Queue.java
│   ├── BubbleSort.java
│   ├── QuickSort.java
│   └── Main.java
│
├── README.md
└── .gitignore

«The exact file structure may vary depending on the current version of the project.»

---

▶️ How to Run

Step 1 — Install Java

Install the Java Development Kit (JDK) on your computer.

Check the installation:

java -version

Check the Java compiler:

javac -version

Step 2 — Clone the Repository

git clone https://github.com/ihzanac/Bus-Reservation-System.git

Step 3 — Open the Project

Open the project using:

- Visual Studio Code
- IntelliJ IDEA
- Eclipse
- Another Java-compatible IDE

Step 4 — Compile and Run

If the project contains a "Main.java" file:

javac Main.java

Then run:

java Main

Alternatively, run the main class directly from your Java IDE.

---

🧪 Testing and Error Handling

The system includes validation and error handling for different operations.

Examples include:

- Invalid menu choices
- Invalid numeric inputs
- Duplicate bus numbers
- Invalid seat numbers
- Reservation errors
- Cancellation errors
- Empty queue/stack operations
- Invalid customer information

The project also includes test cases and test results to verify the functionality of the reservation system.

---

📊 Algorithm Complexity

Algorithm / Operation| Best Case| Average Case| Worst Case
Stack Push| O(1)| O(1)| O(1)
Stack Pop| O(1)| O(1)| O(1)
Stack Peek| O(1)| O(1)| O(1)
Queue Enqueue| O(1)| O(1)| O(1)
Queue Dequeue| O(1)| O(1)| O(1)
Bubble Sort| O(n)| O(n²)| O(n²)
Quick Sort| O(n log n)| O(n log n)| O(n²)

---

🎯 Project Objectives

The main objectives of this project are:

1. Implement a functional bus reservation system using Java.
2. Apply suitable data structures to real-world problems.
3. Implement and compare sorting algorithms.
4. Implement stack and queue operations.
5. Apply Object-Oriented Programming principles.
6. Demonstrate error handling and testing.
7. Analyse algorithm efficiency using Big-O notation.
8. Apply shortest-path algorithms to network problems.

---

🖥️ System Modules

                    BUS RESERVATION SYSTEM
                              │
              ┌───────────────┴───────────────┐
              │                               │
           ADMIN                          CUSTOMER
              │                               │
      ┌───────┼────────┐              ┌───────┼────────┐
      │       │        │              │       │        │
   Register  View    Sorting       Register  Search  Reserve
     Bus    Data     Algorithms     Login     Bus     Seat
                                      │       │        │
                                      └───────┼────────┘
                                              │
                                    Cancellation / Queue

---

🎓 Academic Project

This project was developed as an academic Data Structures and Algorithms project.

The project demonstrates practical knowledge of:

- Data Structures
- Algorithms
- Java Programming
- Object-Oriented Programming
- Abstract Data Types
- Algorithm Complexity
- Error Handling
- Software Testing
- System Design

The assignment scenario specifically required a Java implementation of the bus reservation system using selected data structures and algorithms.

---

👨‍💻 Developer

Ihzan AC

BEng (Hons) Software Engineering Graduate

---

🔗 GitHub Repository

https://github.com/ihzanac/Bus-Reservation-System

---

📄 License

This project was developed for educational and academic purposes.
