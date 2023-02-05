package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.concurrent.*;

public class T1_Alert_Practices {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        //TC #1: Information alert practice
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @Test
    public void alertPractice_1() throws InterruptedException {

        //3. Click to “Click for JS Alert” button
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        Thread.sleep(2000);
        jsAlertButton.click();


        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert= driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//*[@id='result']"));

        //Failure message will only be displayed if assertion fails.
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");
    }

   @AfterMethod
    public void tearDown(){
        driver.close();
   }

}
