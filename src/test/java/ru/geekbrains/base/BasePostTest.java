package ru.geekbrains.base;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public abstract class BasePostTest {
    protected static Map<String, String> headers = new HashMap<>();
    protected static Properties properties = new Properties();
    protected static String token;
    protected static String username;
    public static String hashImage;
    protected static String baseImageHash;
    protected static String baseImage;

    @BeforeAll
    @Step("test PUT before")
    static void beforeAll() {
        readPropertiesFromFile();
        username = properties.getProperty("username");
        token = properties.getProperty("token");
        RestAssured.baseURI = properties.getProperty("base.url");
        RestAssured.filters(new AllureRestAssured());
        baseImageHash = properties.getProperty("baseImageHash");
        baseImage = properties.getProperty("baseImage");
    }

    @AfterEach
    @Step("test PUT after")
    void tearDown() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("image/{deleteHash}", hashImage)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    private static void readPropertiesFromFile() {
        try {
            properties.load(new FileInputStream("src/test/resources/test_api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}