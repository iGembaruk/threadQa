package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TextBox {
    SelenideElement textBoxHeder = $x("//div[@class='main-header']");

    SelenideElement inputFullName = $x("//input[@placeholder='Full Name']");
    SelenideElement inputEmail = $x("//input[@placeholder='name@example.com']");
    SelenideElement inputCurrentAddress = $x("//textarea[@placeholder='Current Address']");
    SelenideElement inputPermanentAddress = $x("//textarea[@id='permanentAddress']");
    SelenideElement submitBtn = $x("//button[@id='submit']");

    SelenideElement assertName = $x("//p[@id='name']");
    SelenideElement assertEmail = $x("//p[@id='email']");
    SelenideElement assertCurrentAddress = $x("//p[@id='currentAddress']");
    SelenideElement assertPermanentAddress = $x("//p[@id='permanentAddress']");

    public TextBox assertHeaderPartialText(String assertExpectedStr){
        textBoxHeder.should(Condition.partialText(assertExpectedStr));
        return this;
    }

    public TextBox setInputFullName(String string){
        inputFullName.should(Condition.enabled).setValue(string);
        return this;
    }

    public TextBox setInputEmail(String string){
        inputEmail.should(Condition.enabled).setValue(string);
        return this;
    }

    public TextBox setInputCurrentAddress(String string){
        inputCurrentAddress.should(Condition.enabled).setValue(string);
        return this;
    }

    public TextBox setInputPermanentAddress(String string){
        inputPermanentAddress.should(Condition.enabled).setValue(string);
        return this;
    }

    public TextBox clickSubmitBtn(){
        submitBtn.click();
        return this;
    }
    public TextBox assert1FullName(String str){
        assertName.should(Condition.visible).should(Condition.partialText(str));
        return this;
    }
    public TextBox assert2Email(String str){
        assertEmail.should(Condition.visible).should(Condition.partialText(str));
        return this;
    }
    public TextBox assert3CurrentAddress(String str){
        assertCurrentAddress.should(Condition.visible).should(Condition.partialText(str));
        return this;
    }

    public TextBox assert4PermanentAddress(String str){
        assertPermanentAddress.should(Condition.visible).should(Condition.partialText(str));
        return this;
    }
}
