package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class CheckBox {
    SelenideElement allCheckListEnter = $x("//button[@aria-label='Expand all']");
    SelenideElement allCheckListClose = $x("//button[@aria-label='Collapse all']");

    SelenideElement checkBoxHomeAllSelected = $x("//label[@for='tree-node-home']");


    SelenideElement result = $x("//div[@id='result']");

    public CheckBox clickAllCheckListEnter() {
        allCheckListEnter.should(Condition.visible).click();
        return this;
    }

    public CheckBox clickAllCheckListClose(){
        allCheckListClose.should(Condition.visible).click();
        return this;
    }


    public CheckBox clickCheckBox(List<SelenideElement> elements){
        elements.forEach(x->x.should(Condition.visible).click());
        return this;
    }

    public CheckBox assertionsResults(){

        return this;
    }

}
