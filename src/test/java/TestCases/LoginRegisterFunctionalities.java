package TestCases;

import StepObject.RegisterAndLoginPageSteps;
import Utils.ChromeRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;


import java.io.IOException;

import static DataObject.WebsiteData.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.back;
import static org.testng.Assert.*;

@Epic("Coinmania Login/Register Test Cases")
public class LoginRegisterFunctionalities extends ChromeRunner {


    RegisterAndLoginPageSteps PageSteps = new RegisterAndLoginPageSteps();

    @Test(description = "Validating Registration Page")
    @Severity(SeverityLevel.CRITICAL)

    public void RegTest(){

        PageSteps.RegisterBtnClick();
        assertTrue(PageSteps.HeaderCheck.is(visible),"Registration Page Validation");
        PageSteps.TOSTick()
                .TermsPageClick();
        assertTrue(PageSteps.TermsValidation.is(visible));
        back();
        PageSteps.EmailFill(email)
                .CountryDropDownSelect()
                .FirstNameFill(firstname)
                .LastNameFill(lastname)
                .PasswordFill(password)
                .PasswordSeeCheck();
        assertEquals(PageSteps.PasswordInput.getValue(), password, "Password Validation");
        PageSteps.RepeatPasswordFill(password)
                .PasswordConfirmSeeCheck();
        assertEquals(PageSteps.RepeatPasswordInput.getValue(),password,"Repeat Password Validation");
        PageSteps.FinishRegisterBtn();
        assertTrue(PageSteps.UsedEmail.is(visible));
    }
    @Test(description = "Validating Login Page with Reset Pass Page")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginTest () throws BiffException, IOException {

        PageSteps.LoginPageClick();
        assertTrue(PageSteps.LoginHeader.is(visible));
        PageSteps.LoginEmailFill(emailtwo)
                .PasswordFill(password)
                .LoginBtnClick();
        assertEquals(PageSteps.BotVerification.getText(),botverificationmessage,"Veryfing If Antibot is working");
        PageSteps.PasswordResetBtn();
        assertTrue(PageSteps.PassResetPage.is(visible));
        PageSteps.ResetPassMailInput();

    }

}
