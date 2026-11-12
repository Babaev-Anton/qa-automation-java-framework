package com.qa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить конфигурацию", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static String getBaseUrl() {
        return get("baseUrl");
    }

    public static int getTimeout() {
        return getInt ("timeout");
    }
    public static String getApiBaseUrl() {
        return get("apiBaseUrl");
    }
}