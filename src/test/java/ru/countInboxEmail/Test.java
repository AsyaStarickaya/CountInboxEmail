package ru.countInboxEmail;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test {
    public static WebDriver driver;
    public static PreLoginPage preLoginPage;
    public static MailPage mailPage;
    public static LoginPage loginPage;
    public static SendReportEmail sendReportEmail;


    @Before
    public void setupAndLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asya\\.m2\\repository\\webdriver\\chromedriver\\win32\\98.0.4758.80\\chromedriver.exe");
        ChromeOptions o = new ChromeOptions();
        o.addArguments("--incognito");
        driver = new ChromeDriver(o);
        preLoginPage = new PreLoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        sendReportEmail = new SendReportEmail(driver);

        preLoginPage.clickBigLoginButton();
        loginPage.inputLoginInUsernameField("asya.star.test");
        loginPage.clickLoginButton();
        loginPage.inputPassword("asya.star.test123");
        loginPage.clickLoginButton();
    }

    @org.junit.Test
    public void sendReportEmail() throws InterruptedException {
        mailPage.inputSearch("Simbirsoft theme папка:Входящие");
        mailPage.clickSearchButton();

        int mailCount = mailPage.countMails();

        mailPage.clickCompose();
        sendReportEmail.inputMessageDitails(mailPage.totalMails());
        sendReportEmail.clickSendButton();
        Thread.sleep(2000);
        driver.navigate().refresh();

        int newMailCount = mailPage.countMails();

        Assert.assertEquals(newMailCount, mailCount + 1);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
