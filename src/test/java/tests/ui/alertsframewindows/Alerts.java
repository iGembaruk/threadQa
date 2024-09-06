package tests.ui.alertsframewindows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Alerts {
    SelenideElement clickBtnSee = $x("//button[@id='alertButton']");
    SelenideElement clickBtn5Seconds = $x("//button[@id='timerAlertButton']");


    public Alerts clickBtnSee(){
        clickBtnSee.should(Condition.enabled).click();
        return this;
    }

    public Alerts assertAlertText(String text){
        switchTo().alert().getText().contentEquals(text);
        return this;
    }

    public Alerts acceptAlert(){
        switchTo().alert().accept();
        return this;
    }
    public Alerts clickBtn5Seconds(){
        clickBtn5Seconds.should(Condition.enabled).click();
        return this;
    }
    public Alerts assertAlertTextWait(String text){
//        switchTo().alert(Duration.ofSeconds(7)).getText().contentEquals(text);
        switchTo().wait();
        return this;
    }
}
