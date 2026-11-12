package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement usernameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement loginButton = $("button[type='submit']");

    public LoginPage openPage(){
        open("/login");
        return this;
    }

    public LoginPage setUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public SecureAreaPage clickLogin(){
        loginButton.click();
        return new SecureAreaPage();
    }

    public SecureAreaPage login(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLogin();
    }

    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }
}

