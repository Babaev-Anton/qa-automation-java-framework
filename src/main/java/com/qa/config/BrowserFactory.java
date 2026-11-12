package com.qa.config;

import com.codeborne.selenide.Configuration;

public class BrowserFactory {

    public static void setupBrowser(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
            default:
                throw new IllegalArgumentException("Неизвестный браузер" + browser);
        }
    }
}
