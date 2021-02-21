package ru.geekbrains.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class BaseGetTest {
    protected static Map<String, String> headers = new HashMap<>();
    protected static Properties properties = new Properties();
    protected static String token;
    protected static String username;
    protected static String baseImage;

    @BeforeAll
    static void beforeAll() {
        readPropertiesFromFile();
        username = properties.getProperty("username");
        token = properties.getProperty("token");
        RestAssured.baseURI = properties.getProperty("base.url");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        baseImage = properties.getProperty("baseImage");
    }

    private static void readPropertiesFromFile() {
        try {
            properties.load(new FileInputStream("src/test/resources/test_api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
