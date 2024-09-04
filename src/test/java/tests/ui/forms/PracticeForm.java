package tests.ui.forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class PracticeForm {
    SelenideElement practiceFormBtn = $x("//span[@class='text'][text()='Practice Form']");

    SelenideElement inputFirstName = $x("//input[@placeholder='First Name']");
    SelenideElement inputLastName = $x("//input[@placeholder='Last Name']");
    SelenideElement inputEmail = $x("//input[@placeholder='name@example.com']");

   // SelenideElement maleRadioBtn = $x("//input[@value='Male']");TODO 12 пункт
    SelenideElement maleRadioBtn = $x("//div[@class='custom-control custom-radio custom-control-inline'][1]");
    SelenideElement femaleRadioBtn = $x("//div[@class='custom-control custom-radio custom-control-inline'][2]");
    SelenideElement otherRadioBtn = $x("//div[@class='custom-control custom-radio custom-control-inline'][3]");

    SelenideElement inputNumberMobile = $x("//input[@placeholder='Mobile Number']");
    SelenideElement inputDateOfBirthClick = $x("//input[@id='dateOfBirthInput']");
    SelenideElement widowCalendar = $x("//div[@class='react-datepicker__month-container']");

    SelenideElement checkBoxSportsBtn = $x("//label[@class='custom-control-label'][text()='Sports']");
    SelenideElement checkBoxReadingBtn = $x("//label[@class='custom-control-label'][text()='Reading']");
    SelenideElement checkBoxMusicBtn = $x("//label[@class='custom-control-label'][text()='Music']");

    SelenideElement uploadBtn = $x("//input[@id='uploadPicture']");

    private String strSearchDate = "//div[contains(@class, '--0%d')]";

    public PracticeForm enterPracticeForm(){
        practiceFormBtn.should(Condition.visible).click();
       return this;
    }

    public PracticeForm setInputFirstName(String strFirstName){
        inputFirstName.should(Condition.visible).setValue(strFirstName);
        return this;
    }

    public PracticeForm setInputLastName(String strLastName){
        inputLastName.should(Condition.visible).setValue(strLastName);
        return this;
    }

    public PracticeForm setInputEmail(String strEmail){
        inputEmail.should(Condition.visible).setValue(strEmail);
        return this;
    }

    public PracticeForm clickRadioBtnMale(){
        maleRadioBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm clickRadioBtnFemale(){
        femaleRadioBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm clickRadioBtnOther(){
        otherRadioBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm setInputMobileNumber(String numbersMobile){
        inputNumberMobile.should(Condition.visible).setValue(numbersMobile);
        return this;
    }

    public PracticeForm setInputSubject(String subject){
        inputNumberMobile.should(Condition.visible).setValue(subject);
        return this;
    }

    private SelenideElement getDay(int day){
        return $x(String.format(strSearchDate, day));
    }

    public PracticeForm setDateOfBirth(int day){
        inputDateOfBirthClick.click();
        widowCalendar.should(Condition.visible);
        getDay(day).click();
        return this;
    }
    public PracticeForm setClickBtnCheckBoxSports(){
        checkBoxSportsBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm setClickBtnCheckBoxReading(){
        checkBoxReadingBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm setClickBtnCheckBoxMusic(){
        checkBoxMusicBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm uploadFileAndAssertName(String path, String nameFile) {
        File fileToUpload = new File(path);
        uploadBtn.uploadFile(fileToUpload);
        Assertions.assertEquals(fileToUpload.getName(), nameFile);
        return this;
    }
}
