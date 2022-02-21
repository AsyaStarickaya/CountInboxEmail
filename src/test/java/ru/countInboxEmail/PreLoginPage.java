package ru.countInboxEmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreLoginPage {
    public WebDriver driver;

    public PreLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://mail.yandex.ru/?noretpath=1");
    }

    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    private WebElement BigLoginButton;


    public void clickBigLoginButton() {
        BigLoginButton.click();
    }


}
