package com.actions;

import com.driver.CreateDriver;
import com.utilities.JavaScriptUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StepActions {

    WebDriver webDriver = CreateDriver.getWebDriver();

    public final String PHOTO_ATTACHMENT = "src/main/java/com/files/photoAttachments.jpg";

    /**
     * This method is used to select value from "select" drop lists
     * @param value
     * @param list
     */
    public void selectFromList(String value, String list){
        Select select = new Select(webDriver.findElement(By.id(list)));
        select.selectByVisibleText(value);
    }

    /**
     * This method is used to upload the attachments using the robot framework - Not used as the field is input field
     * @throws AWTException
     * @throws InterruptedException
     */
    public void uploadMandatoryAttachments() throws AWTException, InterruptedException {
        List<WebElement> locateElements = webDriver.findElements(By.cssSelector("input[id*='_com_na_VisitRequest_INSTANCE_yqkr_supportingdocuments'][aria-required='true']"));
        for (int i = 0; i<locateElements.size();i++){
                locateElements.get(i).click();
                Robot robot = new Robot();
                StringSelection selection = new StringSelection(PHOTO_ATTACHMENT);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
                robot.keyPress(KeyEvent.VK_CONTROL);
                Thread.sleep(1000);
                robot.keyPress(KeyEvent.VK_V);
                Thread.sleep(1000);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(1000);
        }
    }

    public void uploadMandatoryAttachmentsInput() {
        List<WebElement> locateElements = webDriver.findElements(By.cssSelector("input[id*='_com_na_VisitRequest_INSTANCE_yqkr_supportingdocuments'][aria-required='true']"));
        for (int i = 0; i<locateElements.size();i++){
            File file = new File(PHOTO_ATTACHMENT);
            locateElements.get(i).sendKeys(file.getAbsolutePath());
        }
    }
}
