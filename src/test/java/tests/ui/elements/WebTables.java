package tests.ui.elements;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WebTables {
    SelenideElement addBtn = $x("//button[@id='addNewRecordButton']");
    //Registation Form
    SelenideElement inputFirstName = $x("//input[@placeholder='First Name']");
    SelenideElement inputLastName = $x("//input[@placeholder='Last Name']");
    SelenideElement inputEmail = $x("//input[@placeholder='name@example.com']");
    SelenideElement inputAge = $x("//input[@placeholder='Age']");
    SelenideElement inputSalary = $x("//input[@placeholder='Salary']");
    SelenideElement inputDepartment = $x("//input[@placeholder='Department']");
    SelenideElement submitClickBtn = $x("//button[@id='submit']");

    public WebTables createClickAddBtn(){
        addBtn.should(Condition.visible).click();
        return this;
    }
    public WebTables setValueInputFirstName(String firstName){
        inputFirstName.should(Condition.visible).setValue(firstName);
        return this;
    }

    public WebTables setValueInputLastName(String lastName){
        inputLastName.should(Condition.visible).setValue(lastName);
        return this;
    }

    public WebTables setValueInputEmail(String email){
        inputEmail.should(Condition.visible).setValue(email);
        return this;
    }
    public WebTables setValueInputAge(Integer age){
        String ageString = age.toString();
        inputAge.should(Condition.visible).setValue(ageString);
        return this;
    }

    public WebTables setValueSalary(Integer salary){
        String salaryString = salary.toString();
        inputSalary.should(Condition.visible).setValue(salaryString);
        return this;
    }
    public WebTables setValueDepartment(String department){
        inputDepartment.should(Condition.visible).setValue(department);
        return this;
    }
    public WebTables clickSubmit(){
        submitClickBtn.should(Condition.visible).click();
        return this;
    }




}
