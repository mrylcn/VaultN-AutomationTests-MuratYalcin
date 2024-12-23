// MoveCardsTest.java
// Description: Moves the cards within the board.

package com.trello.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoveCardsTest extends BaseTest {

    @Test
    public void moveCardsToLists() {
        Actions actions = new Actions(driver);

        loginToTrello();

        navigateToBoard("VaultN");

        // Define the cards and their target lists
        String[][] cardsAndTargetLists = {
            {"Sign up for Trello", "Done"},
            {"Get key and token", "Testing"},
            {"Build a collection", "Doing"},
            {"Working on Task", "Doing"}
        };

        // Move each card to its target list
        for (String[] cardAndTargetList : cardsAndTargetLists) {
            String cardName = cardAndTargetList[0]; // The card to move
            String targetListName = cardAndTargetList[1]; // The target list

            // Locate the card by its title
            WebElement card = wait.until(ExpectedConditions.presenceOfElementLocated(
            		By.xpath("//a[contains(text(), '" + cardName + "')]")));

            // Locate the target list
            WebElement targetList = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[text()='" + targetListName + "']/ancestor::div[@data-testid='list']")));

            // Perform drag-and-drop
            actions.dragAndDrop(card, targetList).perform();

            // Verify the card is now in the target list
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[text()='" + targetListName + "']/ancestor::div[@data-testid='list']//a[text()='" + cardName + "']")));
        }
    }
}
