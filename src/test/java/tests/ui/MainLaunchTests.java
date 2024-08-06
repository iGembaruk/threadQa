package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MainLaunchTests {
    private String fullName = "Gembaruk Igor Vladimirovich";
    private String email = "i.gembaruk@mail.ru";
    private String address1 = "ul1 d.13";
    private String address2 = "ul2 d.23";



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
    public void inputTextBoxTest(){
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


}
