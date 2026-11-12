package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;

import javax.xml.crypto.Data;

public class DataTablesPage {
    private SelenideElement dueHeader = $("table#table1 th:nth-child(4)");
    private ElementsCollection firstTableRows = $$("table#table1 tbody tr");
    private ElementsCollection secondTableRows = $$("table#table2 tbody tr");
    private SelenideElement emailHeader = $("table#table2 th:nth-child(3)");
    private SelenideElement lastNameHeader = $("table#table2 th:nth-child(1)");
    private ElementsCollection headers = $$("table#table2 th");

    public DataTablesPage openPage(){
        open("/tables");
        return this;
    }

    public String getEmailByFirstName(String firstName){
        return firstTableRows
                .findBy(text(firstName))
                .findAll("td").get(2)
                .getText();
    }

    public String getDueByLastName(String lastName){
        return firstTableRows
                .findBy(text(lastName))
                .findAll("td").get(3)
                .getText();

    }

    public DataTablesPage sortedByDue(){
        dueHeader.click();
        return this;
    }

    public String getFirstRowDue(){
        return firstTableRows.get(0).findAll("td").get(3).getText();
    }

    public String getLastRowDue(){
        return firstTableRows.get(firstTableRows.size() - 1).findAll("td").get(3).getText();
    }

    public String getWebSiteByLastName(String lastName){
        return secondTableRows
                .findBy(text(lastName))
                .findAll("td").get(4)
                .getText();
    }

    public String getDueByFirstName(String firstname){
        return secondTableRows
                .findBy(text(firstname))
                .findAll("td").get(3)
                .getText();
    }

    public int getRowCount(){
        return secondTableRows.size();
    }

    public DataTablesPage sortedByEmail(){
        emailHeader.click();
        return this;
    }

    public DataTablesPage sortedByLastName(){
        lastNameHeader.click();
        sleep(5000);
        return this;
    }

    public String getFirstRowLastName(){
        return secondTableRows.get(0).findAll("td").get(0).getText();
    }

    public String getLastRowLastName(){
        return secondTableRows.get(secondTableRows.size() - 1).findAll("td").get(0).getText();
    }

    public int getHeadersCount(){
        return headers.size();
    }

    public String getHeaderText(int index){
        return headers.get(index).getText();
    }

    public boolean rowsHasButtonEdit(int rowIndex){
        return secondTableRows.get(rowIndex).find("a[href*='edit']").exists();
    }
    public boolean rowsHasButtonDelete(int rowIndex){
        return secondTableRows.get(rowIndex).find("a[href*='delete']").exists();
    }
}
