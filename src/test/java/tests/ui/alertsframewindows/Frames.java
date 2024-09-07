package tests.ui.alertsframewindows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Frames {

    SelenideElement iframe1 = $x("//iframe[@id='frame1']");
    SelenideElement frameText = $x("//body[@style='background-color:#a9a9a9']");

    public Frames enterParentFrame(){
        switchTo().frame(iframe1);
        return this;
    }
}
