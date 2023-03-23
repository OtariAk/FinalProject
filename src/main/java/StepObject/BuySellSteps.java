package StepObject;

import PageObject.BuySellElements;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selectors.*;

public class BuySellSteps extends BuySellElements{
    @Step("Buy/Sell Page Click")
    public void BuySellPageClick(){
        BuySellPage.click(ClickOptions.withTimeout(Duration.ofMillis(10000)));
    }
    // ეს მეთოდი პოულობს კრიპტოს ჩვენი მითითებული დასახელებით და აჭერს მასში მდებარე ყიდვის ღილაკს
    @Step("Bitcoin Buy Button")
    public BuySellSteps BTCBuyBtn(){
        for(SelenideElement i : CryptoList){
            String text = i.getText();
            if(text.equals("BITCOIN")){
                SelenideElement parentDiv = i.parent();
                SelenideElement buyLink = parentDiv.$(byLinkText("ყიდვა"));
                buyLink.click();
                break;
            }
        }
        return this;
    }

    // ეს მეთოდი პოულობს კრიპტოს ჩვენი მითითებული დასახელებით და აჭერს მასში მდებარე გაყიდვის ღილაკს
    @Step("Ethereum Sell Button")
    public BuySellSteps ETHSellBtn(){
        for(SelenideElement i : CryptoList){
            String text = i.getText();
            if(text.equals("ETHEREUM")){
                SelenideElement parentDiv = i.parent();
                SelenideElement buyLink = parentDiv.$(byLinkText("გაყიდვა"));
                buyLink.click();
                break;
            }
        }
        return this;
    }
    // ყიდვის მეთოდის სელექტორი
    @Step("Select GEL Currency")
    public BuySellSteps GELSelector(){
        for(SelenideElement i : ListGroupOfBuySellWays){
            String text = i.getText();
            if(text.equals("GEL")){
                i.click();
                break;
            }
        }
        return this;
    }
    // ყიდვის მეთოდის სელექტორი
    @Step("Select USD Currency")
    public BuySellSteps USDSelector(){
        for(SelenideElement i : ListGroupOfBuySellWays){
            String text = i.getText();
            if(text.equals("USD")){
                i.click();
                break;
            }
        }
        return this;
    }
    @Step("Buy BTC With Cash")
    public BuySellSteps CashBuyBTC(){
        BuyBTCwCash.click();
        return this;
    }
    @Step("Sell ETH With Cash")
    public BuySellSteps CashSellETH(){
        SellETHwCash.click();
        return this;
    }
    @Step("Sell ETH With Amount")
    public BuySellSteps AmountSellETH(){
        SellETHwAmount.click();
        return this;
    }

    // მოცემულ მეთოდს მოაქვს ინფო იქსელეს ფაილიდან და როცა უთანაბრდება იმ ველიუს რაც მინდა ჩერდება და აჭერს ყიდვას
    @Step("Enter Crypto Amount")
    public void EnterCryptoAmountandProceed() throws IOException, BiffException {
        AmountBox.click();
        String filePath = "files\\cryptoamount.xls";
        FileInputStream fs = new FileInputStream(filePath);
        Workbook wb = Workbook.getWorkbook(fs);
        Sheet sheet = wb.getSheet("cryptoamount");
        int totalNoOfRows = sheet.getRows();
        for (int row = 1; row < totalNoOfRows; row++){
            String val = "100";
            AmountBox.setValue(sheet.getCell(0,row).getContents());
            if(Objects.equals(AmountBox.getValue(), val)){
                NextStepBtn.click();
                break;
            }
        }
    }

    // მოცემულ მეთოდს მოაქვს ინფო იქსელეს ფაილიდან და როცა უთანაბრდება იმ ველიუს რაც მინდა ჩერდება და აჭერს ყიდვას
    @Step("Enter Crypto Amount")
    public void EnterCryptoAmountandProceed1() throws IOException, BiffException {
        AmountBox.click();
        String filePath = "files\\cryptoamount.xls";
        FileInputStream fs = new FileInputStream(filePath);
        Workbook wb = Workbook.getWorkbook(fs);
        Sheet sheet = wb.getSheet("cryptoamount");
        int totalNoOfRows = sheet.getRows();
        for (int row = 1; row < totalNoOfRows; row++){
            String val1 = "345";
            AmountBox.setValue(sheet.getCell(0,row).getContents());
            if(Objects.equals(AmountBox.getValue(), val1)){
                NextStepBtn.click(ClickOptions.withTimeout(Duration.ofMillis(10000)));
                break;
            }
        }
    }

}
