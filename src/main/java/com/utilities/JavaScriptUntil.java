package com.utilities;

import com.driver.CreateDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUntil {


    /**
     * To click web element using JavaScrip command
     * @param webElement
     */
    public static void click(WebElement webElement){
        WebDriver webDriver = CreateDriver.getWebDriver();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();",webElement);
    }

}
