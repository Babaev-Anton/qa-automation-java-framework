package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EntryAdPage {
    private SelenideElement modalWindow = $("#modal");
    private SelenideElement closeButton = $(".modal-footer p");
    private SelenideElement modalWindowHeader = $(".modal-title h3");
    private SelenideElement modalWindowBodyText = $(".modal-body p");

    public EntryAdPage openPage(){
        open("/entry_ad");
        return this;
    }

    public EntryAdPage closeModalWindow(){
        closeButton.click();
        modalWindow.shouldNotBe(visible);
        return this;
    }

    public String getModalWindowHeadertext(){
        modalWindow.shouldBe(visible);
        return modalWindowHeader.getText();
    }

    public String getModelWindowBodyText(){
        modalWindow.shouldBe(visible);
        return modalWindowBodyText.getText();
    }

}
