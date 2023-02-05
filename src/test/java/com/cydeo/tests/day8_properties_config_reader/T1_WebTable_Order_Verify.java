package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.concurrent.*;

public class T1_WebTable_Order_Verify {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables ");


    }

    @Test
    public void order_name_verify_test(){

        //Locate the cell that has Bob Martin text in it.
        WebElement bobMartinCell = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]//td[.='Bob Martin']"));

        System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();

        Assert.assertEquals(actualBobName,expectedBobName);


        //3. Verify Bob Martin’s order date is as expected
        //: 12/31/2021
        WebElement bobMartinDateCell =
                driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]//td[.='Bob Martin']//following-sibling::td[3]"));
        String expectedBobDate= "12/31/2021";
        String actualBobDate= bobMartinDateCell.getText();
        Assert.assertEquals(actualBobDate,expectedBobDate);
        // alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"

    }

    //We use the utility method we created.
    @Test
    public void test2(){
        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        String customerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);
        System.out.println("customerOrderDate2 = " + customerOrderDate2);

    }

    //Using WebTableUtils.orderVerify(); method
    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver,"Stewart Dawidson","03/29/2021");

    }

    @AfterMethod

    public void TearDown(){
        driver.quit();
    }
}
