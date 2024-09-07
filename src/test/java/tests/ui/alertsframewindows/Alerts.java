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
    SelenideElement clickBtnConfirmAppear = $x("//button[@id='confirmButton']");
    SelenideElement clickBtnpromptStringReturn = $x("//button[@id='promtButton']");


    public Alerts clickBtnSee(){
        clickBtnSee.should(Condition.enabled).click();
        return this;
    }

    public Alerts assertAlertText(String text){
        switchTo().alert(Duration.ofSeconds(10)).getText().contentEquals(text);
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

    public Alerts clickBtnConfirmAppear(){
        clickBtnConfirmAppear.should(Condition.enabled).click();
        return this;
    }

    public Alerts dismissAlert(){
        switchTo().alert(Duration.ofSeconds(10)).dismiss();
        return this;
    }

    public Alerts sendKeysAlert(String str){
        switchTo().alert(Duration.ofSeconds(10)).sendKeys(str);
        return this;
    }

    public Alerts clickBtnAlertPrompt(){
        clickBtnpromptStringReturn.should(Condition.enabled).click();
        return this;
    }
}
