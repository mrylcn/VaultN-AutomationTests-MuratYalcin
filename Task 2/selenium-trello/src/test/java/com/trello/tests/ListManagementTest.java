// ListManagementTest.java
// Description: Archives the existing lists and creates new lists

package com.trello.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListManagementTest extends BaseTest {

    @Test
    public void manageLists() {
        
        loginToTrello();
        
        navigateToBoard("VaultN");

        // Step 2: Delete existing lists
        List<WebElement> lists = driver.findElements(By.xpath("//div[@data-testid='list']"));
        for (WebElement list : lists) {
            WebElement menuButton = list.findElement(By.xpath("//button[@data-testid='list-edit-menu-button']"));
            menuButton.click();

            WebElement archiveOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Archive this list')]")));
            archiveOption.click();

            wait.until(ExpectedConditions.invisibilityOf(list));
        }

        // Step 3: Create new lists
        String[] listNames = {"Backlog", "To-Do", "Doing", "Testing", "Done"};
        try {
            WebElement addListButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='list-composer-button']")));
            addListButton.click();
        	} catch (TimeoutException e) {
        	    System.out.println("The option not found within the timeout. Skipping this step.");
        	}
       
        for (String listName : listNames) {
        	
            
            WebElement listInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter list name…']")));
            listInput.sendKeys(listName);

            WebElement addListConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='list-composer-add-list-button']")));
            addListConfirm.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), '" + listName + "')]")));
           
        }

        // Final verification: Check all lists are created
        for (String listName : listNames) {
            WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), '" + listName + "')]")));
            assertTrue(list.isDisplayed(), "List " + listName + " was not created successfully.");
        }
    }
}