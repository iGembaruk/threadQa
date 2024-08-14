package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UploadAndDownload {
    SelenideElement downloadBtn = $x("//a[text()='Download']");

public UploadAndDownload downloadFile(){

    return this;
}

}
