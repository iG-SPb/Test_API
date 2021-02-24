package ru.geekbrains.delImg;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseApiTest;
import ru.geekbrains.utils.TestEndpoints;
import static io.restassured.RestAssured.given;

public class delImageTest extends BaseApiTest {

    static Faker faker = new Faker();

    @Test
    @Step("test Delete negative with authorization")
    void deleteImageNegativeWithAuthTest() {
        String tmpHash = faker.code().isbnRegistrant();
        given()
                .log()
                .uri()
                .log()
                .method()
                .spec(requestSpecGet)
                .when()
                .delete(TestEndpoints.DELETE_IMAGE, tmpHash)
                .then()
                .spec(responseSpecDeleteNegative);
    }

    @Test
    @Step("test Delete negative without authorization")
    void deleteImageNegativeWithOutAuthTest() {
        String tmpHash = faker.code().isbnRegistrant();
        given()
                .log()
                .uri()
                .log()
                .method()
                .when()
                .delete(TestEndpoints.DELETE_IMAGE, tmpHash)
                .then()
                .spec(responseSpecDeleteNegative);
    }
}
