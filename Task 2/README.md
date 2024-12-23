# Task 2: UI Automation with Selenium

## Overview
This task automates Trello board management using Java and Selenium WebDriver.

## Prerequisites
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) installed on your system
- [Maven](https://maven.apache.org/download.cgi) for managing dependencies
- A modern browser (Chrome/Firefox) and its corresponding WebDriver
- An IDE such as IntelliJ IDEA or Eclipse

## Setup

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd VaultN-QA-Automation-Tasks/Task2_Selenium
   ```

2. **Install Dependencies:**
   - Ensure `pom.xml` includes all required dependencies for Selenium and JUnit/TestNG.

3. **Configure Credentials:**
   - The code is designed to handle the credentials with environment variables.
   - Set environment variables for TRELLO_PASSWORD and TRELLO_EMAIL to run the tests

## Automated Steps

1. **Login to Trello:**
   - Uses Selenium WebDriver to automate login with valid credentials

2. **Create a Board:**
   - Creates a board named `VaultN`

3. **Add Lists:**
   - Adds the following lists to the board:
     - Backlog
     - Todo
     - Doing
     - Testing
     - Done

4. **Add Cards:**
   - Adds these cards to their respective lists:
     - "Sign up for Trello" in Todo
     - "Get key and token" in Todo
     - "Build a collection" in Todo
     - "Working on Task" in Todo
     - "UI Automation" in Backlog
     - "Writing Test Scenarios" in Backlog

5. **Move Cards:**
   - Moves cards between lists:
     - "Sign up for Trello" to Done
     - "Get key and token" to Testing
     - "Build a collection" to Doing
     - "Working on Task" to Doing

6. **Close and Delete the Board:**
   - Automates the closing and permanent deletion of the board

## How to Run

1. Open the project in your IDE

2. Build the Maven project:
   ```bash
   mvn clean install
   ```

3. Run the test suite:
   ```bash
   mvn test
   ```

## Verification
- Observe browser interactions during test execution
- Check the output logs for success messages
- Review the video `Selenium-trello.mp4` for demonstration
