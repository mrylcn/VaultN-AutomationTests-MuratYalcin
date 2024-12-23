// LoginTest.java
// Description: Verifies successful login to Trello with valid credentials.

package com.trello.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginToTrello() {
    	
        loginToTrello();

        // Verify successful login by checking for an element on the dashboard
        WebElement dashboardElement = driver.findElement(By.cssSelector(".board-tile"));
        assertTrue(dashboardElement.isDisplayed(), "Login failed or dashboard not loaded");
    }
}
