# Sample Android Project with Dagger2

This is a sample Android project designed to demonstrate the use of Dagger2 in a multi-module architecture. The project is divided into several feature modules, each encapsulating specific functionalities and dependencies.

## Project Overview

The goal of this project is to showcase a scalable and modular approach to Android development using Dagger2 for dependency injection. Each feature module provides its own interface detailing the dependencies it requires. The client module, or the module that invokes the feature, is responsible for implementing this interface and supplying the necessary dependencies.

## Features

- **Modular Architecture:** The project is divided into multiple feature modules. This design promotes separation of concerns and makes the codebase easier to maintain and scale.
- **Dependency Injection with Dagger2:** Utilizes Dagger2 for managing dependencies across different modules.
- **Extensibility:** Each feature defines its own dependencies via an interface, making it easy to extend or replace features without affecting other parts of the application.

## Project Structure

- **app**: The main module that ties everything together and serves as the entry point to the application.
- **core**: Contains core functionalities and utilities shared across multiple features.
- **core-dagger**: Contains dagger functionalities and utilities shared across multiple features.
- **features**:
    - **feature1**: A feature module that demonstrates specific functionality.
    - **feature2**: Another feature module with its own unique functionality.

## Sources
- [Advanced DI. Yandex](https://youtu.be/jp_92ceiZ5M)
- [Simpler github sample](https://github.com/zagayevskiy/android-multimodule-di-example)