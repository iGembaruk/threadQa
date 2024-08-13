package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RadioButton {
    SelenideElement radioButtonRdBtnYes =$x("//label[@class='custom-control-label'][text()='Yes']");
    SelenideElement impressiveRdBtn =$x("//label[@class='custom-control-label'][not(text()='Yes')]");
    SelenideElement assertionsYouHAveSelected = $x("//span[@class='text-success']");

    SelenideElement notClickNo = $x("//input[@class='custom-control-input disabled']");

    public RadioButton radioButtonYesClick(){
        radioButtonRdBtnYes.should(Condition.visible).click();
        return this;
    }

    public RadioButton radioButtonImpressiveClick(){
        impressiveRdBtn.should(Condition.visible).click();
        return this;
    }

    public RadioButton assertionsYouHAveSelected(String strBtn){
        assertionsYouHAveSelected.should(Condition.partialText(strBtn));
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

