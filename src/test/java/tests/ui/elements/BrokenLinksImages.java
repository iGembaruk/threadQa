package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;


import static com.codeborne.selenide.Selenide.$x;

public class BrokenLinksImages {
    SelenideElement validlinkBtn = $x("//a[@href='https://www.google.com/']");
    SelenideElement urlDefault = $x("//a[@href='http://85.192.34.140:8081']");
    SelenideElement newUrlGoogle = $x("//img[@alt='Google']");

    SelenideElement invalidLink = $x("//a[@href='http://the-internet.herokuapp.com/status_codes/500']");

    public BrokenLinksImages validLinkEnter(){
        validlinkBtn.should(Condition.enabled).click();
        return this;
    }

    public BrokenLinksImages assertionsNewLink(){
        urlDefault.should(Condition.not(Condition.exist));
        return this;
    }

    public BrokenLinksImages assertionsNewLinkH1Google(){
        newUrlGoogle.should(Condition.visible);
        return this;
    }

    public String getActualUrl(){
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        return actualUrl;
    }

    public BrokenLinksImages assertionUrl(String str){
        getActualUrl().equals(str);
        return this;
    }
}
