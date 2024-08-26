package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import tests.ui.elements.CheckBox;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MainLaunchTests {
    private String firstName = "Oki";
    private String lastName = "blabla";
    private Integer age = 27;
    private Integer salary = 100000;
    private String numbersMobile = "9656363968";
    private String strDate = "01 Aug 2025";
    private String departament = "Penza";
    private int indexCollectionRowsDefault = 1;
    private int intIndex20Rows = 2;
    CheckBox checkBox = new CheckBox();
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
                .inputFullName(fullName)
                .inputEmail(email)
                .inputCurrentAddress(currentAddress)
                .inputPermanentAddress(permanentAddress)
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
}
//    @Test//TODO, 3ий пункт. работает без проверки .assertsCheckBox(checkBoxesToClick)
//    @Tag("ELEMENTS")
//    public void clickElementsCheckBoxManySelenideElementsTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        List<SelenideElement> checkBoxesToClick = new ArrayList<>();
//        checkBoxesToClick.add(checkBox.getCheckNotes());
//        checkBoxesToClick.add(checkBox.getCheckCommands());
//        mainThreadQa.enterElementsClick()
//                .checkBoxClick()
//                .clickArrayHome()
//                .clickArrayDesktop()
//                .clicksCheckBoxes(checkBoxesToClick);
//        //assertsCheckBox(checkBoxesToClick);
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void radioBtnYesClickTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .radioButtonClick()
//                .radioButtonYesClick()
//                .assertionsYouHAveSelected("Yes");// TODO, вероятно нужно извлекать элемент .text
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void radioBtnImpressiveClickTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .radioButtonClick()
//                .radioButtonImpressiveClick()
//                .assertionsYouHAveSelected("Impressive");// TODO, вероятно нужно извлекать элемент .text
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void radioBtnDisablesNoTest() {//TODO, пункт 4 моего файла
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .radioButtonClick()
//                .radioButtonNoHover()
//                .assertionsDisabled();
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void webTablesAssertionCountTablesColumnAndIntRowsDropWindowsTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .webTables()
//                .assertionsCountColumnInTablesOnIntRowsDropWindows(indexCollectionRowsDefault);
//    }
//
////    @Test
////    @Tag("ELEMENTS")
////    public void webTablesClickTest() {
////        Selenide.open("/");
////        MainThreadQa mainThreadQa = new MainThreadQa();
////        mainThreadQa.enterElementsClick()
////                .webTables()
////                .createClickAddBtn()
////                .setValueInputFirstName(firstName)
////                .setValueInputLastName(fullName)
////                .setValueInputEmail(email)
////                .setValueInputAge(age)
////                .setValueSalary(salary)
////                .setValueDepartment(departament)
////                .clickSubmit()
////                .inputSearch(email)
////                .assertionDefaultClickDropDownWindowsCountRows(intIndex20Rows)
////                .assertionsCountColumnInTablesOnIntRowsDropWindows(intIndex20Rows)
////                .assertionInSearch(firstName)
////                .assertionInSearch(fullName)
////                .assertionInSearch(email)
////                .assertionInSearch(age)//TODO, Возможно, что этот метод проверки стоит завязать на том, что необходимо искать не по тексту, а по числам, но не смог сделать
////                .assertionInSearch(salary);
////    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void buttonsDoubleClickTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .buttonsClick()
//                .doubleClickMeMethods()
//                .assertClick("double");// TODO Как то извлечь одно слово?
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void buttonsRightClickTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .buttonsClick()
//                .rightClickMeBMethods()
//                .assertClick("right");
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void buttonsClickMeTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .buttonsClick()
//                .clickMeMethods()
//                .assertClick("dynamic");
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void linksNewWindowsTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .linksClick()
//                .enterNewWindows()
//                .assertionsCountWindows2(Links.class);
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void linksSwitchWindowsTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .linksClick()
//                .enterNewWindows()
//                .switchTwoWindows();
//        Links links = new Links();
//        links.assertionsCountWindows2(Links.class);
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void brokenLinksImagesValidLinkEnterTest() {
//        BrokenLinksImages brokenLinksImages = new BrokenLinksImages();
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .brokenLinksImagesClick()
//                .validLinkEnter(brokenLinksImages.getValidlinkBtn())
//                .assertionsNewLink()
//                .assertionsNewLinkH1Google()
//                .assertionUrl("https://www.google.com");
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void brokenLinksImagesInvalidLinkEnterTest() {
//        BrokenLinksImages brokenLinksImages = new BrokenLinksImages();
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .brokenLinksImagesClick()
//                .validLinkEnter(brokenLinksImages.getInvalidLink())
//                .assertionsNewLink();
//        // TODO здесь проверку чрз rest-assure лучше сделать на статус код 500?
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void downloadFileTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .uploadAndDownloadClick()
//                .downloadFile();
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void uploadFileTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .uploadAndDownloadClick()
//                .uploadFile();
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void dynamicPropertiesTestNotEnabledElementsTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .dynamicPropertiesClick()
//                .elementsNoEnabled4seconds();
//    }
//
//    @Test
//    @Tag("ELEMENTS")
//    public void dynamicPropertiesTestEnabledElementsTest() {
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterElementsClick()
//                .dynamicPropertiesClick()
//                .elementsEnabled5seconds();
//    }
//
//    @Test
//    public void practiceFormClikTest() {
//        PracticeForm practiceForm = new PracticeForm();
//        Selenide.open("/");
//        MainThreadQa mainThreadQa = new MainThreadQa();
//        mainThreadQa.enterPracticeFormClick()
//                .practiceFormBtnEnterClick()
//                .inputFirstName(firstName)
//                .inputLastName(lastName)
//                .inputEmail(email)
//                .clickRadioBtnBranch(practiceForm.getOtherRadioBtn())
//                .inputMobileNumber(numbersMobile)
//                .inputDateClick(strDate);
//
//    }
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
//}
