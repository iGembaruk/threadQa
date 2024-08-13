package tests.ui.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
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
    //взаимодействие со страницей
    SelenideElement inputSearch = $x("//input[@placeholder='Type to search']");
    ElementsCollection listStringTablesCount = $$x("//div[@class='rt-tbody']/div");

    SelenideElement clickCountRowsBtn = $x("//select[@aria-label='rows per page']");
    ElementsCollection dropDownList = $$x("//select[@aria-label='rows per page']//option");
    ElementsCollection searchResultCollection = $$x("//div[@class='rt-td'][1]");

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

    public WebTables inputSearch(String strSearch){
        inputSearch.should(Condition.visible).setValue(strSearch);
        return this;
    }

    public WebTables assertionDefaultClickDropDownWindowsCountRows(int i){
        clickCountRowsBtn.click();
        dropDownList.should(CollectionCondition.size(6)).get(i).click();
        return this;
    }
    public WebTables assertionsCountColumnInTablesOnIntRowsDropWindows(int index){
        String tempStrDropDownIndex2 = dropDownList.get(index).text();
        String[] countStringArray = tempStrDropDownIndex2.split("\\D+");
        int count = Integer.parseInt(countStringArray[0]);
        listStringTablesCount.should(CollectionCondition.size(count));
    return this;
    }
    public WebTables assertionStringIsSearch(String searchElement){
        searchResultCollection.find(Condition.partialText(searchElement));
        return this;
    }

    public WebTables assertionIntegerIsSearch(Integer searchElement){
        String searchElementString = searchElement.toString();
        searchResultCollection.find(Condition.partialText(searchElementString));
        return this;
    }









}
