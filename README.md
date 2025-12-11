
# 📱 ScrollBlock – Block Reels, Shorts & Spotlight  
**(Project Created: January 2025)**

![Kotlin](https://img.shields.io/badge/Kotlin-1DA1F2?logo=kotlin&logoColor=white&style=flat-square)
![Android](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=white&style=flat-square)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

ScrollBlock is an Android accessibility-based application built in **January 2025** to help users reduce their screen time by **blocking short-form video content** such as:  
- Instagram Reels  
- YouTube Shorts  
- Snapchat Spotlight  

The app uses Android's **AccessibilityService** to detect and block short videos instantly.  
Time tracking functionality is implemented using **DataStore** to measure how long the user stays on short-content screens.

---

## 📚 Table of Contents
- [✨ Features](#-features)  
- [🛠 Tech Stack](#-tech-stack)  
- [📁 Project Structure](#-project-structure)  
- [⚙️ How It Works](#️-how-it-works)  
- [🚀 Installation](#-installation)  
- [🔧 Setup](#-setup)  
- [📜 Permissions](#-permissions)  
- [🧪 Testing](#-testing)  
- [📄 License](#-license)  
- [🤝 Contributing](#-contributing)

---

## ✨ Features

### 🔹 Short-Form Content Blocking  
- Blocks **Instagram Reels**  
- Blocks **YouTube Shorts**  
- Blocks **Snapchat Spotlight**  
- Individual toggle controls  

### 🔹 Usage Tracking  
- Tracks total time spent watching short videos  
- Timer starts when the first short-form content appears  
- Timer stops when user scrolls away  
- Data stored persistently using **DataStore**

### ❗ Chill Mode (Coming Soon)  
Chill Mode (limited-time access feature) is **not implemented yet** and will be added in a future update.

---

## 🛠 Tech Stack
- **Kotlin**  
- **Android AccessibilityService**  
- **Hilt (Dependency Injection)**  
- **DataStore Preferences**  
- **Simplified MVVM Architecture**

---

## 📁 Project Structure
```
com.example.scrollblock  
│── di/  
│   └── AppModule.kt  
│  
│── data/  
│   └── TimerRepository.kt  
│  
│── ui/  
│   ├── MainActivity.kt  
│   └── MainViewModel.kt  
│  
│── service/  
│   └── ScrollBlockAccessibilityService.kt  
│  
│── ScrollBlockApp.kt  
│── AndroidManifest.xml  
```

---

## ⚙️ How It Works
1. User enables Accessibility Service.  
2. The service continuously checks the active window's UI nodes.  
3. If a short-form content layout (Reels/Shorts/Spotlight) is detected:  
   - The app performs **GLOBAL_ACTION_BACK** to exit instantly.  
4. Timer system:  
   - **Start timer** when short content is detected  
   - **Stop timer** when content disappears  
   - Save total time using DataStore  

---

## 🚀 Installation
Clone the repository:

```sh
git clone https://github.com/yourusername/scrollblock.git
```

Open in **Android Studio**, let Gradle sync, and run the app.

---

## 🔧 Setup

### Enable Hilt
**build.gradle (app)**:
```gradle
plugins {
    id 'com.google.dagger.hilt.android'
    id 'kotlin-kapt'
}
```

### Required Dependencies
```gradle
implementation "androidx.datastore:datastore-preferences:1.0.0"
implementation "com.google.dagger:hilt-android:2.48"
kapt "com.google.dagger:hilt-compiler:2.48"
```

---

## 📜 Permissions Needed
- AccessibilityService  
- Internet (optional)  
- Notifications (optional)

Enable the service manually from:

```
Settings → Accessibility → Installed Services → ScrollBlock
```

---

## 🧪 Testing

Test blocking on:
- Instagram (Reels)  
- YouTube (Shorts)  
- Snapchat (Spotlight)  

Check logs under:

```
Tag: ScrollBlock
```

---

## 📄 License
This project is licensed under the **MIT License**.

---

## 🤝 Contributing
Pull requests are welcome!  
If you find bugs or want to suggest improvements, open an issue.
