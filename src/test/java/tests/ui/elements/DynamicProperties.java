package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicProperties {
    SelenideElement willEnabled5SecondsBtn = $x("//button[@id='enableAfter']");
    SelenideElement colorChangeBtn = $x("//button[@id='colorChange']");
    SelenideElement visibleAfter5Seconds = $x("//button[@id='visibleAfter']");

    public DynamicProperties elementsNoEnabled4seconds(){
        willEnabled5SecondsBtn.should(Condition.not(Condition.enabled),Duration.ofSeconds(4));
        return this;
    }

    public DynamicProperties elementsEnabled5seconds(){
        willEnabled5SecondsBtn.should(Condition.enabled,Duration.ofSeconds(6));
        return this;
    }

    public DynamicProperties elementVisibleAfter5Seconds(){
        visibleAfter5Seconds.should(Condition.visible, Duration.ofSeconds(2));//Почему данный тест проходит, элемент появляется позже. + установлено Configuration.timeout = 2000;
        return this;
    }
}
