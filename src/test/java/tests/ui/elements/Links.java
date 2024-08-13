package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;

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

    public Links assertionsCountWindows2(){
        Assertions.assertEquals(2, windowsDriver().size());
        return this;
    }
}
