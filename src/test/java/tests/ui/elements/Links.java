package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import tests.ui.MainThreadQa;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class Links {
    SelenideElement linkHomeBtn = $x("//a[@id='simpleLink']");

    public Links enterNewWindowsHome(){
        linkHomeBtn.should(Condition.visible).click();
        return this;
    }

    public Set<String> windowsDriver(){
        Set<String> handles = WebDriverRunner.getWebDriver().getWindowHandles();
        return handles;
    }

    public Links assertCountWindows2(){
        Assertions.assertEquals(2, windowsDriver().size());
        return this;
    }

    public MainThreadQa switchTwoWindows(){
        Iterator<String> iterator = windowsDriver().iterator();
        iterator.next();
        String secondWindowHandle = iterator.next();
        WebDriverRunner.getWebDriver().switchTo().window(secondWindowHandle);
        return page(MainThreadQa.class);
    }
}
