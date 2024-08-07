# Tv Series App

The Tv Series app leverages the [The Movie Database (TMDb) API](https://www.themoviedb.org/documentation/api) to fetch and display popular TV series. It is built using modern Android development tools including Jetpack Compose, Dagger Hilt, Retrofit, Coroutines, and Flow.

## App UI

Here are some screenshots showcasing the app's UI:



## Tech Stack & Open-source Libraries

- **Minimum SDK level 26**
- **Kotlin**: Modern, concise, and safe programming language.
- **Dagger Hilt**: Dependency injection library that reduces the boilerplate of manual dependency injection.
- **Kotlin Serialization**: Compiler plugin that generates code for serializing objects without reflection.
- **Coroutines**: Recommended solution for asynchronous programming on Android.
- **Flow**: Asynchronous data stream that emits values sequentially.
- **Retrofit**: Type-safe HTTP client for Android and Java.
- **Jetpack Compose**: Modern toolkit for building native UI on Android, simplifying UI development.
- **Coil**: Image loading library backed by Kotlin Coroutines.
- **Material 3**: Material design components for building layouts and animations.

## App Architecture

The app is designed using the **MVVM (Model-View-ViewModel) architecture** and the **Repository pattern** to ensure clean separation of concerns and enhance maintainability.

## Installation

To install the Tv Series app, you can use the provided APK file:

```bash
adb install path_to_apk
