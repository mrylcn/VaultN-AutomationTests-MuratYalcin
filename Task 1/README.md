
---

### **Task 1 `README.md`**
```markdown
# Task 1: API Automation with Postman

## Overview

This task automates Trello board management using the Trello API and Postman.

## Prerequisites

- Install [Postman](https://www.postman.com/).
- Generate a Trello API key and token from [Trello Developer API](https://trello.com/app-key).

## Setup

1. Import `VaultN_Postman_Collection.json` into Postman.
2. Import `VaultN_Postman_Environment.json` as an environment.
3. Configure your Trello API key and token in the environment variables:
   - `API_KEY`
   - `TOKEN`

## Requests Automated

- Create a Board (`VaultN`).
- Add lists to the board:
  - Backlog, Todo, Doing, Testing, Done.
- Add cards to lists:
  - "Sign up for Trello", "Get key and token", etc.
- Move cards to respective lists.
- Delete the board.

## Run Instructions

1. Select the `VaultN` environment in Postman.
2. Run the collection step-by-step or use the Postman Runner.
3. Verify each request completes successfully.

## Verification

- Check the response for each request.
- The video `Postman.mp4` demonstrates successful execution.
