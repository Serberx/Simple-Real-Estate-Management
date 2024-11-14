# Immobilienverwaltung - Real Estate Management Exercise

This project is a Java-based exercise for implementing a real estate management system, focusing on handling different
types of properties, calculating values, and storing data using various persistence formats. This system is intended as
a practice for handling object-oriented design, file I/O, and design patterns.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Class Structure](#class-structure)
- [Tasks](#tasks)
- [Installation](#installation)
- [Running the Application](#running-the-application)


## Overview

The **Immobilienverwaltung** (Real Estate Manager) system enables users to add, remove, and manage various types of real
estate objects, calculate property values, and store the data in multiple formats, using both binary and text file
persistence.

This project is part of a structured exercise to practice:

- **OOP principles**: inheritance, polymorphism, encapsulation.
- **Java file handling**: saving and loading data in both binary and text formats.
- **JavaFX GUI development**: (if applicable in future tasks).
- **Design Patterns**: Implementation of the Strategy pattern for flexible persistence mechanisms.

## Features

- **Property Types**: Support for `Wohnhaus` (Residential Building) and `Grundstueck` (Land) with specific
  characteristics and value calculations.
- **Data Management**: Add, remove, and list properties within a collection.
- **Value Calculations**: Calculate market values based on specific rules for each property type.
- **Sorting and Filtering**: Sort properties by address or market value.
- **Persistence**: Save and load property data in binary and CSV text formats using a Strategy pattern.
- **Exception Handling**: Custom exception handling with `ImmobilienException` and `PersistierException`.

## Class Structure

### Core Classes

- **Immobilienmakler**: Manages a list of properties (`Immobilie`) and provides methods to add, remove, and list
  properties. Includes methods for sorting and calculating aggregate values.
- **Immobilie**: Abstract base class representing a property with fields for address and area. Subclasses include
  specific types of properties.

### Property Classes

- **Wohnhaus**: Represents a residential building with fields for `kategorie` (category) and `einheitswert` (unit
  value). Calculates the market value based on category.
- **Grundstueck**: Represents land with fields for `widmung` (zoning) and `qmPreis` (price per square meter). Market
  value calculation adjusts based on zoning type.

### Persistence Classes

- **TextPersister**: Implements `Persistable` interface to save/load data in a text (CSV) format.
- **BinaerPersister**: Implements `Persistable` interface to save/load data in binary format.
- **Persistable**: Interface for persistence operations, facilitating flexible persistence options.

### Utility Classes

- **Constants**: Defines application-wide constants.
- **Messages**: Provides message handling utilities for status and error information.
- **PersistierException**: Custom exception for handling persistence-related errors.

## Tasks

The following tasks are part of this exercise:

### Core Functionality

1. **Implement Property Classes**:
    - Implement `Immobilie`, `Wohnhaus`, and `Grundstueck` with fields, constructors, and validation.
    - Each class should include a `berechneVerkehrswert()` method for calculating market value based on specific
      criteria.

2. **Implement Immobilienmakler**:
    - Add methods for managing properties (`add`, `remove` by position/address/area).
    - Implement methods for calculating total property value and commission.
    - Include sorting methods for market value and address, both ascending and descending.

3. **Persistence Handling**:
    - Implement `TextPersister` and `BinaerPersister` for storing and retrieving data in text and binary formats.
    - Use the Strategy pattern to dynamically switch persistence mechanisms.

4. **Exception Handling**:
    - Implement `ImmobilienException` and `PersistierException` for managing errors during data handling and
      persistence.

### Advanced Tasks

1. **Implement Advanced Persistence with Strategy Pattern**:
    - Implement the Strategy pattern, allowing the `Immobilienmakler` class to switch between different persistence
      mechanisms (binary, text).

2. **Export/Import Specific Data**:
    - Implement methods to export only specific types of data (e.g., only `Wohnhaus` properties) in a fixed-width text
      format.

3. **Testing**:
    - Develop test classes such as `TestWohnhaus`, `TestGrundstueck`, `TestMakler`, and `TestLoadMakler` to verify
      functionality and correctness of each feature.

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/immobilienmakler.git
   cd immobilienmakler
   ```

## Running the Application

2. **execute the following command to run the app**:
   ```bash
   mvn javafx:run
   ```