package StepObject;

import PageObject.LoginRegisterPage;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import jxl.*;
import jxl.read.biff.BiffException;

import java.io.*;
import java.time.Duration;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class RegisterAndLoginPageSteps extends LoginRegisterPage {

    @Step("Register page click")
    public void RegisterBtnClick(){
        RegisterPageBtn.click();
    }
    @Step("Email Input")
    public RegisterAndLoginPageSteps EmailFill(String email1){
        EmailInput.click();
        EmailInput.setValue(email1);
        return this;
    }
    @Step("First Name Input")
    public RegisterAndLoginPageSteps FirstNameFill(String name){
        FirstNameInput.click();
        FirstNameInput.setValue(name);
        return this;
    }
    @Step("Country Drop-Down Select")
    public RegisterAndLoginPageSteps CountryDropDownSelect(){
        for(SelenideElement i : CountryDropDown){
            String text = i.getText();
            if (text.equals("Georgia")) {
                i.click();
                break;
            }
        }
        return this;
    }

    @Step("Last Name Input")
    public RegisterAndLoginPageSteps LastNameFill(String last){
        LastNameInput.click();
        LastNameInput.setValue(last);
        return this;
    }

    @Step("Password Input")
    public RegisterAndLoginPageSteps PasswordFill(String pass){
        PasswordInput.click();
        PasswordInput.setValue(pass);
        return this;
    }
    @Step("See Password Button Click ")
    public void PasswordSeeCheck(){
        PasswordSeeBox.click();
    }
    @Step("Repeat Password Input")
    public RegisterAndLoginPageSteps RepeatPasswordFill(String pass1){
        RepeatPasswordInput.click();
        RepeatPasswordInput.setValue(pass1);
        return this;
    }
    @Step("See Password Button Click on Repeat Password field")
    public void PasswordConfirmSeeCheck(){
        PassConfirmSeeBox.click();
    }
    @Step("Terms Of Service Checkbox ")
    public RegisterAndLoginPageSteps TOSTick(){
        TOSCheckBox.click();
        return this;
    }

    @Step("Terms Page Button Click")
    public void TermsPageClick(){
        TermsPage.click();
    }

    @Step("Finish Registration Button")
    public void FinishRegisterBtn(){
        RegisterBtn.click(ClickOptions.withTimeout(Duration.ofMillis(5000)));
    }
    @Step("Login Page Button")
    public void LoginPageClick(){
        LoginPageBtn.click();
    }

    @Step("Login Email Input")
    public RegisterAndLoginPageSteps LoginEmailFill(String email2){
        LoginMailInput.click();
        LoginMailInput.setValue(email2);
        return this;
    }
    @Step("Password Reset Button")
    public void PasswordResetBtn(){
        PasswordReset.click();
    }
    @Step("Login Button Click")
    public void LoginBtnClick(){
        LoginBtn.click();
    }

    //ამ მეთოდს მოაქვს მონაცემები ექსელის ფაილიდან და ამოწმებს დაბლოკილ მომხმარებლებს საიტზე რომელსაც გამოიტანს შემდეგ კონსოლში.
    // ამავე კოდში არის ჩაქსოვილი ერთი ასერშენი რომელიც ამოწმებს მართლა არის თუარა მომხმარებელი დაბლოკილი
    @Step("Reset Password Email Input")
    public void ResetPassMailInput() throws  IOException, BiffException {
        PassResetMailBox.click();
        String filePath = "files\\Userlist.xls";
        FileInputStream fs = new FileInputStream(filePath);
        Workbook wb = Workbook.getWorkbook(fs);
        Sheet sheet = wb.getSheet("Userlist");
        int totalNoOfRows = sheet.getRows();
        List<String> blockedCustomers = new ArrayList<>();

        for (int row = 1; row < totalNoOfRows; row++){
            PassResetMailBox.setValue(sheet.getCell(0,row).getContents());
            PassResetBtn.click();
            String txt1 = "მომხმარებელი ვერ მოიძებნა";
            String txt2 = "მომხმარებელი დაბლოკილია";
            if(PassResetMailVal.getText().equals(txt1)){
                continue;
            }
            if (PassResetMailVal.getText().equals(txt2)){
                blockedCustomers.add(sheet.getCell(0,row).getContents());
                assertEquals(PassResetMailVal.getText(),txt2);
                }
            for (String customer : blockedCustomers) {
                System.out.println(customer + " is blocked.");
            }
        }
    }


}
