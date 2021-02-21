package ru.geekbrains.put;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BasePostTest;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class postImageTest extends BasePostTest {

    @Test
    @Step("test PUT-1")
    void putImagePositiveTest() {
        hashImage = given()
                .baseUri(baseURI)
                .headers("Authorization", token)
                .multiPart("image","R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7")
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .when()
                .post("image")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    @Step("test PUT-2")
    void putImagePositiveFileTest() {
        hashImage = given()
                .baseUri(baseURI)
                .headers("Authorization", token)
                .multiPart("image",new File(baseImage))
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .when()
                .post("image")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }
}
