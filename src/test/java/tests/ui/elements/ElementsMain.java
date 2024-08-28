package tests.ui.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ElementsMain {
    SelenideElement elementsBtn = $x("//div[@class='header-text'][text()='Elements']");
    ElementsCollection listIs9elementsIsList = $$x("//div[@class='element-list collapse show']/ul/li");

    SelenideElement textBoxBtn = $x("//span[@class='text'][text()='Text Box']");

    SelenideElement checkBoxBtn = $x("//span[@class='text'][text()='Check Box']");

    SelenideElement radioButtonBtn = $x("//span[@class='text'][text()='Radio Button']");
    SelenideElement webTablesBtn = $x("//span[@class='text'][text()='Web Tables']");

    SelenideElement buttonBtn = $x("//span[@class='text'][text()='Buttons']");

    SelenideElement linksBtn = $x("//span[@class='text'][text()='Links']");

    SelenideElement brokenLinksImagesBtn = $x("//span[@class='text'][text()='Broken Links - Images']");

    SelenideElement uploadAndDownloadBtn = $x("//span[text()='Upload and Download']");

    SelenideElement dynamicPropertiesBtn = $x("//span[@class='text'][text()='Dynamic Properties']");


    public ElementsMain oneClickElements(){
        elementsBtn.click();
        return this;
    }

    public ElementsMain assertCountsElementsDropDown(int countElements){
        listIs9elementsIsList.should(CollectionCondition.size(countElements));
        return this;
    }

    public TextBox enterTextBox(){
        textBoxBtn.should(visible).click();
        return page(TextBox.class);
    }
    public CheckBox enterCheckBox(){
        checkBoxBtn.should(visible).click();
        return page(CheckBox.class);
    }

    public RadioButton enterRadioButton(){
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

    public BrokenLinksImages brokenLinksImagesClick(){
        brokenLinksImagesBtn.should(visible).click();
        return page(BrokenLinksImages.class);
    }

    public UploadAndDownload uploadAndDownloadClick(){
        uploadAndDownloadBtn.should(visible).click();
        return page(UploadAndDownload.class);
    }

    public DynamicProperties dynamicPropertiesClick(){
        dynamicPropertiesBtn.should(visible).click();
        return page(DynamicProperties.class);
    }

}
