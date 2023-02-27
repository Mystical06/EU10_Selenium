package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form_test() throws InterruptedException {
    //1. Open browser
    //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

    //3. Enter first name
        WebElement inputFirstName= Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());

    //4. Enter last name
        WebElement inputLastName= Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

    //5. Enter username
        String user =faker.bothify("helpdesk###");
        WebElement inputUsername= Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        inputUsername.sendKeys(user);

    //6. Enter email address
        WebElement inputEmail= Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@gmail.com");

        //7. Enter password
        WebElement inputPassword= Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        String password= faker.internet().password();
        inputPassword.sendKeys(password);
        System.out.println("password = " + password);


        //8. Enter phone number
        WebElement inputPhone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement genderButton = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        genderButton.click();

        //10. Enter date of birth
        WebElement dateOfBirthBox = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirthBox.sendKeys("01/04/1987");

        //11.Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

        //break until 1.05pm cst

        //12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

        //13. Select programming language from checkboxes
        WebElement programmingLanguageCheckbox = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        programmingLanguageCheckbox.click();

        Thread.sleep(2000);

        //14. Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement displayMessage = Driver.getDriver().findElement(By.tagName("p"));
        System.out.println(displayMessage.getText());
        displayMessage.isDisplayed();

        Thread.sleep(2000);

        Driver.closeDriver();
    //
    //
    //Note:
    //1. Use new Driver utility class and method
    //2. User JavaFaker when possible
    //3. User ConfigurationReader when it makes sense




    }

}