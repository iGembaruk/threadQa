package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.FileNotDownloadedError;
import org.junit.jupiter.api.*;
import tests.ui.elements.BrokenLinksImages;
import tests.ui.elements.CheckBox;
import tests.ui.elements.Links;
import tests.ui.forms.PracticeForm;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MainLaunchTests {
    private String fullName = "Gembaruk Igor";
    private String firstName = "Oki";
    private String lastName = "blabla";
    private String email = "i.gembaruk@mail.ru";
    private String address1 = "ul1 d.13";
    private Integer age = 27;
    private Integer salary = 100000;
    private String numbersMobile = "9656363968";
    private String strDate = "01 Aug 2025";
    private String address2 = "ul2 d.23";
    private String departament = "Penza";
    private int indexCollectionRowsDefault = 1;
    private int intIndex20Rows = 2;
    CheckBox checkBox = new CheckBox();
    List<SelenideElement> elements = new ArrayList<>();
    private MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();

    @BeforeEach
    public void openPage(){
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
    @Tag("DROPDOWN")
    public void dropDownWindowsElementsClickTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .dropDownWindows()
                .assertionsNovisibleElementsList();
    }

    @Test
    @Tag("ELEMENTS")
    public void clickElementsTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .dropDownWindows()
                .textBoxClick();
    }

    @Test
    @Tag("ELEMENTS")
    public void inputElementsTextBoxTest() {
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
    @Tag("ELEMENTS")
    public void clickElementsCheckBoxTest() {//TODO пункт1
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .checkBoxClick()
                .clickAllCheckListEnter()
                .assertionsCount6Elements()
                .clickAllCheckListClose()//TODO пункт 2
                .assertionsCount0Elements();
    }

    @Test//TODO, 3ий пункт. работает без проверки .assertsCheckBox(checkBoxesToClick)
    @Tag("ELEMENTS")
    public void clickElementsCheckBoxManySelenideElementsTest() {
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
    @Tag("ELEMENTS")
    public void radioBtnYesClickTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .radioButtonClick()
                .radioButtonYesClick()
                .assertionsYouHAveSelected("Yes");// TODO, вероятно нужно извлекать элемент .text
    }

    @Test
    @Tag("ELEMENTS")
    public void radioBtnImpressiveClickTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .radioButtonClick()
                .radioButtonImpressiveClick()
                .assertionsYouHAveSelected("Impressive");// TODO, вероятно нужно извлекать элемент .text
    }

    @Test
    @Tag("ELEMENTS")
    public void radioBtnDisablesNoTest() {//TODO, пункт 4 моего файла
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .radioButtonClick()
                .radioButtonNoHover()
                .assertionsDisabled();
    }

    @Test
    @Tag("ELEMENTS")
    public void webTablesAssertionCountTablesColumnAndIntRowsDropWindowsTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .webTables()
                .assertionsCountColumnInTablesOnIntRowsDropWindows(indexCollectionRowsDefault);
    }

