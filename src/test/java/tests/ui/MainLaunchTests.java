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


    List<SelenideElement> elements = new ArrayList<>();
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
        Configuration.timeout = 2000;
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

    //TODO, добавить тест проверки битой ссылки.


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
    public void practiceFormClikTest() {
        String firstName = "Igor";
        String lastName = "Gembaruk";
        String email = "i.gembaruk@mail.ru";
        String age = "27";
        String salary = "100000";
        String subject = "Пенза";
        String numbersMobile = "9656363968";
        int strDate = 25;
        String currentAddress = "street Lunacharskogo";
        mainThreadQa.enterForms()
                .enterPracticeForm()
                .setInputFirstName(firstName)
                .setInputLastName(lastName)
                .setInputEmail(email)
                .clickRadioBtnMale()
                .setInputMobileNumber(numbersMobile)
                .setDateOfBirth(strDate)
                .setInputSubject(subject);
                //Hobbeis Btn
                //Upload file
                //Current Address String
                //dropDown Stat
                //dropDown City
                //submit click
    }
//
//    @Test
//    @Tag("ALERTSFRAMEWINDOWS")
//    public void enterListAlertsFrameWindowsCounts5Test() {
//        PracticeForm practiceForm = new PracticeForm();
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterListAlertsFrameWindows()
//                .assertionsListCount5();
//    }
//
//    @Test
//    @Tag("ALERTSFRAMEWINDOWS")
//    public void enterBrowserWindowsTest() {
//        PracticeForm practiceForm = new PracticeForm();
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterListAlertsFrameWindows()
//                .enterBrowsers()
//                .newTabWindowsBrowserWindows()
//                .assertionsCount2Windows();
//    }
//
//    @Test
//    @Tag("ALERTSFRAMEWINDOWS")
//    public void enterBrowserWindowsToSwitchTextTest() {
//        PracticeForm practiceForm = new PracticeForm();
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterListAlertsFrameWindows()
//                .enterBrowsers()
//                .newTabWindowsBrowserWindows()
//                .switchTwoWindows()
//                .assertionsToWindowsText("Thread QA Sample");
//    }

//    @Test
//    public void a() throws FileNotDownloadedError {
//      String url = mainThreadQa.enterElementsClick()
//               .brokenLinksImagesClick()
//               .getInvalidUrl();
////      Selenide.open(url);
////      $x("//pre").should(Condition.text("Cannot GET /images/ThreadQa.jpg"));
//        Assertions.assertThrows(FileNotDownloadedError.class,  () -> Selenide.download(url)) ;
//    }
//
}
