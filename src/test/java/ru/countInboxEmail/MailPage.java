package ru.countInboxEmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MailPage {
    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/form/div/span/input")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/form/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[2]/div[1]/div/div/div/a")
    private WebElement compose;

    @FindBy(xpath = "//*[@class=\"mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap\"]")
    private WebElement refreshButton;

    @FindBy(xpath = "//*[@class=\"mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap\"]")
    private WebElement total;


    // Смена языка через UI для валидного взятия кол-ва входящих писем
//    @FindBy(xpath = "//*[@class=\"mail-ui-Link mail-ui-ComplexLink\"]")
//    private WebElement language;
//
//    @FindBy(xpath = "//*[@class=\"_nb-popup-line ui-menu-item\"]")
//    private WebElement russian;
//
//    public void changeLanguage() {
//        language.click();
//        russian.click();
//    }

    public void clickCompose() {
        compose.click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }

    public void clickRefresh() {
        refreshButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    public void inputSearch(String searchText) {
        searchField.click();
        searchField.sendKeys(searchText);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    public void clickSearchButton() {
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    //числовой подсчет кол-ва писем для последующего сравнения
    public Integer countMails() {
        String a = total.getText();
        return Integer.parseInt(a.substring(0, a.lastIndexOf(" ")));
    }

    //текст с кол-вом писем для последующей отправки в отчетном сообщении
    public String totalMails() {
        String a = total.getText();
        String b = a.substring(0, a.lastIndexOf(" "));

        if (b.equals("одно") || b.equals("bir") || b.equals("one") || b.equals("один") || b.equals("адзін") || b.equals("bitta") || b.equals("бір")) {
            b = "1";
        }

        return ("Найдено " + b + " писем/ьма");
    }


}
