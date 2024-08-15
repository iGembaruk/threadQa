package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicProperties {
    SelenideElement willEnabled5SecondsBtn = $x("//button[@id='enableAfter']");
    SelenideElement colorChangeBtn = $x("//button[@id='colorChange']");

    public DynamicProperties elementsNoEnabled4seconds(){
        willEnabled5SecondsBtn.should(Condition.not(Condition.enabled),Duration.ofSeconds(4));
        return this;
    }

    public DynamicProperties elementsEnabled5seconds(){
        willEnabled5SecondsBtn.should(Condition.enabled,Duration.ofSeconds(6));
        return this;
    }
}
