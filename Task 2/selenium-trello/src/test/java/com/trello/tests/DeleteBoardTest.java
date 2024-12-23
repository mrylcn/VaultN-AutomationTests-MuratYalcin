// DeleteBoardTest.java
// Description: Closes and deletes a specified Trello board from the workspace.

package com.trello.tests;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteBoardTest extends BaseTest {
	@Test
	public void deleteVaultNBoard() {
	    Actions actions = new Actions(driver);

	    loginToTrello();
	    
	    WebElement VaultNButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='VaultN']")));
        VaultNButton.click();

	    // Step 1: Navigate to the VaultN board
	    WebElement vaultNBoard = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//a[@title='VaultN (currently active)']")));
	    actions.moveToElement(vaultNBoard).perform();

	    // Step 2: Open the board menu
	    WebElement boardMenuButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[@aria-label='Board actions menu']")));
	    boardMenuButton.click();

	    // Step 3: Close the board
	    WebElement closeBoardButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[@aria-label='Close board']")));
	    closeBoardButton.click();

	    // Confirm board closure
	    WebElement confirmCloseButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[@data-testid='popover-close-board-confirm']")));
	    confirmCloseButton.click();

	    // Step 4: Return to the workspace and view closed boards
	    WebElement boardsMenu = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//a[@data-testid='open-boards-link']")));
	    boardsMenu.click();

	    WebElement viewClosedBoardsButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[contains(text(), 'View closed boards')]")));
	    viewClosedBoardsButton.click();

	    // Locate the VaultN board and delete it
	    WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//a[text()='VaultN']/ancestor::li//button[@data-testid='close-board-delete-board-button']")));
	    deleteButton.click();

	    // Confirm board deletion
	    WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']")));
	    confirmDeleteButton.click();

	    // Verify board is deleted
	    boolean isBoardDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(
	        By.xpath("//span[text()='VaultN']")));
	    assertTrue(isBoardDeleted, "The VaultN board was not deleted successfully.");
	}

}
