package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginRegisterPage {

    public SelenideElement
            RegisterPageBtn = $("#MainContent_CustomerNavBarGamma1_LoginRegisterLiteral").$(byText("რეგისტრაცია")),
            HeaderCheck = $(byText("რეგისტრაცია")),
            FirstNameInput = $("#MainContent_MainContent_FirstNameBox"),
            LastNameInput = $("#MainContent_MainContent_LastNameBox"),
            EmailInput = $("#MainContent_MainContent_EmailBox"),
            PasswordInput = $("#MainContent_MainContent_PasswordBox"),
            PasswordSeeBox = $("#showPassIcon"),
            RepeatPasswordInput = $("#MainContent_MainContent_ConfirmPasswordBox"),
            PassConfirmSeeBox = $("#showConfirmPassIcon"),
            TOSCheckBox = $("#MainContent_MainContent_AgreeToTermsCheckbox"),
            TermsPage = $("#MainContent_MainContent_AgreeWithTermsLabel").$(byLinkText("პირობებს")),
            TermsValidation = $("#MainContent_MainContent_Label1").$(byText("მომსახურების პირობები")),
            UsedEmail = $("#MainContent_MainContent_EmailBoxContainer").$(byText("ეს მისამართი უკვე გამოყენებულია")),
            RegisterBtn =  $("#BegisterButton"),
            LoginPageBtn = $("#MainContent_CustomerNavBarGamma1_LoginRegisterLiteral").$(byLinkText("შესვლა")),
            LoginHeader = $(".card-header").$(byText("შესვლა")),
            LoginMailInput = $("#MainContent_MainContent_UserNameBox"),
            PasswordReset = $("#MainContent_MainContent_LinkButton1"),
            PassResetPage = $(byText("პაროლის შეცვლა")),
            BotVerification = $("#MainContent_MainContent_RecaptchaContainer").$(byClassName("text-danger")),
            LoginBtn = $("#MainContent_MainContent_btnLogin"),
            PassResetMailBox = $("#MainContent_MainContent_CustomerEmailBox"),
            PassResetBtn = $("#MainContent_MainContent_SendUsernameButton"),
            PassResetMailVal = $("#MainContent_MainContent_CustomerEmailoxContainerInner").$(byClassName("text-danger"));




    public ElementsCollection CountryDropDown = $$(By.cssSelector("select#MainContent_MainContent_CountryCodeDropDownList"));




}
