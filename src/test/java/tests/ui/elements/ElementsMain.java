package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ElementsMain {
    SelenideElement elementsBtn = $x("//div[@class='header-text'][text()='Elements']");
    SelenideElement textBoxBtn = $x("//span[@class='text'][text()='Text Box']");

    SelenideElement checkBox = $x("//span[@class='text'][text()='Check Box']");

    SelenideElement radioButtonBtn = $x("//span[@class='text'][text()='Radio Button']");
    SelenideElement webTablesBtn = $x("//span[@class='text'][text()='Web Tables']");

    SelenideElement buttonBtn = $x("//span[@class='text'][text()='Buttons']");

    SelenideElement linksBtn = $x("//span[@class='text'][text()='Links']");

    public ElementsMain dropDownWindows(){
        elementsBtn.click();
        elementsBtn.click();
        return this;
    }
    public TextBox textBoxClick(){
        textBoxBtn.should(Condition.visible).click();
        return page(TextBox.class);
    }
    public CheckBox checkBoxClick(){
        checkBox.should(Condition.visible).click();
        return page(CheckBox.class);
    }

    public RadioButton radioButtonClick(){
       radioButtonBtn.should(Condition.visible).click();
       return page(RadioButton.class);
    }

    public WebTables webTables(){
        webTablesBtn.should(Condition.visible).click();
        return page(WebTables.class);
    }

    public Buttons buttonsClick(){
        buttonBtn.should(Condition.visible).click();
        return page(Buttons.class);
    }

    public Links linksClick(){
        linksBtn.should(Condition.visible).click();
        return page(Links.class);
    }
}
