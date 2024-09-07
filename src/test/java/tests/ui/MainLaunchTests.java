package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import tests.ui.elements.Links;
import tests.ui.elements.WebTables;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MainLaunchTests {


    private MainThreadQa mainThreadQa = new MainThreadQa();

    @BeforeEach
    public void openPage() {
        Selenide.open("/");
    }

    @BeforeAll
    public static void setUp() {//@BeforeAll надо
        Configuration.baseUrl = "http://85.192.34.140:8081";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void setUpFinal() {
        closeWebDriver();
    }

    @Test
    public void enterMainPageThreadQaTest() {
        int countBtn = 6;
        mainThreadQa.assertHeaderVisible()
                .assertCountBtnsMainPage(countBtn);
    }

    @Test
    @Tag("DROPDOWN")
    public void dropDownElementsClickTest() {
        int countBeforeClickElements = 9;
        int countAfterClickElements = 0;
        mainThreadQa.enterElements()
                .assertCountsElementsDropDown(countBeforeClickElements)
                .oneClickElements()
                .assertCountsElementsDropDown(countAfterClickElements);
    }


    @Test
    @Tag("ELEMENTS")
    public void enterTextBoxAssertHeaderTextTest() {
        String assertExpectedHeaderTextBox = "Text Box";
        mainThreadQa.enterElements()
                .enterTextBox()
                .assertHeaderPartialText(assertExpectedHeaderTextBox);
    }

    @Test
    @Tag("ELEMENTS")
    public void inputElementsTextBoxTest() {
        String fullName = "Gembaruk Igor";
        String email = "i.gembaruk@mail.ru";
        String currentAddress = "ul1 d.13";
        String permanentAddress = "ul2 d.23";

        mainThreadQa.enterElements()
                .enterTextBox()
                .setInputFullName(fullName)
                .setInputEmail(email)
                .setInputCurrentAddress(currentAddress)
                .setInputPermanentAddress(permanentAddress)
                .clickSubmitBtn()
                .assert1FullName(fullName)
                .assert2Email(email)
                .assert3CurrentAddress(currentAddress)
                .assert4PermanentAddress(permanentAddress);
    }

    @Test
    @Tag("ELEMENTS")
    public void enterCheckBoxAssertHeaderTextTest() {
        String expectedTextHeader = "Check Box";
        mainThreadQa.enterElements()
                .enterCheckBox()
                .assertHeaderPartialText(expectedTextHeader);
    }


    @Test
    @Tag("ELEMENTS")
    public void clickElementsCheckBoxTest() {
        mainThreadQa.enterElements()
                .enterCheckBox()
                .assertCountExpendedElements(0)
                .clickPlusBtn()
                .assertCountExpendedElements(6)
                .clickMinusBtn()
                .assertCountExpendedElements(0);

    }

    @Test
    @Tag("ELEMENTS")
    public void clickCheckBoxTest() {
        mainThreadQa.enterElements()
                .enterCheckBox()
                .clickArrowHomeBtn()
                .clickDesktopArrowBtn()
                .clickNotesBtn()
                .assertActiveFieldCheckBox("Notes");
    }

    @Test
    @Tag("ELEMENTS")
    public void radioBtnYesClickTest() {
        mainThreadQa.enterElements()
                .enterRadioButton()
                .radioButtonYesClick()
                .assertActiveFieldCheckBox("Yes");
    }

    @Test
    @Tag("ELEMENTS")
    public void radioBtnImpressiveClickTest() {
        mainThreadQa.enterElements()
                .enterRadioButton()
                .radioButtonImpressiveClick()
                .assertActiveFieldCheckBox("Impressive");
    }

    @Test
    @Tag("ELEMENTS")
    public void radioBtnDisablesNoTest() {
        mainThreadQa.enterElements()
                .enterRadioButton()
                .radioButtonNoHover()
                .assertionsDisabled();
    }

    @Test
    @Tag("ELEMENTS")
    public void enterWebTablesAssertHeaderTextTest() {
        String assertExpectedHeaderTextBox = "Web Tables";
        mainThreadQa.enterElements()
                .enterWebTables()
                .assertHeaderPartialText(assertExpectedHeaderTextBox);
    }

    @Test
    @Tag("ELEMENTS")
    public void webTablesDefaultAssertQuantityColumnEqualsQuantitySelectRowsTest() {
        int indexCollectionRowsDefault = 1;

        mainThreadQa.enterElements()
                .enterWebTables()
                .assertQuantityColumnEqualsQuantitySelectRows(indexCollectionRowsDefault);
    }

    @Test
    @Tag("ELEMENTS")
    public void webTablesAddNewUserTest() {
        String firstName = "Igor";
        String lastName = "Gembaruk";
        String email = "i.gembaruk@mail.ru";
        String age = "27";
        String salary = "100000";
        String departament = "Пенза";

        mainThreadQa.enterElements()
                .enterWebTables()
                .createClickAddBtn()
                .setValueInputFirstName(firstName)
                .setValueInputLastName(lastName)
                .setValueInputEmail(email)
                .setValueInputAge(age)
                .setValueSalary(salary)
                .setValueDepartment(departament)
                .clickSubmit()
                .setInputSearch(email)
                .assertInSearch(firstName)
                .assertInSearch(lastName)
                .assertInSearch(email)
                .assertInSearch(age)
                .assertInSearch(salary);
    }



    @Test
    public void webTablesSortedFirstNameTest(){
        mainThreadQa.enterElements()
                .enterWebTables();

        WebTables webTables = new WebTables();
        List<String> listDefault = webTables.newCollectionsAreColumnFirstNameStream();
        webTables.clickFirstName();
        List<String> listClickFirstName = webTables.newCollectionsAreColumnFirstNameStream();
        Assertions.assertNotEquals(listDefault, listClickFirstName);

        Assertions.assertEquals(listClickFirstName, webTables.listSorted(listDefault));
    }

    @Test
    @Tag("ELEMENTS")
    public void buttonsDoubleClickTest() {
        mainThreadQa.enterElements()
                .enterButtons()
                .doubleClickMe()
                .assertClick("double");
    }

    @Test
    @Tag("ELEMENTS")
    public void buttonsRightClickTest() {
        mainThreadQa.enterElements()
                .enterButtons()
                .rightClickMe()
                .assertClick("right");
    }

    @Test
    @Tag("ELEMENTS")
    public void buttonsClickMeTest() {
        mainThreadQa.enterElements()
                .enterButtons()
                .clickMeMethods()
                .assertClick("dynamic");
    }

    @Test
    @Tag("ELEMENTS")
    public void linksSwitchWindowsTest() {
        mainThreadQa.enterElements()
                .enterLinks()
                .enterNewWindowsHome()
                .assertCountWindows2()
                .switchTwoWindows();

        Links links = new Links();
        links.assertCountWindows2();
    }


    @Test
    @Tag("ELEMENTS")
    public void brokenLinksImagesValidLinkEnterTest() {
        MainThreadQa mainThreadQa = new MainThreadQa();
        mainThreadQa.enterElements()
                .enterBrokenLinksImages()
                .validLinkEnter()
                .assertionsNewLink()
                .assertionsNewLinkH1Google()
                .assertionUrl("https://www.google.com");
    }

    @Test
    @Tag("ELEMENTS")
    public void downloadFileTest() {
        mainThreadQa.enterElements()
                .enterUploadAndDownload()
                .downloadFile("sticker.png");
    }

    @Test
    @Tag("ELEMENTS")
    public void uploadFileTest() {
        mainThreadQa.enterElements()
                .enterUploadAndDownload()
                .uploadFile("src/test/resources/ArcheAge_sample.jpg");
    }

    @Test
    @Tag("ELEMENTS")
    public void dynamicPropertiesTestNotEnabledElementsTest() {
        mainThreadQa.enterElements()
                .enterDynamicProperties()
                .elementsNoEnabled4seconds()
                .elementsEnabled5seconds();

    }

    @Test
    @Tag("ELEMENTS")
    public void dynamicPropertiesTestEnabledElementsTest() {
        mainThreadQa.enterElements()
                .enterDynamicProperties()
                .elementsEnabled5seconds()
                .elementVisibleAfter5Seconds();//TODO, необходимо перейти, описана проблема, элемент вроде не должен здесь быть.

    }

    @Test
    public void practiceFormClickTest() {
        String firstName = "Igor";
        String lastName = "Gembaruk";
        String email = "i.gembaruk@mail.ru";
        String subject = "m";
        String numbersMobile = "9656363968";
        int strDate = 25;
        String currentAddress = "street Lunacharskogo";
        mainThreadQa.enterForms()
                .enterPracticeForm()
                .setInputFirstName(firstName)
                .assertFirstName(firstName)
                .setInputLastName(lastName)
                .assertLastName(lastName)
                .setInputEmail(email)
                .assertEmail(email)
                .clickRadioBtnMale()
                .assertSelectedRadioBtnMale()
                .setInputMobileNumber(numbersMobile)
                .assertMobileNumber(numbersMobile)
                .setDateOfBirth(strDate)
                .assertEqualsDate(strDate)
                .setSelectSubject(subject, 0)
                .setClickBtnCheckBoxSports()
                .assertBtnCheckBoxSportsChecked()
                .uploadFileAndAssertName("src/test/resources/ArcheAge_sample.jpg", "ArcheAge_sample.jpg")
                .setValueCurrentAddress(currentAddress)
                .setSelectState(0)
                .setSelectCity(0)
                .clickSubmitBtn();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterListAlertsFrameWindowsCounts5Test() {
        mainThreadQa.enterAlertsFrameWindows()
                .assertionsListQuantityt5();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterBrowserWindowsNewTabTest() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterBrowserWindows()
                .newTabClick()
                .assertCount2Windows()
                .switchTwoWindows()
                .assertToWindowsH1Text("Thread QA Sample");
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterBrowserWindowsNewWindowTest() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterBrowserWindows()
                .newWindowClick()
                .assertCount2Windows()
                .switchTwoWindows()
                .assertToWindowsH1Text("Thread QA Sample");
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterBrowserWindowsNewWindowMessageTest() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterBrowserWindows()
                .newWindowMessageClick()
                .assertCount2Windows();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterSimpleAlertsClickTest() {
        String text = "You clicked a button";
        mainThreadQa.enterAlertsFrameWindows()
                .enterAlerts()
                .clickBtnSee()
                .assertAlertText(text)
                .acceptAlert();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enter5SecondsAlertsClickTest() {
        String text = "This alert appeared after 5 seconds";
        mainThreadQa.enterAlertsFrameWindows()
                .enterAlerts()
                .clickBtn5Seconds()
                .assertAlertText(text)
                .acceptAlert();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterAlertsClickConfirmAppearAcceptTest() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterAlerts()
                .clickBtnConfirmAppear()
                .acceptAlert();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterAlertsClickConfirmAppearDismissTest() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterAlerts()
                .clickBtnConfirmAppear()
                .dismissAlert();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterAlertsSendKeysAccept() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterAlerts()
                .clickBtnAlertPrompt()
                .sendKeysAlert("Igor")
                .acceptAlert();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterAlertsSendKeysDismiss() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterAlerts()
                .clickBtnAlertPrompt()
                .sendKeysAlert("Igor")
                .dismissAlert();
    }

    @Disabled("Пока закончил писать на фреймах")
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterFrames() {
        mainThreadQa.enterAlertsFrameWindows()
                .enterFrames();
    }
}
