package TestCases;

import PageObject.LoginRegisterPage;
import StepObject.BuySellSteps;
import Utils.ChromeRunner;
import io.qameta.allure.*;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;


import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;


@Epic("Coinmania Buy/Sell Test Cases")
public class BuySellFunctionalities extends ChromeRunner {

    BuySellSteps BuySellTest = new BuySellSteps();
    LoginRegisterPage LoginCheck = new LoginRegisterPage();
    @Test(description = "Validating BTC Buy Page")
    @Severity(SeverityLevel.MINOR)

    public void BTCBuyTest() throws BiffException, IOException {
        BuySellTest.BuySellPageClick();
        assertTrue(BuySellTest.BuySellPage.is(visible));
        BuySellTest.BTCBuyBtn()
                .GELSelector()
                .CashBuyBTC()
                .EnterCryptoAmountandProceed();
        assertTrue(LoginCheck.LoginHeader.is(visible));


    }

    @Test(description = "Validating ETH Sell Page")
    @Severity(SeverityLevel.NORMAL)

    public void ETHSellTest() throws IOException, BiffException{
        BuySellTest.BuySellPageClick();
        assertTrue(BuySellTest.BuySellPage.is(visible));
        BuySellTest.ETHSellBtn()
                .USDSelector()
                .CashSellETH()
                .AmountSellETH()
                .EnterCryptoAmountandProceed1();
        assertTrue(LoginCheck.LoginHeader.is(visible));


    }
}
