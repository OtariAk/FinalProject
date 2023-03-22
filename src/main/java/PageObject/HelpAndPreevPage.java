package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HelpAndPreevPage {

    public SelenideElement

            HelpPage = $(byAttribute("href", "https://help.coinmania.ge")),
            HowtoRegister = $(byAttribute("href", "/how-to-register")),
            HowToRegVal = $(byText("როგორ დავრეგისტრირდე?")),
            TopUpBal = $(byText("როგორ შევავსო ლარის ბალანსი?")),
            GeorgianBank = $(byText("საქართველოს ბანკი")),
            GeoPageVal = $(byText("ლარის შევსება საქართველოს ბანკიდან")),
            TronCheck = $(byAttribute("href","/late-deposit/trc20-deposit-check")),
            TronYTVideo = $(".M1aSXe"),
            ContactBtn = $(byLinkText("კონტაქტი")),
            ContactEmail = $(byText("support@coinmania.ge")),
            PreevPage = $(byAttribute("href","http://preev.com")),
            PreevTitle = $("#title"),
            AmountField = $("#invField"),
            SelectedCur = $("#unitBSym"),
            CurButton = $("#curBut"),
            EurBtn = $(byAttribute("href","/btc/eur")),
            SettingBut = $("#settingsBut"),
            SelectLocalBTC = $(byText("LocalBitcoins"));




}