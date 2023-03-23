package StepObject;

import PageObject.HelpAndPreevPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.util.Set;

public class HelpPreevSteps extends HelpAndPreevPage {
    @Step("Getting Window Original Tab")
    private Set<String> getWindowHandles() {
        return WebDriverRunner.getWebDriver().getWindowHandles();
    }
    @Step("Getting Window Tabs")
    private String getOriginalWindowHandle() {
        return WebDriverRunner.getWebDriver().getWindowHandle();
    }
    @Step("Switch To New Tab")
    public void switchToNewTab() {
        Set<String> handles = getWindowHandles();
        handles.remove(getOriginalWindowHandle());
        String newTabHandle = handles.iterator().next();
        WebDriverRunner.getWebDriver().switchTo().window(newTabHandle);
    }
    @Step("Click Help Page")
    public HelpPreevSteps HelpClick(){
        HelpPage.click();
        return this;
    }
    @Step("How to Register Help Page")
    public void HowToReg(){
        HowtoRegister.click();
    }
    @Step("How to Top Up Help Page")
    public HelpPreevSteps HowToTopUP(){
        TopUpBal.click();
        return this;
    }
    @Step("How to Top up with Bank Of Georgia Page")
    public void GeoTopUpMethod(){
        GeorgianBank.click();
    }
    @Step("How to check TRC-20 Deposit Help page")
    public void TronCheckBtn(){
        TronCheck.click();
    }
    @Step("Contact Button Click")
    public void ContactBtnClick(){
        ContactBtn.click();
    }
    @Step("Going to the  Preev.com")
    public void PreevPageClick(){
        PreevPage.click();
    }
    @Step("Setting BTC Amount")
    public HelpPreevSteps SetAmount(String amount){
        AmountField.click();
        AmountField.setValue(amount);
        return this;
    }
    @Step("Checking BTC Price in EUR")
    public void EurCheck() {
        CurButton.click();
        EurBtn.click();
    }
    @Step("Selecting Local Bitcoins source")
    public void SelectLocalBTCs(){
        SettingBut.click();
        SelectLocalBTC.click();
    }
}
