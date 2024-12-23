module.exports = {
  e2e: {
    baseUrl: 'https://trello.com',
    supportFile: 'cypress/support/e2e.js',
    viewportWidth: 1920,
    viewportHeight: 1080,
    env: {
      email: "<YOUR EMAIL" ,
      password: "<YOUR PASSWORD",
      boardName: 'VaultN',
      lists: ["Backlog", "Todo", "Doing", "Testing", "Done"],
      cards: {
        Todo: [
          "Sign up for Trello",
          "Get key and token",
          "Build a collection",
          "Working on Task"
        ],
        Backlog: [
          "UI Automation",
          "Writing Test Scenarios"
        ]
      },
      moveCards: {
        "Sign up for Trello": "Done",
        "Get key and token": "Testing",
        "Build a collection": "Doing",
        "Working on Task": "Doing"
      }
    }
  }
};