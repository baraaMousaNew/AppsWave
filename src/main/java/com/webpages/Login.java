package com.webpages;

import com.services.LoginService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login implements LoginService {


    protected WebDriver webDriver;

    @FindBy(css = "input[id='_Login_LoginPortlet_INSTANCE_euts_login']")
    protected WebElement emailField;

    @FindBy(css = "input[id='_Login_LoginPortlet_INSTANCE_euts_password']")
    protected WebElement passwordField;

    @FindBy(css = "button[id*='_Login_LoginPortlet_INSTANCE']")
    protected WebElement loginButton;

    public Login(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @Override
    public void navigateToLogin() {
        webDriver.get("https://staging.na.ae/login");
    }

    @Override
    public void login(String username, String password){
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

}
