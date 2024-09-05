package tests.ui.alertsframewindows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class BrowserWindows {
    SelenideElement newTabBtn = $x("//button[@class='btn btn-primary'][text()='New Tab']");

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
    public BrowserWindows assertionsToWindowsText(String str){
        $x("//h1").should(Condition.visible).text().equals(str);
        return this;
    }

}
