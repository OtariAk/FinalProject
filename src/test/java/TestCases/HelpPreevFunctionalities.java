package TestCases;

import StepObject.HelpPreevSteps;
import Utils.ChromeRunner;
import static DataObject.WebsiteData.*;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.*;
@Epic("Coinmania Help page and Preev.com Test Cases")
public class HelpPreevFunctionalities extends ChromeRunner {

    HelpPreevSteps HelpPreev = new HelpPreevSteps();
    @Test(description = "Validating Help Page")
    @Severity(SeverityLevel.TRIVIAL)

    public void HelpPageTest(){
        HelpPreev.HelpClick()
                .switchToNewTab();
        HelpPreev.HowToReg();
        assertTrue(HelpPreev.HowToRegVal.is(visible));
        back();
        HelpPreev.HowToTopUP()
                .GeoTopUpMethod();
        assertTrue(HelpPreev.GeoPageVal.is(visible));
        back();
        back();
        HelpPreev.TronCheckBtn();
        assertTrue(HelpPreev.TronYTVideo.is(visible));
        HelpPreev.ContactBtnClick();
        assertTrue(HelpPreev.ContactEmail.is(visible));

    }

    @Test(description = "Validating Preev Page")
    @Severity(SeverityLevel.MINOR)
    public void PreevPageTest(){
        HelpPreev.PreevPageClick();
        assertTrue(HelpPreev.PreevTitle.is(visible));
        HelpPreev.SelectLocalBTCs();
        String actualURL = url();
        assertTrue(actualURL.contains(expectedURL));
        HelpPreev.SetAmount("1")
                .EurCheck();
        assertEquals(HelpPreev.SelectedCur.getText(),"EUR");


    }

}
