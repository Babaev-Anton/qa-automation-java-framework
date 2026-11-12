package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SecureAreaPageV3 {
    SelenideElement successFlashMessage = $("#flash");
    SelenideElement logoutButton = $("a[href = '/logout']");

    public SecureAreaPageV3 getFlashMessage(){
        successFlashMessage.shouldHave(text("You logged into a secure area!"));
        return this;
    }

    public LoginPageV3 logoutButtonClick(){
        logoutButton.click();
        return new LoginPageV3();
    }

    public boolean isLogoutButtonDisplayed(){
        return logoutButton.isDisplayed();
    }
}
