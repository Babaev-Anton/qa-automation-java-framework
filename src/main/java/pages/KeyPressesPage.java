package pages;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class KeyPressesPage {

    public KeyPressesPage openPage(){
        open("/key_presses");
        return this;
    }

    public KeyPressesPage pressKey(String key){
        $("#target").click();
        switch (key){
            case "TAB":
                $("#target").pressTab();
                break;
            case "ESCAPE":
                $("#target").pressEscape();
                break;
            default:
                $("#target").sendKeys(key);
                break;
        }
        return this;
    }

    public String getResultText() {
        return $("#result").getText();
    }
}
