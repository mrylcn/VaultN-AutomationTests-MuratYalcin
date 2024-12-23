# VaultN Automation Tests Project Structure

```
VaultN-AutomationTests-MuratYalcin/
│
├── Task 1/
│   ├── Postman Collection/
│   │   ├── Production.postman_environment.json
│   │   └── Trello API.postman_collection.json
│   ├── Postman.mp4
│   └── README.md
│
├── Task 2/
│   ├── selenium-trello/
│   │   ├── .settings/
│   │   ├── src/
│   │   │   └── test/
│   │   │       └── java/
│   │   │           └── com/
│   │   │               └── trello/
│   │   │                   ├── tests/
│   │   │                   │   ├── AddCardsTest.java
│   │   │                   │   ├── BaseTest.java
│   │   │                   │   ├── BoardCreationTest.java
│   │   │                   │   ├── DeleteBoardTest.java
│   │   │                   │   ├── ListManagementTest.java
│   │   │                   │   ├── LoginTest.java
│   │   │                   │   └── MoveCardsTest.java
│   │   │                   └── testsuites/
│   │   │                       └── TrelloTestSuite.java
│   │   ├── target/
│   │   ├── trello-automation/
│   │   ├── .classpath
│   │   ├── .project
│   │   └── pom.xml
│   ├── Selenium-trello.mp4
│   └── README.md
│
└── Task 3/
    ├── cypress-trello/
    │   ├── cypress/
    │   │   ├── downloads/
    │   │   ├── e2e/
    │   │   │   └── trello.tests.cy.js
    │   │   ├── fixtures/
    │   │   └── support/
    │   ├── node_modules/
    │   ├── cypress.config.js
    │   ├── package.json
    │   └── package-lock.json
    ├── Cypress-Trello.mp4
    └── README.md
```

## Key Components

### Task 1: Postman API Testing
- Postman collection and environment files
- Demo video
- README documentation

### Task 2: Selenium UI Testing
- Java test classes organized by functionality
- TestSuite for test execution
- Maven configuration (pom.xml)
- Demo video
- README documentation

### Task 3: Cypress UI Testing
- Cypress test specification in e2e directory
- Configuration files
- Node.js dependencies
- Demo video
- README documentation
