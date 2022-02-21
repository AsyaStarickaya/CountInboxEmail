package ru.countInboxEmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement loginButton;

    public void inputLoginInUsernameField(String userName) {
        usernameField.click();
        usernameField.sendKeys(userName);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }
}
