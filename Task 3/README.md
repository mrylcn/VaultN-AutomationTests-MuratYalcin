# Task 3: UI Automation with Cypress

## Overview
This task automates Trello board management using Cypress, a modern JavaScript-based UI automation framework.

## Prerequisites
- [Node.js](https://nodejs.org/) (with npm)
- [Cypress](https://www.cypress.io/)
- Delete any VaultN board if there is any

## Setup

1. Clone this repository:
   ```bash
   git clone <repository-url>
   cd VaultN-QA-Automation-Tasks/Task3_Cypress
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Configure environment variables:
   - Create or edit `cypress.env.json` with your Trello credentials and board details:
     ```json
     {
       "email": "<your_trello_email>",
       "password": "<your_trello_password>",
       "boardName": "VaultN",
       "lists": [
         "Backlog",
         "Todo",
         "Doing",
         "Testing",
         "Done"
       ],
       "cards": {
         "Todo": [
           "Sign up for Trello",
           "Get key and token",
           "Build a collection",
           "Working on Task"
         ],
         "Backlog": [
           "UI Automation",
           "Writing Test Scenarios"
         ]
       },
       "moveCards": {
         "Sign up for Trello": "Done",
         "Get key and token": "Testing",
         "Build a collection": "Doing",
         "Working on Task": "Doing"
       }
     }
     ```

## Steps Automated

1. **Login to Trello:**
   - Logs in with valid credentials

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
   - Adds the following cards to their respective lists:
     - "Sign up for Trello" in Todo
     - "Get key and token" in Todo
     - "Build a collection" in Todo
     - "Working on Task" in Todo
     - "UI Automation" in Backlog
     - "Writing Test Scenarios" in Backlog

5. **Move Cards:**
   - Moves cards between lists as follows:
     - "Sign up for Trello" to Done
     - "Get key and token" to Testing
     - "Build a collection" to Doing
     - "Working on Task" to Doing
