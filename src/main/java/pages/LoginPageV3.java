package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageV3 {

    private SelenideElement usernameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement loginButton = $("button[type = 'submit']");

    public LoginPageV3 openPage(){
        open("/login");
        return this;
    }

    public LoginPageV3 setUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPageV3 setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public SecureAreaPageV3 loginButtonClick(){
        loginButton.click();
        return new SecureAreaPageV3();
    }

    public SecureAreaPageV3 login(String username, String password){
        setUsername(username);
        setPassword(password);
        return loginButtonClick();
    }

    public boolean isLoginPageOpenAgain(){
        return usernameField.isDisplayed();
    }
}
