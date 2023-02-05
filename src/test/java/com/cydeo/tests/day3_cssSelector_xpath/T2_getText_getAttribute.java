package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.tests.utilities.*;
import org.openqa.selenium.*;

public class T2_getText_getAttribute {

    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer

        WebElement rememberMeText = driver.findElement(By.className("login-item-checkbox-label"));
        String actualText = rememberMeText.getText();
        String expectedText= "Remember me on this computer";

        if (actualText.equals(expectedText)) {
            System.out.println("Remember Me text test PASSED!");
        } else {
            System.out.println("Remember Me text test FAILED!!!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        WebElement forgotPasswordText = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotText= forgotPasswordText.getText();
        System.out.println(actualForgotText);
        String expectedForgotText= "Forgot your password?";

        if (actualForgotText.equals(expectedForgotText)){
            System.out.println("Forgot your password text test PASSED!");
        }else {
            System.out.println("Forgot your password text test FAILED!!!");
        }


        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref= "forgot_password=yes";
        String actualInHref= forgotPasswordText.getAttribute("href");

        System.out.println("actualInHref = " + actualInHref);

        if (actualInHref.contains(expectedInHref)){
            System.out.println("HREF attribute value verification PASSED!");
        }else {
            System.out.println("REF attribute value verification FAILED!!!");
        }

        driver.close();

    }

}
