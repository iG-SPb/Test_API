package ru.geekbrains.get;

import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseGetTest;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class getAccountTest extends BaseGetTest {

    @Test
    void getAccountInfoPositiveTest() {
        given()
                .log()
                .uri()
                .baseUri(baseURI)
                .headers("Authorization", token)
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .body("data.id", equalTo(145270851))
                .when()
                .get("account/{id}", username)
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.id");
    }
}
