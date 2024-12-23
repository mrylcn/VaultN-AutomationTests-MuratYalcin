// AddCardsTest.java
// Description: Adds multiple cards to a specified Trello list and verifies the operation.

package com.trello.tests;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCardsTest extends BaseTest{

	@Test
	public void addSpecifiedCardsToLists() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    loginToTrello();

	    navigateToBoard("VaultN");

	    // Define the lists and their respective cards
	    String[][] listsAndCards = {
	        {"To-Do", "Sign up for Trello", "Get key and token", "Build a collection", "Working on Task"},
	        {"Backlog", "UI Automation", "Writing Test Scenarios"}
	    };

	    // Iterate through each list and add cards
	    for (String[] listAndCards : listsAndCards) {
	        String listName = listAndCards[0]; // First element is the list name

	        // Locate the list container
	        WebElement listContainer = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//h2[text()='" + listName + "']/ancestor::div[@data-testid='list']")));

	        // Locate the "Add card" button within this list
	        WebElement addCardButton = listContainer.findElement(By.xpath(".//button[@data-testid='list-add-card-button']"));
	        addCardButton.click();

	        // Add each card to the list
	        for (int i = 1; i < listAndCards.length; i++) { // Start from index 1 (card names)
	            String cardName = listAndCards[i];

	            // Wait for the card input field to appear
	            WebElement cardInput = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//textarea[@data-testid='list-card-composer-textarea']")));
	            cardInput.sendKeys(cardName);

	            // Click "Add card" button within the composer
	            WebElement addCardConfirm = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//button[@data-testid='list-card-composer-add-card-button']")));
	            addCardConfirm.click();

	            // Verify the card was added
	            wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//a[contains(text(), '" + cardName + "')]")));
	        }
	    }
	}
}

