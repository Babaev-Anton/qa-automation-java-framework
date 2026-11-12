package com.qa.config;

public class DriverManager {
    private static DriverManager instance;

    private DriverManager() {}

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public String getBrowser() {
        return ConfigManager.getBrowser();
    }
}
