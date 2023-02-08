package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.tests.utilities.Driver;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {

    @Test
    public void task7_scroll_test(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //Down-casting our driver type to JavascriptExecutor,
        // so we are able to use the methods coming from that interface


        //3- Scroll down to “Cydeo” link


        //4- Scroll up to “Home” link

        //js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);


        //objects
        //cydeoLink 0
        //homeLink 1
        //someOtherLink 2

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)

    }
}
