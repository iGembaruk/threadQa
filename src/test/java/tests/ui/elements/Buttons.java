package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Buttons {
    SelenideElement doubleClickMeBtn = $x("//button[@id='doubleClickBtn']");
    SelenideElement rightClickMeBtn = $x("//button[@id='rightClickBtn']");
    SelenideElement clickMeBtn = $x("//button[text()='Click Me']");
    SelenideElement assertElement = $x("//p");
   // SelenideElement assertElement = $x("//p[@id='doubleClickMessage']");

    public Buttons doubleClickMeMethods(){
        doubleClickMeBtn.should(Condition.visible).doubleClick();
        return this;
    }
    public Buttons rightClickMeBMethods(){
    rightClickMeBtn.should(Condition.visible).contextClick();
            return this;
    }

    public Buttons clickMeMethods(){
    clickMeBtn.should(Condition.visible).click();
    return this;
    }

    public Buttons assertClick(String str){
       assertElement.should(Condition.partialText(str));
       return this;
    }

}
