package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RadioButton {
    SelenideElement radioButtonRdBtnYes =$x("//label[@class='custom-control-label'][text()='Yes']");
    SelenideElement impressiveRdBtn =$x("//label[@class='custom-control-label'][not(text()='Yes')]");
    SelenideElement fieldActiveRadioButton = $x("//p[@class='mt-3']");

    SelenideElement notClickNo = $x("//input[@class='custom-control-input disabled']");

    public RadioButton radioButtonYesClick(){
        radioButtonRdBtnYes.should(Condition.enabled).click();
        return this;
    }

    public RadioButton radioButtonImpressiveClick(){
        impressiveRdBtn.should(Condition.enabled).click();
        return this;
    }

    public RadioButton assertActiveFieldCheckBox(String assertStr){
        fieldActiveRadioButton.should(Condition.visible).should(Condition.partialText(assertStr));
        return this;
    }


    public RadioButton radioButtonNoHover(){
        notClickNo.should(Condition.hidden).hover();
        return this;
    }
    public RadioButton assertionsDisabled(){
        notClickNo.should(Condition.disabled);
        return this;
    }
}

