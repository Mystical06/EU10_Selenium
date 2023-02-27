package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.*;

public class T1_WindowHandling {

    WebDriver driver;

    @BeforeMethod
    public void SetUpDriver(){
        // 1. Create new test and make set-ups
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test
    public void windowHandlingTest(){

        //TC #1: Window Handle practice

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy and paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");



        //4. Create a logic to switch to the tab where Etsy.com is open
        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }

        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();
        //driver.findElement(By.xpath("//button[@title='Only allow essential cookies']")).click();


        //5. Assert: Title contains “Etsy”
        String actualTitle= driver.getTitle();
        String expectedTitle= "Etsy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //
        //Lines to be pasted:

        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
        //
    }

}

