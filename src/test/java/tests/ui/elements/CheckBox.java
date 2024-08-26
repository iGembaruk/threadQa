package tests.ui.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBox {
    SelenideElement headerCheckBox = $x("//div[@class='main-header']");

    SelenideElement plusBtn = $x("//button[@aria-label='Expand all']");
    SelenideElement minusBtn = $x("//button[@aria-label='Collapse all']");
    SelenideElement homeArrayBtn;
    SelenideElement homeCheckBoxBtn = $x("//span[@class='rct-title']");

    SelenideElement arrayHomeBtn = $x("//li[@class='rct-node rct-node-parent rct-node-collapsed']/span/button[@aria-label='Toggle']");

    SelenideElement arrayDesktopBtn = $x("//li[contains(@class, 'collapsed')][1]//button");
    //вот эти три
    SelenideElement checkNotes = $x("//label[@for='tree-node-notes']//span[@class='rct-checkbox']");
    SelenideElement checkCommands = $x("//label[@for='tree-node-commands']//span[@class='rct-checkbox']");
    ElementsCollection collectionsElementsIsCheckBox = $$x("//span[@class='text-success']");

    public CheckBox assertHeaderPartialText(String assertExpectedStr){
    headerCheckBox.should(Condition.visible).should(Condition.partialText(assertExpectedStr));
        return this;
    }
//    public SelenideElement getCheckNotes() {
//        return checkNotes;
//    }
//
//    public SelenideElement getCheckCommands() {
//        return checkCommands;
//    }
//
//    public ElementsCollection getCollectionsElementsIsCheckBox() {
//        return collectionsElementsIsCheckBox;
//    }
//
//    SelenideElement arrayDocumentsBtn = $x("");
//    SelenideElement arrayDownloadsBtn = $x("");
//
//    SelenideElement checkBoxHomeAllSelected = $x("//label[@for='tree-node-home']");
//    SelenideElement result = $x("//div[@id='result']");
//
//    public CheckBox assertCountElementsIsDropDown(){
//        allListClassElements.size();
//        allListClassElements.should(CollectionCondition.size(6));
//        return this;
//    }
//
//    public CheckBox clickAllCheckListEnter() {
//        plusBtn.should(Condition.visible).click();
//        return this;
//    }
//
//    public CheckBox clickAllCheckListClose(){
//        minusBtn.should(Condition.visible).click();
//        return this;
//    }
//    public CheckBox assertionsCount0Elements(){
//        allListClassElements.should(CollectionCondition.size(0));
//        return this;
//    }
//
//    public CheckBox clickArrayHome(){
//        arrayHomeBtn.should(Condition.visible).click();
//        return this;
//    }
//
//    public CheckBox clickArrayDesktop(){
//        arrayDesktopBtn.should(Condition.visible).click();
//        return this;
//    }
//
//    public CheckBox clicksCheckBoxes(List<SelenideElement> elements){
//        elements.forEach(x->x.should(Condition.visible).click());
//        return this;
//    }
//    public CheckBox assertsCheckBox(List<SelenideElement> elements){
//        List<String> textsToCheck = elements.stream()
//                        .map(SelenideElement::getText)
//                                .toList();
//        for(String text : textsToCheck){
//            collectionsElementsIsCheckBox.find(Condition.partialText(text)).should(Condition.exist);
//        }
//        return this;
//    }
//
//
//

}
