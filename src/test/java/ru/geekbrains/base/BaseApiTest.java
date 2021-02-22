package ru.geekbrains.base;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.geekbrains.utils.PropertiesUtils;
import ru.geekbrains.utils.TestEndpoints;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;
import static java.lang.Boolean.FALSE;
import static org.hamcrest.Matchers.containsString;

public abstract class BaseApiTest {

    protected static Map<String, String> headers = new HashMap<>();
    protected static Properties properties = new Properties();
    protected static String token;
    protected static String username;
    public static String hashImage;
    public static Boolean imageloadingFlag;
    protected static String baseImageHash;
    protected static String baseImage;
    public static ResponseSpecification responseSpecGet = null;
    public static ResponseSpecification responseSpecPostPositive = null;
    public static ResponseSpecification responseSpecPostNegative = null;
    public static RequestSpecification requestSpecGet = null;
    public static RequestSpecification requestSpecPost = null;

    @BeforeAll
    @Step("BeforeAll")
    static void beforeAll() {
        readPropertiesFromFile();
        username = properties.getProperty("username");
        token = properties.getProperty("token");
        RestAssured.baseURI = properties.getProperty("base.url");
        RestAssured.filters(new AllureRestAssured());
        baseImageHash = properties.getProperty("baseImageHash");
        baseImage = properties.getProperty("baseImage");
        imageloadingFlag = FALSE;
        responseSpecGet = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectResponseTime(Matchers.lessThan(3000L))
                .expectBody(containsString("success\":true"))
                .build();
        responseSpecPostPositive = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectResponseTime(Matchers.lessThan(20000L))
                .expectBody(containsString("success\":true"))
                .build();
        responseSpecPostNegative = new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectResponseTime(Matchers.lessThan(9000L))
                .expectBody(containsString("success\":false"))
                .expectBody(containsString("error"))
                .build();
        requestSpecGet = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .build();
        requestSpecPost = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .build();
    }

    @AfterEach
    @Step("deleting the image after the image load test")
    void tearDown() {
        if (imageloadingFlag) {
            given()
                    .log()
                    .uri()
                    .log()
                    .method()
                    .spec(requestSpecGet)
                    .when()
                    .delete(TestEndpoints.DELETE_IMAGE, hashImage)
                    .then()
                    .spec(responseSpecGet);
            imageloadingFlag = FALSE;
        }
    }

    private static void readPropertiesFromFile() {
        try {
            properties.load(new FileInputStream(PropertiesUtils.FILE_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}