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

}
