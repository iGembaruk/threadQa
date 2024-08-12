package tests.ui.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.ToString;
import com.codeborne.selenide.impl.CollectionElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBox {
    SelenideElement allCheckListEnter = $x("//button[@aria-label='Expand all']");
    SelenideElement allCheckListClose = $x("//button[@aria-label='Collapse all']");
    ElementsCollection allListClassElements = $$x("//li[@class='rct-node rct-node-parent rct-node-expanded']");


    SelenideElement arrayHomeBtn = $x("//li[@class='rct-node rct-node-parent rct-node-collapsed']/span/button[@aria-label='Toggle']");

    SelenideElement arrayDesktopBtn = $x("//li[contains(@class, 'collapsed')][1]//button");
    public SelenideElement checkNotes = $x("//label[@for='tree-node-notes']//span[@class='rct-checkbox']");
    public SelenideElement checkCommands = $x("//label[@for='tree-node-commands']//span[@class='rct-checkbox']");
    public ElementsCollection collectionsElementsIsCheckBox = $$x("//span[@class='text-success']");

    SelenideElement arrayDocumentsBtn = $x("");
    SelenideElement arrayDownloadsBtn = $x("");

    SelenideElement checkBoxHomeAllSelected = $x("//label[@for='tree-node-home']");
    SelenideElement result = $x("//div[@id='result']");

    public CheckBox clickAllCheckListEnter() {
        allCheckListEnter.should(Condition.visible).click();
        return this;
    }
    public CheckBox assertionsCount6Elements(){
        allListClassElements.should(CollectionCondition.size(6));
        return this;
    }

    public CheckBox clickAllCheckListClose(){
        allCheckListClose.should(Condition.visible).click();
        return this;
    }
    public CheckBox assertionsCount0Elements(){
        allListClassElements.should(CollectionCondition.size(0));
        return this;
    }

    public CheckBox clickArrayHome(){
        arrayHomeBtn.should(Condition.visible).click();
        return this;
    }

    public CheckBox clickArrayDesktop(){
        arrayDesktopBtn.should(Condition.visible).click();
        return this;
    }

//    public CheckBox clickCheckNotes(){
//        checkNotes.should(Condition.visible).click();
//        return this;
//    }

    public CheckBox clicksCheckBoxes(List<SelenideElement> elements){
        elements.forEach(x->x.should(Condition.visible).click());
        return this;
    }
    public CheckBox assertsCheckBox(List<SelenideElement> elements){
        List<String> textsToCheck = elements.stream()
                        .map(SelenideElement::getText)
                                .toList();
        for(String text : textsToCheck){
            collectionsElementsIsCheckBox.find(Condition.partialText(text)).should(Condition.exist);
        }
        return this;
    }




}
