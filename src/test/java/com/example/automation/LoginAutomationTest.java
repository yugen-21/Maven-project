package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAutomationTest {

    @Test
    public void testLogin() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shama\\Downloads\\chromedriver_win32\\chromedriver.exe"); // Update this path
        WebDriver driver = new ChromeDriver();

        try {
            // Load the local HTML file
            String filePath = "file:///" + System.getProperty("user.dir") + "/src/test/login.html";
            driver.get(filePath);

            // Locate the username and password fields
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            // Perform login
            usernameField.sendKeys("testUser");
            passwordField.sendKeys("testPassword");
            loginButton.click();

            // Validate the title of the login page (as per the HTML file)
            String expectedTitle = "Login";
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle);
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

