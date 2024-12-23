// BoardCreationTest.java
// Description: Tests the creation of a new Trello board and verifies its presence on the dashboard

package com.trello.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardCreationTest extends BaseTest {
	
    @Test
    public void createBoard() {
        // Step 1: Log in to Trello
        loginToTrello();

        // Step 2: Navigate to Trello workspace and create a board
        driver.get("https://trello.com/");

        WebElement createBoardButton = driver.findElement(By.cssSelector(".mod-add"));
        createBoardButton.click();
        
        
        WebElement boardNameInput = driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"));
        boardNameInput.sendKeys("VaultN");
        
        
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='create-board-submit-button']")));
        createButton.click();
        
       

        String boardName = "VaultN"; // Replace with your expected board name
        WebElement boardHeader = driver.findElement(By.cssSelector("h1[data-testid='board-name-display']"));
        assertTrue(boardHeader.getText().equals(boardName), "Board name does not match!");

    }
    
}
