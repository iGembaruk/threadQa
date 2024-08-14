package tests.ui.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.function.Predicate.not;

public class ElementsMain {
    SelenideElement elementsBtn = $x("//div[@class='header-text'][text()='Elements']");
    ElementsCollection listDropDownUl = $$x("//ul[@class='menu-list']");
    SelenideElement textBoxBtn = $x("//span[@class='text'][text()='Text Box']");

    SelenideElement checkBox = $x("//span[@class='text'][text()='Check Box']");

    SelenideElement radioButtonBtn = $x("//span[@class='text'][text()='Radio Button']");
    SelenideElement webTablesBtn = $x("//span[@class='text'][text()='Web Tables']");

    SelenideElement buttonBtn = $x("//span[@class='text'][text()='Buttons']");

    SelenideElement linksBtn = $x("//span[@class='text'][text()='Links']");



    SelenideElement uploadAndDownloadBtn = $x("//span[text()='Upload and Download']");


    public ElementsMain dropDownWindows(){
        elementsBtn.click();
        elementsBtn.click();
        return this;
    }

    public void assertionsNovisibleElementsList(){
        listDropDownUl.get(1).should(Condition.hidden);
    }

    public TextBox textBoxClick(){
        textBoxBtn.should(visible).click();
        return page(TextBox.class);
    }
    public CheckBox checkBoxClick(){
        checkBox.should(visible).click();
        return page(CheckBox.class);
    }

    public RadioButton radioButtonClick(){
       radioButtonBtn.should(visible).click();
       return page(RadioButton.class);
    }

    public WebTables webTables(){
        webTablesBtn.should(visible).click();
        return page(WebTables.class);
    }

    public Buttons buttonsClick(){
        buttonBtn.should(visible).click();
        return page(Buttons.class);
    }

    public Links linksClick(){
        linksBtn.should(visible).click();
        return page(Links.class);
    }

    public UploadAndDownload uploadAndDownloadClick(){
        uploadAndDownloadBtn.should(visible).click();
        return page(UploadAndDownload.class);
    }
}
