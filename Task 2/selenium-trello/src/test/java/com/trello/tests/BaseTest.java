// BaseTest.java
// Description: BaseTest class provides the setup and teardown for WebDriver and common utility methods like login and waiting for elements.
package com.trello.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void loginToTrello() {
        driver.get("https://trello.com/home");
        WebElement continueLogin = driver.findElement(By.linkText("Log in"));
        continueLogin.click();

        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys(System.getenv("TRELLO_EMAIL"));

        WebElement continueButton = driver.findElement(By.id("login-submit"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(System.getenv("TRELLO_PASSWORD"));

        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();

        WebElement dashboardElement = driver.findElement(By.cssSelector(".board-tile"));
        if (!dashboardElement.isDisplayed()) {
            throw new RuntimeException("Login failed or dashboard not loaded");
        }
     }
    
     protected void navigateToBoard(String boardName) {
            WebElement board = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='" + boardName + "']")));
            board.click();
            assertTrue(driver.findElement(By.xpath("//h1[text()='" + boardName + "']")).isDisplayed(), "Failed to navigate to board: " + boardName);
        }
        
    }
