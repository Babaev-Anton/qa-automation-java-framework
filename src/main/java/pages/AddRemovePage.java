package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AddRemovePage {
    private SelenideElement addElementButton = $("button");
    private ElementsCollection deleteElementButton = $$(".added-manually");


    public AddRemovePage openPage(){
        open("/add_remove_elements/");
        return this;
    }

    public AddRemovePage addElement(){
        addElementButton.click();
        return this;
    }

    public AddRemovePage deleteElement(int index){
        deleteElementButton.get(index).click();
        return this;
    }
    public int getDeleteButtonCount(){
        return deleteElementButton.size();
    }
}
