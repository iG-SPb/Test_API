package ru.geekbrains;

import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AccountTests extends BaseTest {

    @Test
    void getAccountInfoTest() {
        given()
                .headers("Authorization", token)
                .when()
                .get("/account/{username}", username)
                .then()
                .statusCode(200);
    }

    @Test
    void getAccountInfoWithLoggingTest() {
        given()
                .headers(headers)
                .log()
                .all()
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void getAccountInfoWithoutToken() {
                when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(401);
    }

    @Test
    void getAccountInfoVerifyUrlTest() {
        String url = given()
                .headers(headers)
                .log()
                .uri()
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .log()
                .status()
                .extract()
                .response()
                .jsonPath()
                .getString("data.url");
        assertThat(url, equalTo("testprogmath"));
    }

    @Test
    void getAccountInfoVerifyUrlInGivenPartTest() {
        given()
                .headers(headers)
                .log()
                .uri()
                .expect()
                .body("success", is(true))
                .body("data.url", is("testprogmath"))
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .log()
                .status();
    }
}
