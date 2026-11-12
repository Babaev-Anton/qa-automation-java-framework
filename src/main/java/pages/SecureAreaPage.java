package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class SecureAreaPage {
    private SelenideElement flashMessage = $("#flash");
    private SelenideElement logoutButton = $("a[href='/logout']");

    public SecureAreaPage checkLoginSuccess(){
        flashMessage.shouldHave(text("You logged into a secure area!"));
        return this;
    }

    public LoginPage clickLogout(){
        logoutButton.click();
        return new LoginPage();
    }

    public boolean isLogoutButtonDisplayed(){
        return logoutButton.isDisplayed();
    }

}
