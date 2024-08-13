package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.ui.elements.CheckBox;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MainLaunchTests {
    private String fullName = "Gembaruk Igor";
    private String firstName = "Oki";
    private String email = "i.gembaruk@mail.ru";
    private String address1 = "ul1 d.13";
    private Integer age = 27;
    private Integer salary = 100000;
    private String address2 = "ul2 d.23";
    private String departament = "Penza";
    private int indexCollectionRowsDefault = 1;
    private int intIndex20Rows = 2;
    CheckBox checkBox = new CheckBox();
    List<SelenideElement> elements = new ArrayList<>();



    @BeforeEach
    public void setUp(){
        Configuration.baseUrl = "http://85.192.34.140:8081";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }
    @AfterEach
    public void setUpFinal(){
        closeWebDriver();
    }

    @Test
    public void dropDownWindowsElementsClick(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .dropDownWindows();
    }

    @Test
    public void clickElementsTest(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .dropDownWindows()
                .textBoxClick();
    }

    @Test
    public void inputElementsTextBoxTest(){

        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .textBoxClick()
                .inputFullNameEnter(fullName)
                .inputEmailEnter(email)
                .inputCurrentAddressEnter(address1)
                .inputPermanentAddressEnter(address2)
                .clickSubmitBtn()
                .assert1FullName(fullName)
                .assert2Email(email)
                .assert3CurrentAddress(address1)
                .assert4PermanentAddress(address2);
    }

    @Test
    public void clickElementsCheckBoxTest(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .checkBoxClick()
                .clickAllCheckListEnter()
                .assertionsCount6Elements()
                .clickAllCheckListClose()
                .assertionsCount0Elements();
    }

    @Test//TODO работает без проверки .assertsCheckBox(checkBoxesToClick)
    public void clickElementsCheckBoxManySelenideElementsTest(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        List<SelenideElement> checkBoxesToClick = new ArrayList<>();
        checkBoxesToClick.add(checkBox.getCheckNotes());
        checkBoxesToClick.add(checkBox.getCheckCommands());
        mainWebSiteTest.enterElementsClick()
                .checkBoxClick()
                .clickArrayHome()
                .clickArrayDesktop()
                .clicksCheckBoxes(checkBoxesToClick);
                //assertsCheckBox(checkBoxesToClick);
    }
    @Test
    public void radioBtnYesClick(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .radioButtonClick()
                .radioButtonYesClick()
                .assertionsYouHAveSelected("Yes");// TODO, вероятно нужно извлекать элемент .text
    }

    @Test
    public void radioBtnImpressiveClick(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .radioButtonClick()
                .radioButtonImpressiveClick()
                .assertionsYouHAveSelected("Impressive");// TODO, вероятно нужно извлекать элемент .text
    }
    @Test
    public void radioBtnDisablesNo(){//TODO, пункт 4 моего файла
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .radioButtonClick()
                .radioButtonNoHover()
                .assertionsDisabled();
    }

    @Test
    public void webTablesAssertionCountTablesColumnAndIntRowsDropWindows() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .webTables()
                .assertionsCountColumnInTablesOnIntRowsDropWindows(indexCollectionRowsDefault);
    }

    @Test
    public void webTablesClick(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .webTables()
                .createClickAddBtn()
                .setValueInputFirstName(firstName)
                .setValueInputLastName(fullName)
                .setValueInputEmail(email)
                .setValueInputAge(age)
                .setValueSalary(salary)
                .setValueDepartment(departament)
                .clickSubmit()
                .inputSearch(email)
                .assertionDefaultClickDropDownWindowsCountRows(intIndex20Rows)
                .assertionsCountColumnInTablesOnIntRowsDropWindows(intIndex20Rows)
                .assertionStringIsSearch(firstName)
                .assertionStringIsSearch(fullName)
                .assertionStringIsSearch(email)
                .assertionIntegerIsSearch(age)//TODO, Возможно, что этот метод проверки стоит завязать на том, что необходимо искать не по тексту, а по числам, но не смог сделать
                .assertionIntegerIsSearch(salary);
    }
    @Test
    public void buttonsDoubleClick(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .buttonsClick()
                .doubleClickMeMethods()
                .assertClick("double");// TODO Как то извлечь одно слово?
    }

    @Test
    public void buttonsRightClick(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .buttonsClick()
                .rightClickMeBMethods()
                .assertClick("right");
    }
    @Test
    public void buttonsClickMe(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .buttonsClick()
                .clickMeMethods()
                .assertClick("dynamic");
    }
    @Test
    public void linksNewWindows(){
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .linksClick()
                .enterNewWindows()
                .assertionsCountWindows2();
    }

}
