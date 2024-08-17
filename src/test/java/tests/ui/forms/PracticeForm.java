package tests.ui.forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

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
    SelenideElement inputDateOfBirth = $x("//input[@id='dateOfBirthInput']");


    public SelenideElement getMaleRadioBtn() {
        return maleRadioBtn;
    }

    public SelenideElement getFemaleRadioBtn() {
        return femaleRadioBtn;
    }

    public SelenideElement getOtherRadioBtn() {
        return otherRadioBtn;
    }

    public PracticeForm practiceFormBtnEnterClick(){
        practiceFormBtn.should(Condition.visible).click();
       return this;
    }

    public PracticeForm inputFirstName(String strFirstName){
        inputFirstName.should(Condition.visible).setValue(strFirstName);
        return this;
    }

    public PracticeForm inputLastName(String strLastName){
        inputLastName.should(Condition.visible).setValue(strLastName);
        return this;
    }

    public PracticeForm inputEmail(String strEmail){
        inputEmail.should(Condition.visible).setValue(strEmail);
        return this;
    }

    public SelenideElement clickRadioBtn(SelenideElement element){
        element.should(Condition.visible).click();
        return element;
    }

    public PracticeForm clickRadioBtnBranch(SelenideElement element){
        clickRadioBtn(element);
        return this;
    }
//    public PracticeForm clickRadioBtn(){
//        maleRadioBtn.should(Condition.visible).click();
//        return this;
//    }

    public PracticeForm inputMobileNumber(String numbersMobile){
        inputNumberMobile.should(Condition.visible).setValue(numbersMobile);
        return this;
    }

    public PracticeForm inputDateClick(String strDate){//TODO сlear не очищает поле.setValue(), вернее очищает, но далее когда снова окно кликается выбирается текущая дата, как очистить? Или лучше выбирать по окнам?!
        inputDateOfBirth.should(Condition.visible, Duration.ofSeconds(5));
        inputDateOfBirth.setValue(strDate);
        return this;
    }


}
