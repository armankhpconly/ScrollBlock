
# 📱 ScrollBlock – Block Reels, Shorts & Spotlight

![Kotlin](https://img.shields.io/badge/Kotlin-1DA1F2?logo=kotlin&logoColor=white&style=flat-square)
![Android](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=white&style=flat-square)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

ScrollBlock is an Android app designed to **block addictive short-form video content** across  
**Instagram Reels, YouTube Shorts, and Snapchat Spotlight** using Android Accessibility Services.

It helps users regain control of their screen time using two intelligent modes:  
✔️ **Strict Mode** – Blocks instantly  
✔️ **Chill Mode** – 15 minutes access every 6 hours  

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
- Individual toggles available

### 🔹 Modes
#### **Strict Mode**  
Blocks instantly (default mode)

#### **Chill Mode**  
- Allows **15 minutes** of short videos  
- Per **6 hour window**  
- Automatically enforced  

### 🔹 Usage Tracking
- Tracks total time spent watching shorts  
- Time stored using **DataStore**  
- Timer logic triggered by AccessibilityService  

---

## 🛠 Tech Stack
- **Kotlin**  
- **Hilt** (Dependency Injection)  
- **AccessibilityService**  
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
1. User enables the AccessibilityService.  
2. When the service detects a **short-form video**, it triggers logic based on selected mode.  
3. **Strict Mode:** Immediately blocks.  
4. **Chill Mode:**  
   - Checks DataStore for user’s remaining time  
   - Allows viewing until 15 minutes are consumed  
5. Timer automatically:  
   - Starts when reel is detected  
   - Stops when user scrolls away  
6. Total time is persisted in DataStore  

---

## 🚀 Installation

Clone the repo:

```sh
git clone https://github.com/yourusername/scrollblock.git
```

Open in **Android Studio** and sync Gradle.

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

### Dependencies
```gradle
implementation "androidx.datastore:datastore-preferences:1.0.0"
implementation "com.google.dagger:hilt-android:2.48"
kapt "com.google.dagger:hilt-compiler:2.48"
```

---

## 📜 Permissions

Your app requires:
- AccessibilityService  
- Internet (optional)  
- Notification permission (optional)

Enable service from:

```
Settings → Accessibility → Installed Services → ScrollBlock
```

---

## 🧪 Testing

You can test blocking with:
- Instagram Reels  
- YouTube Shorts  
- Snapchat Spotlight  

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
If you find any bugs or want to request new features, feel free to open an issue.
