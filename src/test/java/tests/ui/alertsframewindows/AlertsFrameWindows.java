package tests.ui.alertsframewindows;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AlertsFrameWindows {
    ElementsCollection listDropDownCount5 = $$x("//div[@class='element-list collapse show']/ul/li");

    SelenideElement browserWindowsBtn = $x("//li[@class='btn btn-light ']//span[@class='text'][text()='Browser Windows']");

    public AlertsFrameWindows assertionsListCount5(){
        listDropDownCount5.should(CollectionCondition.size(5));
        return this;
    }
    public BrowserWindows enterBrowsers(){
        browserWindowsBtn.should(Condition.visible).click();
        return page(BrowserWindows.class);
    }
}
