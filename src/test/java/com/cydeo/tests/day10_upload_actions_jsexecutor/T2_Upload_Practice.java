package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test() throws InterruptedException {
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.

        String path ="C:\\Users\\musta\\Desktop\\HTML Class\\myPic.jpg";



        //3. Upload the file.
        WebElement chooseFileInput = Driver.getDriver().findElement(By.xpath("//input[@name='file']"));
        chooseFileInput.sendKeys(path);

        Thread.sleep(2000);

        WebElement uploadInput = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadInput.click();

        Thread.sleep(2000);



        //4. Assert:
        //-File uploaded text is displayed on the page

        WebElement fileUploadedText = Driver.getDriver().findElement(By.tagName("h3"));
        System.out.println("fileUploadedText.getText() = " + fileUploadedText.getText());

        Assert.assertTrue(fileUploadedText.isDisplayed());

        Thread.sleep(2000);

        Driver.closeDriver();
    }
}
