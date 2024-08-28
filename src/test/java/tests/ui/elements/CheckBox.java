package tests.ui.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBox {
    SelenideElement headerCheckBox = $x("//div[@class='main-header']");

    SelenideElement plusBtn = $x("//button[@aria-label='Expand all']");
    SelenideElement minusBtn = $x("//button[@aria-label='Collapse all']");
    SelenideElement homeArrowCheckBoxBtn = $x("//button[@class='rct-collapse rct-collapse-btn']");
    SelenideElement homeCheckBoxBtn = $x("//span[@class='rct-title']");

    //развернутые блоки с элементами.
    ElementsCollection expandedElements = $$x("//li[@class='rct-node rct-node-parent rct-node-expanded']");

    //Descktop
    SelenideElement arrowDesktopBtn = $x("//li[contains(@class, 'collapsed')][1]//button");
    SelenideElement desktopCheckBoxBtn = $x("//label[@for='tree-node-desktop']");
    SelenideElement notesCheckBoxBtn = $x("//label[@for='tree-node-notes']//span[@class='rct-checkbox']");
    SelenideElement commandsCheckBoxBtn = $x("//label[@for='tree-node-commands']//span[@class='rct-checkbox']");
    //Проверки
    SelenideElement fieldActiveCheckBox = $x("//div[@class='display-result mt-4']");

    public CheckBox assertHeaderPartialText(String assertExpectedStr) {
        headerCheckBox.should(Condition.visible).should(Condition.partialText(assertExpectedStr));
        return this;
    }

    public CheckBox clickPlusBtn() {
        plusBtn.should(Condition.enabled).click();
        return this;
    }

    public CheckBox clickMinusBtn() {
        minusBtn.should(Condition.enabled).click();
        return this;
    }

    public CheckBox assertCountExpendedElements(int countExpected){
        expandedElements.should(CollectionCondition.size(countExpected));
        return this;
    }

    public CheckBox clickArrowHomeBtn(){
        homeArrowCheckBoxBtn.should(Condition.enabled).click();
        return this;
    }

    public CheckBox clickDesktopArrowBtn(){
        arrowDesktopBtn.should(Condition.enabled).click();
        return this;
    }

    public CheckBox clickNotesBtn(){
        notesCheckBoxBtn.should(Condition.enabled).click();
        return this;
    }

    public CheckBox assertActiveFieldCheckBox(String assertStr){
    fieldActiveCheckBox.should(Condition.visible).should(Condition.partialText(assertStr));
        return this;
    }
}
