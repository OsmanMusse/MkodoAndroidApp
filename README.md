# Mkodo Technical Test

# Lottery App

## Overview

The Lottery App is a cutting-edge Android application designed with Jetpack Compose, Hilt for dependency injection, and Kotlin Coroutines. It offers a seamless user experience for viewing lottery draws, checking results.

## Features

- **Lottery List Screen**: Displays a list of recent lottery draws with their details.
- **Lottery Detail Screen**: Shows detailed information about a specific lottery draw, including numbers and prize details.

## Technologies Used

- **Jetpack Compose**: Utilized for building a reactive and modern UI in a declarative manner. Compose simplifies the UI development process and integrates well with the MVVM architecture.
- **Hilt**: Used for dependency injection, providing a scalable and manageable way to handle dependencies across the application.
- **Kotlin Coroutines**: Employed for managing asynchronous operations and background tasks efficiently, ensuring smooth and responsive UI interactions.
- **Gson**: Used for handling network requests. If included in the project, it would be for making API calls to fetch lottery data.

## Architecture

The application follows the **MVVM (Model-View-ViewModel)** architecture pattern:

- **Model**:  Represents the data layer, including domain models and use cases that interact with data sources
- **View**: Consists of Jetpack Compose UI components that observe state changes from the ViewModel and render the UI accordingly.
- **ViewModel**: Manages UI-related data and business logic, fetching data from repository and updating the UI based on user interactions or data changes..

## Key Components

- **Screens**: Implemented as Composables to manage different views such as the Lottery List, Lottery Detail.
- **ViewModels**:  Handle business logic and state management, interacting with use cases and updating the UI.
- **Components**: Reusable UI elements like BallItem, LotteryItem, and TicketView enhance modularity and maintainability.

## Improvements

1. **Error Handling**: Improved error handling and user feedback could enhance resilience and user experience.
2. **Localization:**:  Adding support for multiple languages would enhance global accessibility.
3. **UI Testing**: While unit tests for ViewModels are complete, UI testing is needed to ensure end-to-end functionality and UI behavior.

## Conclusion

The Lottery App demonstrates a modern approach to Android development using Jetpack Compose for UI, Hilt for dependency injection, and Kotlin Coroutines for asynchronous tasks. It effectively employs the MVVM architecture and Compose's capabilities to create a responsive and user-friendly application.

## 🧪 Testing

- **Unit Tests**: Validated the smallest parts of the application, mainly the repositories.
- **Integration Tests**: Just done some test on the composables for example if the buttons to go the detail screen was testable.

## 📲 How to Use

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/OsmanMusse/MkodoAndroidApp/.git
    ```
2. **Open in Android Studio**: Open the project in Android Studio to start exploring the code.
3. **Build and Run**: Build the project and run it on an emulator or physical device to see it in action.

## Result 📺
<img src="https://raw.githubusercontent.com/OsmanMusse/MkodoAndroidApp/main/screenshots/ListScreen.png" width="350px" height="700px" />     <img src="https://raw.githubusercontent.com/OsmanMusse/MkodoAndroidApp/main/screenshots/ListDetailScreen.png" width="350px" height="700px" />


## 🤝 Contributing

We welcome contributions! Please fork the repository and create a pull request with your improvements.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Enjoy the app and may the odds be ever in your favor! 🍀


