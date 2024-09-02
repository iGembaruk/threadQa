package tests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class UploadAndDownload {
    SelenideElement downloadBtn = $x("//a[text()='Download']");
    SelenideElement uploadBtn = $x("//input[@id='uploadFile']");
    SelenideElement assertionsUploadElement = $x("//p[@id='uploadedFilePath']");


    public UploadAndDownload downloadFile(String nameFile) {
        File file = downloadBtn.should(Condition.visible).download();
        Assertions.assertTrue(file.getName().equals(nameFile));
        return this;
    }

    public UploadAndDownload uploadFile(String path) {
        File fileToUpload = new File(path);
        uploadBtn.uploadFile(fileToUpload);
        assertionsUploadElement.shouldHave(Condition.partialText("ArcheAge_sample.jpg"));
        return this;
    }
}
