package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Linktext_Practice {

    public static void main(String[] args) throws InterruptedException {

        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //3- Click to A/B Testing from top of the list.
        //driver.findElement(By.linkText("A/B Testing")).click();
        //Thread.sleep(2000);
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();


        //4- Verify title is:
        //Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASS!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }



        //5- Go back to home page by using the .back();
        driver.navigate().back();


        //6- Verify title equals:
        //Expected: Practice
        String expectedTitle2 = "Practice";
        String actualTitle2 = driver.getTitle();

        if (expectedTitle2.equals(actualTitle2)){
            System.out.println("Title verification PASS!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }


        //BREAK UNTIL 1.01PM CST
        //BREAK UNTIL 2.01PM EST

        driver.close();


    }

}
