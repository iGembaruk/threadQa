package tests.ui.alertsframewindows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class BrowserWindows {
    SelenideElement newTabBtn = $x("//button[@class='btn btn-primary'][text()='New Tab']");
    SelenideElement newWindowBtn = $x("//button[@id='windowButton']");
    SelenideElement newWindowMessageBtn = $x("//button[@id='messageWindowButton']");

    public BrowserWindows newTabClick(){
        newTabBtn.should(Condition.enabled).click();
      return this;
    }

    public Set<String> windowsDriver(){
        return WebDriverRunner.getWebDriver().getWindowHandles();
    }

    public BrowserWindows assertCount2Windows(){
        Assertions.assertEquals(2,windowsDriver().size());
        return this;
    }
    public BrowserWindows switchTwoWindows(){
        Iterator<String> iterator = windowsDriver().iterator();
        iterator.next();
        String secondWindowHandle = iterator.next();
        WebDriverRunner.getWebDriver().switchTo().window(secondWindowHandle);
        return this;
    }
    public BrowserWindows assertToWindowsH1Text(String str){
        $x("//h1").shouldHave(Condition.text(str));
        return this;
    }

    public BrowserWindows newWindowClick(){
        newWindowBtn.should(Condition.enabled).click();
        return this;
    }

    public BrowserWindows newWindowMessageClick(){
        newWindowMessageBtn.should(Condition.enabled).click();
        return this;
    }
}
