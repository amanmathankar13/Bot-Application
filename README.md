

# WhatsApp Chatbot Backend (Spring Boot + Firebase)

A backend chatbot system built using **Java Spring Boot**, integrated with **Firebase Firestore** for data storage. The system simulates WhatsApp messaging behavior and supports future integration with the **Meta WhatsApp Cloud API**.

---

## 📌 Features

- RESTful API to send and retrieve chat messages
- Automatic bot replies for predefined user inputs
- Firebase Firestore integration for message storage
- Clean and scalable Spring Boot architecture
- Ready for Render deployment (free tier)
- Supports future WhatsApp Business Cloud API integration

---

## 🚀 Technologies Used

- Java 17
- Spring Boot
- Maven
- Firebase Firestore
- (Optional) Meta WhatsApp Cloud API
- Render (for free deployment)

---

## 📁 Project Structure

## 📁 Project Structure

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── whatsappbot/
│   │               ├── controller/         # REST APIs
│   │               ├── service/            # Chatbot logic
│   │               ├── model/              # Data models (DTOs)
│   │               └── config/             # Firebase config
│   └── resources/
│       ├── application.properties
│       └── firebase-service-account.json   # 🔒 Not included in Git


