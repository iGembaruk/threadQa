package tests.ui;

import com.codeborne.selenide.*;
import tests.ui.alertsframewindows.AlertsFrameWindows;
import tests.ui.elements.ElementsMain;
import tests.ui.forms.PracticeForm;

import static com.codeborne.selenide.Selenide.*;

public class MainThreadQa {
    SelenideElement header = $x("//a");
    ElementsCollection list6BtnMainElements = $$x("//div[@class='card mt-4 top-card']");

    SelenideElement elementsBtn = $x("//div[@class='card-body']/h5[text()='Elements']");
    SelenideElement formsBtn = $x("//div[@class='card-body']/h5[text()='Forms']");
    SelenideElement alertsFrameWindowsBtn = $x("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");
    SelenideElement widgetsBtn = $x("//div[@class='card-body']/h5[text()='Widgets']");
    SelenideElement interactionsBtn = $x("//div[@class='card-body']/h5[text()='Interactions']");
    SelenideElement gamestoreapplicationBtn = $x("//div[@class='card-body']/h5[text()='Game Store Application']");
    SelenideElement threadQaAutorBtn = $x("//a[text()='ThreadQa']");

    public MainThreadQa assertHeaderVisible(){
        header.should(Condition.visible);
        return this;
    }
    public MainThreadQa assertCountBtnsMainPage(int countBtn){
        list6BtnMainElements.should(CollectionCondition.size(countBtn));
        return this;
    }

    public ElementsMain enterElements(){
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
