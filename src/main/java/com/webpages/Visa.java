package com.webpages;

import com.actions.StepActions;
import com.modelclasses.visa.VisaModelClass;
import com.services.VisaService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.awt.*;

public abstract class Visa implements VisaService {

    protected WebDriver webDriver;

    protected StepActions stepActions = new StepActions();

    @FindBy(xpath = "//div[contains(@class,'s-apply-now')]/a")
    protected WebElement startServiceButton;

    @FindBy(id = "nextBtn")
    protected WebElement nextButton;

    @FindBy(css = "a[onclick='naGoBack()']")
    protected WebElement exitServiceButton;

    @FindBy(css = "button[onclick='saveDraft()']")
    protected WebElement saveDraftButton;

    @FindBy(css = "button[id='prevBtn']")
    protected WebElement backButton;

    @FindBy(css = "div[id='happinessPopup']")
    protected WebElement happinessMeter;

    @FindBy(css = "h3[class*='alert-success']")
    protected WebElement successMessage;

    public Visa(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void startService(){
        startServiceButton.click();
    }

    @Override
    public void navigateServiceURL() {

    }

    @Override
    public void fillApplicationInfo(VisaModelClass visaModelClass) {

    }

    @Override
    public void navigateNext() {
        nextButton.click();
    }

    @Override
    public void exitVisaService() {
        exitServiceButton.click();
    }

    @Override
    public void saveVisaDraft() {
        saveDraftButton.click();
    }

    @Override
    public void uploadMandatoryAttachments() {
        stepActions.uploadMandatoryAttachmentsInput();
    }

    @Override
    public void navigateBack() {
        backButton.click();
    }

    @Override
    public void assertVisaSubmitted() {
        Assert.assertTrue(happinessMeter.isDisplayed());
        happinessMeter.findElement(By.cssSelector("a[rel='modal:close']")).click();
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().equalsIgnoreCase("Request For Visit request has been submitted successfully"));
    }
}
