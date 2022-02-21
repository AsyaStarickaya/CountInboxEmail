package ru.countInboxEmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SendReportEmail {
    public WebDriver driver;

    public SendReportEmail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }




    @FindBy(xpath = "//*[@class=\"MultipleAddressesDesktop-Field ComposeYabblesField\"]")
    private WebElement to;

    @FindBy(xpath = "//*[@class=\"ComposeContactsList ComposeContactsSuggestDesktop-List\"]")
    private WebElement myAdress;

    @FindBy(xpath = "//*[@class=\"composeTextField ComposeSubject-TextField\"]")
    private WebElement subject;

    @FindBy(xpath = "//*[@class=\"cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder\"]")
    private WebElement message;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l\"]")
    private WebElement sendButton;



    //метод, заполняющий поля в отчетном письме
    public void inputMessageDitails(String messageText) {
        to.click();
        myAdress.click();
        subject.click();
        subject.sendKeys("Simbirsoft theme");
        message.sendKeys(messageText);

    }

    public void clickSendButton(){
        sendButton.click();

    }
}
