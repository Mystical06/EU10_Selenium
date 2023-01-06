package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    /*
    IN THIS CLASS WE ARE SOLVING THE DAY2_TASK1

     */

    public static void main(String[] args) {

        //TC #1: Cydeo practice tool verifications
        //1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");

        //3. Verify URL contains
        //Expected: cydeo

        System.out.println(driver.getCurrentUrl().contains("cydeo"));


        // 4. Verify title:
        //Expected: Practice
        System.out.println(driver.getTitle().equals("Practice"));

        driver.close();




        //break 15mins: 10.10am cST
        //break 15mins: 11.10am EST

    }

}
