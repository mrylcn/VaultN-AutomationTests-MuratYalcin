describe('Trello UI Automation', () => {
    beforeEach(() => {
        cy.on('uncaught:exception', (err, runnable) => {
          // Prevent Cypress from failing the test on uncaught exceptions
          if (err.message.includes('Syntax error, unrecognized expression')) {
            return false;
          }
          throw err;
        });
    });
    
    it('Logs into Trello with valid credentials', () => {
      cy.visit('/login');
      cy.get('#username').type(Cypress.env('email'));
      cy.get('#login-submit').click();
      cy.get('#password').type(Cypress.env('password'));
      cy.get('#login-submit').click();
      cy.origin('https://trello.com', () => {
        cy.contains('Boards').should('be.visible');
      });
    });
  
    it('Creates a board', () => {
      cy.visit('/login');
      cy.get('#username').type(Cypress.env('email'));
      cy.get('#login-submit').click();
      cy.get('#password').type(Cypress.env('password'));
      cy.get('#login-submit').click();
      cy.origin('https://trello.com', () => {
        cy.contains('Boards').should('be.visible');
  
        // Navigate to Trello workspace and create a board
        cy.get('.mod-add').click();
        cy.get('input[data-testid="create-board-title-input"]').type(Cypress.env('boardName'));
  
        cy.get('button[data-testid="create-board-submit-button"]').click();
  
        // Verify board creation
        cy.get('h1[data-testid="board-name-display"]').should('have.text', Cypress.env('boardName'));
      });
    });
    it('Manages lists by archiving existing ones and creating new ones', () => {
        cy.visit('/login');
        cy.get('#username').type(Cypress.env('email'));
        cy.get('#login-submit').click();
        cy.get('#password').type(Cypress.env('password'));
        cy.get('#login-submit').click();
        cy.origin('https://trello.com', () => {
          cy.contains('Boards').should('be.visible');
      
          // Navigate to the VaultN board
          cy.contains(Cypress.env('boardName')).click();
            
          cy.get('[data-testid="list"]').then(($el) => {
            if ($el.length > 0) {
                 // Archive existing lists
                cy.get('[data-testid="list"]').each(($list) => {
                cy.wrap($list).within(() => {
                cy.get('[data-testid="list-edit-menu-button"]').click();
                });
                cy.get('[data-testid="list-actions-popover"]').should('be.visible');
                cy.get('[data-testid="list-actions-popover"]').contains('Archive this list').click();
                cy.wrap($list).should('not.exist'); // Ensure the list is removed
                });
                
            } else {
                // Element does not exist, optionally log or skip
                cy.log('Element not found, skipping...');
            }
        });
      
          // Create new lists
          const listNames = Cypress.env('lists');
          cy.get('[data-testid="list-composer-button"]').click();
          listNames.forEach((listName) => {
            cy.get('textarea[placeholder="Enter list name…"]').type(listName);
            cy.get('[data-testid="list-composer-add-list-button"]').click();
            cy.contains(listName).should('be.visible');
          });
      
          // Verify all lists are created
          listNames.forEach((listName) => {
            cy.contains(listName).should('be.visible');
          });
        });
      });

      it('Adds specified cards to lists', () => {
        cy.visit('/login');
        cy.get('#username').type(Cypress.env('email'));
        cy.get('#login-submit').click();
        cy.get('#password').type(Cypress.env('password'));
        cy.get('#login-submit').click();
        cy.origin('https://trello.com', () => {
          cy.contains('Boards').should('be.visible');
          // Navigate to the VaultN board
          cy.contains(Cypress.env('boardName')).click();
    
          // Define the lists and their respective cards
          const cards = Cypress.env('cards');
    
          Object.keys(cards).forEach((listName) => {
            // Locate the list container
            cy.contains(listName).closest('[data-testid="list"]').within(() => {
              // Add each card to the list
              cy.get('[data-testid="list-add-card-button"]').click();
              cards[listName].forEach((cardName) => {
                cy.get('textarea[data-testid="list-card-composer-textarea"]').type(cardName);
                cy.get('[data-testid="list-card-composer-add-card-button"]').click();
                cy.contains(cardName).should('exist'); // Verify the card was added
              });
            });
          });
        });
      });
      
      it('Moves cards to target lists using the Move modal', () => {
        cy.visit('/login');
        cy.get('#username').type(Cypress.env('email'));
        cy.get('#login-submit').click();
        cy.get('#password').type(Cypress.env('password'));
        cy.get('#login-submit').click();
        cy.origin('https://trello.com', () => {
            cy.contains('Boards').should('be.visible');
    
            // Navigate to the VaultN board
            cy.contains(Cypress.env('boardName')).click();
    
            // Define the cards and their target lists
            const moveCards = Cypress.env('moveCards');
    
            Object.entries(moveCards).forEach(([cardName, targetListName]) => {
                // Locate and open the card
                cy.contains(cardName).click();
    
                // Click the "list" dropdown button in the modal
                cy.get('.css-1iyijc2').click();
                
                cy.get('div[data-testid="move-card-popover-select-list-destination"]').click()

                cy.get('div[data-testid="move-card-popover-select-list-destination"]')
                .find('input[id^="react-select"]') // Locate the input field dynamically
                .type(`${targetListName}{enter}`); // Type the target list name and press Enter

    
                // Click the "Move" button to confirm
                cy.get('button[data-testid="move-card-popover-move-button"]').click();
    
                // Close the modal
                cy.get('button[aria-label="Close dialog"]').click();
    
                // Verify the card is now in the target list
                cy.contains(targetListName).closest('[data-testid="list"]').contains(cardName).should('exist');
            });
        });
    });    
    it('Deletes the board', () => {
        cy.visit('/login');
        cy.get('#username').type(Cypress.env('email'));
        cy.get('#login-submit').click();
        cy.get('#password').type(Cypress.env('password'));
        cy.get('#login-submit').click();
        cy.origin('https://trello.com', () => {
            cy.contains('Boards').should('be.visible');
    
            // Navigate to the VaultN board
            cy.contains(Cypress.env('boardName')).click();
    
            // Open the board menu (three dots in the top right corner)
            cy.get('[aria-label="Show menu"]') 
            .should('be.visible') // Wait until the element is visible
            .click({ force: true });
    
            // Click the "Close Board" option
            cy.get('[data-testid="RemoveIcon"]').click();
    
            // Confirm closing the board
            cy.get('[data-testid="popover-close-board-confirm"]').click();
    
            // Permanently delete the board
            cy.get('[data-testid="close-board-delete-board-button"]').click();

            cy.get('[data-testid="close-board-delete-board-confirm-button"]').click();
    
            // Verify the board has been deleted
            cy.contains(Cypress.env('boardName')).should('not.exist');
        });
    });     
});