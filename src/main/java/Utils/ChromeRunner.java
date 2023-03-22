package Utils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;


import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner {
    @BeforeMethod(description = "Configure Browser Before Tests")
    public void SetUp(){
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
        System.setProperty("selenide.browserSize", "1980x1080");
        open("https://coinmania.ge/");
    }

    @AfterMethod(description = "Close Browser After Tests")
    public void tearDown() throws InterruptedException {
        // Delay-ს დამატება დამჭირდა რადგან ბოტს აღიქვავს საიტი და CloudFlare ბლოკავს :(
        long delayInMillis = 20000;
        Thread.sleep(delayInMillis);
        SelenideLogger.removeListener("allure");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }


}
