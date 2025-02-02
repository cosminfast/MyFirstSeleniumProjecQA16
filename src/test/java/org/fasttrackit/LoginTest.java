package org.fasttrackit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {



   private static WebDriver driver;

    @BeforeClass
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void validLoginTest() {

        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement helloText = driver.findElement(By.cssSelector(".welcome-msg .hello"));

        Assert.assertEquals("Hello, asdasda asdasd!", helloText.getText());

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log Out']")).isDisplayed());

    }

    @Test
    public void negativeLogin() {

        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("aasd");
        driver.findElement(By.cssSelector("#send2")).click();


    }

    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
