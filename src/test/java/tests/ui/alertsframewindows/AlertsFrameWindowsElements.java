package tests.ui.alertsframewindows;

import com.codeborne.selenide.*;
import tests.ui.forms.PracticeForm;

import static com.codeborne.selenide.Selenide.*;

public class AlertsFrameWindowsElements {
    ElementsCollection listDropDownCount5 = $$x("//div[@class='element-list collapse show']/ul/li");

    SelenideElement browserWindowsBtn = $x("//li[@class='btn btn-light ']//span[@class='text'][text()='Browser Windows']");
    SelenideElement alertsBtn = $x("//span[@class='text'][text()='Alerts']");

    public AlertsFrameWindowsElements assertionsListQuantityt5(){
        listDropDownCount5.should(CollectionCondition.size(5));
        return this;
    }
    public BrowserWindows enterBrowserWindows(){
        browserWindowsBtn.should(Condition.enabled).click();
        return page(BrowserWindows.class);
    }

    public Alerts enterAlerts(){
        alertsBtn.should(Condition.enabled).click();
        return page(Alerts.class);
    }
}
