package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tests.ui.alertsframewindows.AlertsFrameWindows;
import tests.ui.elements.ElementsMain;
import tests.ui.forms.PracticeForm;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainWebSiteTest  {
    SelenideElement header = $x("//a");

    SelenideElement elementsBtn = $x("//div[@class='card-body']/h5[text()='Elements']");
    SelenideElement formsBtn = $x("//div[@class='card-body']/h5[text()='Forms']");
    SelenideElement alertsFrameWindowsBtn = $x("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");
    SelenideElement widgetsBtn = $x("//div[@class='card-body']/h5[text()='Widgets']");
    SelenideElement interactionsBtn = $x("//div[@class='card-body']/h5[text()='Interactions']");
    SelenideElement gamestoreapplicationBtn = $x("//div[@class='card-body']/h5[text()='Game Store Application']");
    SelenideElement threadQaAutorBtn = $x("//a[text()='ThreadQa']");

    public ElementsMain enterElementsClick(){
        header.should(Condition.visible);
        elementsBtn.click();
        return Selenide.page(ElementsMain.class);
    }

    public PracticeForm enterPracticeFormClick(){
        formsBtn.should(Condition.visible).click();
        return Selenide.page(PracticeForm.class);
    }

    public AlertsFrameWindows enterListAlertsFrameWindows(){
        alertsFrameWindowsBtn.should(Condition.visible).click();
        return Selenide.page(AlertsFrameWindows.class);
    }

}
