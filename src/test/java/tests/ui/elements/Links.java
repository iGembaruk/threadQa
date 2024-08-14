package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import tests.ui.MainWebSiteTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class Links {
    SelenideElement linkHomeBtn = $x("//a[@id='simpleLink']");

    public Links enterNewWindows(){
        linkHomeBtn.should(Condition.visible).click();
        return this;
    }

    public Set<String> windowsDriver(){
        Set<String> handles = WebDriverRunner.getWebDriver().getWindowHandles();
        return handles;
    }

    public <T> T assertionsCountWindows2(T classes){
        Assertions.assertEquals(2, windowsDriver().size());
        return classes;
    }

    public MainWebSiteTest switchTwoWindows(){
        Iterator<String> iterator = windowsDriver().iterator();
        iterator.next();
        String secondWindowHandle = iterator.next();
        WebDriverRunner.getWebDriver().switchTo().window(secondWindowHandle);
        return page(MainWebSiteTest.class);
    }
}