//    @Test
//    @Tag("ELEMENTS")
//    public void webTablesClickTest() {
//        Selenide.open("/");
//        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
//        mainWebSiteTest.enterElementsClick()
//                .webTables()
//                .createClickAddBtn()
//                .setValueInputFirstName(firstName)
//                .setValueInputLastName(fullName)
//                .setValueInputEmail(email)
//                .setValueInputAge(age)
//                .setValueSalary(salary)
//                .setValueDepartment(departament)
//                .clickSubmit()
//                .inputSearch(email)
//                .assertionDefaultClickDropDownWindowsCountRows(intIndex20Rows)
//                .assertionsCountColumnInTablesOnIntRowsDropWindows(intIndex20Rows)
//                .assertionInSearch(firstName)
//                .assertionInSearch(fullName)
//                .assertionInSearch(email)
//                .assertionInSearch(age)//TODO, Возможно, что этот метод проверки стоит завязать на том, что необходимо искать не по тексту, а по числам, но не смог сделать
//                .assertionInSearch(salary);
//    }

    @Test
    @Tag("ELEMENTS")
    public void buttonsDoubleClickTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .buttonsClick()
                .doubleClickMeMethods()
                .assertClick("double");// TODO Как то извлечь одно слово?
    }

    @Test
    @Tag("ELEMENTS")
    public void buttonsRightClickTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .buttonsClick()
                .rightClickMeBMethods()
                .assertClick("right");
    }

    @Test
    @Tag("ELEMENTS")
    public void buttonsClickMeTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .buttonsClick()
                .clickMeMethods()
                .assertClick("dynamic");
    }

    @Test
    @Tag("ELEMENTS")
    public void linksNewWindowsTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .linksClick()
                .enterNewWindows()
                .assertionsCountWindows2(Links.class);
    }

    @Test
    @Tag("ELEMENTS")
    public void linksSwitchWindowsTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .linksClick()
                .enterNewWindows()
                .switchTwoWindows();
        Links links = new Links();
        links.assertionsCountWindows2(Links.class);
    }

    @Test
    @Tag("ELEMENTS")
    public void brokenLinksImagesValidLinkEnterTest() {
        BrokenLinksImages brokenLinksImages = new BrokenLinksImages();
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .brokenLinksImagesClick()
                .validLinkEnter(brokenLinksImages.getValidlinkBtn())
                .assertionsNewLink()
                .assertionsNewLinkH1Google()
                .assertionUrl("https://www.google.com");
    }

    @Test
    @Tag("ELEMENTS")
    public void brokenLinksImagesInvalidLinkEnterTest() {
        BrokenLinksImages brokenLinksImages = new BrokenLinksImages();
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .brokenLinksImagesClick()
                .validLinkEnter(brokenLinksImages.getInvalidLink())
                .assertionsNewLink();
        // TODO здесь проверку чрз rest-assure лучше сделать на статус код 500?
    }

    @Test
    @Tag("ELEMENTS")
    public void downloadFileTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .uploadAndDownloadClick()
                .downloadFile();
    }

    @Test
    @Tag("ELEMENTS")
    public void uploadFileTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .uploadAndDownloadClick()
                .uploadFile();
    }

    @Test
    @Tag("ELEMENTS")
    public void dynamicPropertiesTestNotEnabledElementsTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .dynamicPropertiesClick()
                .elementsNoEnabled4seconds();
    }

    @Test
    @Tag("ELEMENTS")
    public void dynamicPropertiesTestEnabledElementsTest() {
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterElementsClick()
                .dynamicPropertiesClick()
                .elementsEnabled5seconds();
    }

    @Test
    public void practiceFormClikTest() {
        PracticeForm practiceForm = new PracticeForm();
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterPracticeFormClick()
                .practiceFormBtnEnterClick()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputEmail(email)
                .clickRadioBtnBranch(practiceForm.getOtherRadioBtn())
                .inputMobileNumber(numbersMobile)
                .inputDateClick(strDate);

    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterListAlertsFrameWindowsCounts5Test() {
        PracticeForm practiceForm = new PracticeForm();
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterListAlertsFrameWindows()
                .assertionsListCount5();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterBrowserWindowsTest() {
        PracticeForm practiceForm = new PracticeForm();
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterListAlertsFrameWindows()
                .enterBrowsers()
                .newTabWindowsBrowserWindows()
                .assertionsCount2Windows();
    }

    @Test
    @Tag("ALERTSFRAMEWINDOWS")
    public void enterBrowserWindowsToSwitchTextTest() {
        PracticeForm practiceForm = new PracticeForm();
        Selenide.open("/");
        MainWebSiteTest mainWebSiteTest = new MainWebSiteTest();
        mainWebSiteTest.enterListAlertsFrameWindows()
                .enterBrowsers()
                .newTabWindowsBrowserWindows()
                .switchTwoWindows()
                .assertionsToWindowsText("Thread QA Sample");
    }
    @Test
    public void a() throws FileNotDownloadedError {
      String url = mainWebSiteTest.enterElementsClick()
               .brokenLinksImagesClick()
               .getInvalidUrl();
//      Selenide.open(url);
//      $x("//pre").should(Condition.text("Cannot GET /images/ThreadQa.jpg"));
        Assertions.assertThrows(FileNotDownloadedError.class,  () -> Selenide.download(url)) ;
    }

}
