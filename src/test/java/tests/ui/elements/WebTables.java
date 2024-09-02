package tests.ui.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WebTables {
    SelenideElement addBtn = $x("//button[@id='addNewRecordButton']");
    //Registration Form
    SelenideElement inputFirstName = $x("//input[@placeholder='First Name']");
    SelenideElement inputLastName = $x("//input[@placeholder='Last Name']");
    SelenideElement inputEmail = $x("//input[@placeholder='name@example.com']");
    SelenideElement inputAge = $x("//input[@placeholder='Age']");
    SelenideElement inputSalary = $x("//input[@placeholder='Salary']");
    SelenideElement inputDepartment = $x("//input[@placeholder='Department']");
    SelenideElement submitClickBtn = $x("//button[@id='submit']");
    //взаимодействие со страницей
    SelenideElement inputSearch = $x("//input[@placeholder='Type to search']");
    ElementsCollection listUsers = $$x("//div[@class='rt-tbody']/div");

    ElementsCollection selectIsList6Rows = $$x("//select[@aria-label='rows per page']//option");
    ElementsCollection resultSearchOneColumnTablesCollection = $$x("//div[@class='rt-td'][1]");

    SelenideElement webTablesHeader = $x("//div[@class='pattern-backgound playgound-header']");
    SelenideElement selectFirstName = $x("//div[text()='First Name']");

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
    public WebTables setValueInputAge(String age){
        inputAge.should(Condition.visible).setValue(age);
        return this;
    }

    public WebTables setValueSalary(String salary){
        inputSalary.should(Condition.visible).setValue(salary);
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

    public WebTables setInputSearch(String strSearch){
        inputSearch.should(Condition.visible).setValue(strSearch);
        return this;
    }

    public WebTables assertHeaderPartialText(String assertExpectedStr){
        webTablesHeader.should(Condition.partialText(assertExpectedStr));
        return this;
    }

//    public WebTables assertDropDownCountRows(int i){
//        clickCountRowsBtn.click();
//        selectCountRows.should(CollectionCondition.size(6)).get(i).click();
//        return this;
//    }
    public WebTables assertQuantityColumnEqualsQuantitySelectRows(int index){
        String stringDropDownQuantityRows = selectIsList6Rows.get(index).text();
        String[] countStringArray = stringDropDownQuantityRows.split("\\D+");
        int quantity = Integer.parseInt(countStringArray[0]);
        resultSearchOneColumnTablesCollection.should(CollectionCondition.size(quantity));
    return this;
    }

    public WebTables assertInSearch(String searchElement){
        resultSearchOneColumnTablesCollection.find(Condition.partialText(searchElement));
        return this;
    }

    public WebTables assertInSearch(Integer searchElement){
        String searchElementString = searchElement.toString();
        resultSearchOneColumnTablesCollection.find(Condition.partialText(searchElementString));
        return this;
    }

    public WebTables clickFirstName(){
        selectFirstName.should(Condition.enabled).click();
        return this;
    }

    public List<String> newCollectionsAreColumnFirstName(){
        ElementsCollection list = $$x("//div[@class='rt-td'][1]");
        List<String> collectionsStringFirstName = list.texts();
        List<String> collectionFilterNoBlank = new ArrayList<>();
        int i = 0;
        while(!collectionsStringFirstName.get(i).isBlank()){
        collectionFilterNoBlank.add(collectionsStringFirstName.get(i));
        i++;
        }
        return collectionFilterNoBlank;
    }

    public List<String> newCollectionsAreColumnFirstNameStream(){
        ElementsCollection list = $$x("//div[@class='rt-td'][1]");
        List<String> collectionFilterNoBlankFirstName = list
                .texts()
                .stream()
                .filter(string -> !string.isBlank())
                .collect(Collectors.toList());
        return collectionFilterNoBlankFirstName;
    }

    public List<String> listSorted(List<String> list){
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }




}
