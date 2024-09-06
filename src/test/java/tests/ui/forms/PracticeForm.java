package tests.ui.forms;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeForm {
    SelenideElement practiceFormBtn = $x("//span[@class='text'][text()='Practice Form']");

    SelenideElement inputFirstName = $x("//input[@placeholder='First Name']");
    SelenideElement inputLastName = $x("//input[@placeholder='Last Name']");
    SelenideElement inputEmail = $x("//input[@placeholder='name@example.com']");

    SelenideElement maleRadioBtn = $x("//div[@class='custom-control custom-radio custom-control-inline'][1]");
    SelenideElement maleRadioBtnSelected = $x("//input[@value='Male']");
    SelenideElement femaleRadioBtn = $x("//div[@class='custom-control custom-radio custom-control-inline'][2]");
    SelenideElement otherRadioBtn = $x("//div[@class='custom-control custom-radio custom-control-inline'][3]");

    SelenideElement inputNumberMobile = $x("//input[@placeholder='Mobile Number']");

    SelenideElement inputDateOfBirthClick = $x("//input[@id='dateOfBirthInput']");
    SelenideElement widowCalendar = $x("//div[@class='react-datepicker__month-container']");
    SelenideElement assertDay = $x("//input[@id='dateOfBirthInput']");

    SelenideElement inputSubject = $x("//input[@id='subjectsInput']");
    ElementsCollection listSubjects5EElements = $$x("//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']/div");

    SelenideElement checkBoxSportsBtn = $x("//label[@class='custom-control-label'][text()='Sports']");
    SelenideElement checkBoxReadingBtn = $x("//label[@class='custom-control-label'][text()='Reading']");
    SelenideElement checkBoxMusicBtn = $x("//label[@class='custom-control-label'][text()='Music']");
    SelenideElement checkBoxSportsBtnChecked = $x("//input[@value='1']");

    SelenideElement uploadBtn = $x("//input[@id='uploadPicture']");

    private String strSearchDate = "//div[contains(@class, '--0%d')]";

    SelenideElement inputCurrentAddress = $x("//textarea[@placeholder='Current Address']");

    SelenideElement dropDownSelectStateBtn = $x("//div[@class=' css-1wa3eu0-placeholder'][contains(text(), 'State')]");
    ElementsCollection listState4Elements = $$x("//div[@class=' css-11unzgr']/div");

    SelenideElement dropDownSelectCityBtn = $x("//div[@class=' css-1wa3eu0-placeholder'][contains(text(), 'City')]");
    ElementsCollection listCity3Elements = $$x("//div[@class=' css-11unzgr']/div");

    SelenideElement submitBtn = $x("//button[@id='submit']");


    public PracticeForm enterPracticeForm(){
        practiceFormBtn.should(Condition.visible).click();
       return this;
    }

    public PracticeForm setInputFirstName(String strFirstName){
        inputFirstName.should(Condition.visible).setValue(strFirstName);
        return this;
    }
    public PracticeForm assertFirstName(String strFirstName){
        inputFirstName.should(Condition.enabled).getValue().equals(strFirstName);
        return this;
    }

    public PracticeForm setInputLastName(String strLastName){
        inputLastName.should(Condition.visible).setValue(strLastName);
        return this;
    }
    public PracticeForm assertLastName(String strLastName){
        inputLastName.should(Condition.enabled).getValue().equals(strLastName);
        return this;
    }

    public PracticeForm setInputEmail(String strEmail){
        inputEmail.should(Condition.visible).setValue(strEmail);
        return this;
    }
    public PracticeForm assertEmail(String strEmail){
        inputEmail.should(Condition.enabled).getValue().equals(strEmail);
        return this;
    }

    public PracticeForm clickRadioBtnMale(){
        maleRadioBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm assertSelectedRadioBtnMale(){
        maleRadioBtnSelected.shouldHave(Condition.selected);
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
    public PracticeForm assertMobileNumber(String numbersMobile){
        inputNumberMobile.should(Condition.enabled).getValue().equals(numbersMobile);
        return this;
    }

    public PracticeForm setSelectSubject(String subject, int getIdCollection){
        inputSubject.should(Condition.enabled).setValue(subject);
        listSubjects5EElements.should(CollectionCondition.size(5)).get(getIdCollection).click();
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

//    public String returnDateOfBirthString(){
//     String strDate = assertDay.getValue();
//        return Arrays.stream(strDate.split(" "))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Дата не указана"));
//    }

    public PracticeForm assertEqualsDate(int date){
        assertDay.shouldHave(Condition.partialValue(String.valueOf(date)));
        return this;
    }

    public PracticeForm setClickBtnCheckBoxSports(){
        checkBoxSportsBtn.should(Condition.enabled).click();
        return this;
    }

    public PracticeForm assertBtnCheckBoxSportsChecked(){
        checkBoxSportsBtnChecked.shouldHave(Condition.checked);
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

    public PracticeForm setValueCurrentAddress(String currentAddress){
        inputCurrentAddress.should(Condition.enabled).setValue(currentAddress);
        return this;
    }

    public PracticeForm setSelectState(int getIdCollection){
        dropDownSelectStateBtn.should(Condition.enabled).click();
        listState4Elements.should(CollectionCondition.size(4)).get(getIdCollection).click();
        return this;
    }

    public PracticeForm setSelectCity(int getIdCollection){
        dropDownSelectCityBtn.should(Condition.enabled).click();
        listCity3Elements.should(CollectionCondition.size(3)).get(getIdCollection).click();
        return this;
    }

    public PracticeForm clickSubmitBtn(){
        submitBtn.should(Condition.enabled).click();
        return this;
    }
}
