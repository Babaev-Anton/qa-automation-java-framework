package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropdownPage {

    public DropdownPage openPage() {
        open("/dropdown");
        return this;
    }

    public DropdownPage selectOption(String optionText) {
        $("select").selectOption(optionText);
        return this;
    }

    public String getSelectedOption() {
        return $("select").getSelectedOption().getText();
    }
}