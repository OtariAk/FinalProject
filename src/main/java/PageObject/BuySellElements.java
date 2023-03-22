package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BuySellElements {

    public SelenideElement
            BuySellPage = $("#navbarSupportedContent").$(byLinkText("ყიდვა / გაყიდვა")),
            BuyBTCwCash = $(byAttribute("href","/instant/buy/reverse/?base=btc&quote=gel")),
            SellETHwCash = $(byAttribute("href","/instant/sell/reverse/?base=eth&quote=usd")),
            SellETHwAmount = $(byAttribute("href","/instant/sell/?base=eth&quote=usd")),

            AmountBox = $("#AmountBox"),
            NextStepBtn = $("#RequestButton");


    public ElementsCollection
            ListGroupOfBuySellWays = $$(".list-group-item-action"),
            CryptoList = $$(".list-group-item-action .align-items-center .col h5");

}
