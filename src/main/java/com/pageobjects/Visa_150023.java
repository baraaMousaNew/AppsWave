package com.pageobjects;

import com.modelclasses.visa.VisaModelClass;
import com.webpages.Visa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Visa_150023 extends Visa {

    @FindBy(css = "input[id='_com_na_VisitRequest_INSTANCE_yqkr_organizationName']")
    protected WebElement organizationNameField;

    @FindBy(css = "input[id='_com_na_VisitRequest_INSTANCE_yqkr_telephone']")
    protected WebElement telephoneField;

    @FindBy(css = "input[id='_com_na_VisitRequest_INSTANCE_yqkr_purposeDetails']")
    protected WebElement purposeDetails;

    protected String countryOfResidenceList = "_com_na_VisitRequest_INSTANCE_yqkr_countryOfResidence";

    protected String visitPurposeList = "_com_na_VisitRequest_INSTANCE_yqkr_visitPurpose";

    protected String visaDurationList = "_com_na_VisitRequest_INSTANCE_yqkr_visitDuration";

    @FindBy(css = "input[id='_com_na_VisitRequest_INSTANCE_yqkr_totalNumberOfVisitors']")
    protected WebElement totalNumberOfVisitors;

    @FindBy(css = "input[id='_com_na_VisitRequest_INSTANCE_yqkr_visitStartTime']")
    protected WebElement visitStartTime;

    @FindBy(css = "input[id='_com_na_VisitRequest_INSTANCE_yqkr_visitDate']")
    protected WebElement visitStartDateField;

    @FindBy(css = "input[id='_com_na_VisitRequest_INSTANCE_yqkr_requesterRemarks']")
    protected WebElement requesterRemarkField;

    public Visa_150023(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void navigateServiceURL() {
        webDriver.get("https://staging.na.ae/en/services-card-details?serviceid=150023");
    }

    @Override
    public void fillApplicationInfo(VisaModelClass visaModelClass) {
        organizationNameField.sendKeys(visaModelClass.getOrganizationName());
        telephoneField.sendKeys(visaModelClass.getTelephone());
        stepActions.selectFromList(visaModelClass.getCountryOfResidence(), countryOfResidenceList);
        stepActions.selectFromList(visaModelClass.getVisitPurpose(), visitPurposeList);
        purposeDetails.sendKeys(visaModelClass.getPurposeDetails());
        //visitStartDateField.sendKeys(trimValueForDate(visaModelClass.getVisitDate()));
        visitStartTime.sendKeys(trimValueForTime(visaModelClass.getVisitTime()));
        stepActions.selectFromList(visaModelClass.getVisitDuration(), visaDurationList);
        totalNumberOfVisitors.sendKeys(visaModelClass.getTotalNumberOfVisitors());
        requesterRemarkField.sendKeys(visaModelClass.getRequestRemarks());
    }

    private String trimValueForTime(String value){
        String newValue = value.replace(":","");
        newValue = newValue.replaceAll(" ","");
        newValue = newValue.substring(0,5);
        return newValue;
    }

    private String trimValueForDate(String value){
        value = value.replaceAll("/","");
        return value;
    }


}
