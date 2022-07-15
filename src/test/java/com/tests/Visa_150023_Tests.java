package com.tests;

import com.driver.CreateDriver;
import com.modelclasses.visa.VisaModelClass;
import com.pageobjects.Visa_150023;
import com.services.LoginService;
import com.services.VisaService;
import com.utilities.SynchronizationWrapper;
import com.webpages.Login;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.dataprovider.DataProviderClass;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Visa_150023_Tests {

    Properties properties = new Properties();

    WebDriver webDriver;

    @BeforeTest
    public void beforeTest() throws Exception {
        properties.load(new FileInputStream("src/main/resources/credentials.properties"));
        CreateDriver createDriver = new CreateDriver();
        createDriver.setWebDriver();
        webDriver = CreateDriver.getWebDriver();
        webDriver.get("https://staging.na.ae/en/home");
        LoginService login = new Login(webDriver);
        login.navigateToLogin();
        login.login(properties.getProperty("username"),properties.getProperty("password"));
        SynchronizationWrapper.waitForFixedTime();

    }

    @Test(dataProvider = "visa_150023_valid_data", dataProviderClass = DataProviderClass.class)
    public void Visa_150023_valid_submission(JSONObject object) throws InvocationTargetException, IllegalAccessException, InterruptedException, AWTException {
        VisaModelClass visaModel = new VisaModelClass(object);
        VisaService visa = new Visa_150023(webDriver);
        visa.navigateServiceURL();
        visa.startService();
        visa.fillApplicationInfo(visaModel);
        visa.navigateNext();
        visa.uploadMandatoryAttachments();
        visa.navigateNext();
        visa.assertVisaSubmitted();
    }
}
