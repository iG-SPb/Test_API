package ru.geekbrains.get;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseApiTest;
import ru.geekbrains.dto.GetResponseImage;
import ru.geekbrains.dto.GetResponseAccountBase;
import ru.geekbrains.dto.GetResponseAccountSettings;
import ru.geekbrains.dto.GetResponseCredit;
import ru.geekbrains.utils.TestEndpoints;

@Slf4j
public class getTest extends BaseApiTest {

    @Test
    @Step("test Account Base")
    void getAccountBaseTest() {
        GetResponseAccountBase resp = given()
                .log()
                .uri()
                .log()
                .method()
                .spec(requestSpecGet)
                .when()
                .get(TestEndpoints.GET_ACCOUNT, username)
                .then()
                .spec(responseSpecGet)
                .extract()
                .body()
                .as(GetResponseAccountBase.class);
        identifier = resp.getData().getId();
        assertThat(resp.getData().getUrl(), equalTo(username));
    }

    @Test
    @Step("test Account Settings")
    void getAccountSettingsTest() {
        GetResponseAccountSettings resp = given()
                .log()
                .uri()
                .log()
                .method()
                .spec(requestSpecGet)
                .when()
                .get(TestEndpoints.GET_SETTINGS)
                .then()
                .spec(responseSpecGet)
                .extract()
                .body()
                .as(GetResponseAccountSettings.class);
        assertThat(resp.getData().getAccountUrl(), equalTo(username));
    }

    @Test
    @Step("test Credit")
    void getCreditTest() {
        GetResponseCredit resp = given()
                .log()
                .uri()
                .log()
                .method()
                .spec(requestSpecGet)
                .when()
                .get(TestEndpoints.GET_CREDITS)
                .then()
                .spec(responseSpecGet)
                .extract()
                .body()
                .as(GetResponseCredit.class);
        assertThat(resp.getData().getUserLimit(), allOf(greaterThan(0)));
        assertThat(resp.getData().getClientLimit(), allOf(greaterThan(0)));
    }

    @Test
    @Step("test GET Image")
    void getImageTest() {
        GetResponseImage resp = given()
                .log()
                .uri()
                .log()
                .method()
                .spec(requestSpecGet)
                .when()
                .get(TestEndpoints.GET_IMAGE, baseImageHash)
                .then()
                .spec(responseSpecGet)
                .extract()
                .body()
                .as(GetResponseImage.class);
        assertThat(resp.getData().getLink(), equalTo(imgurImagePath));
        assertThat(resp.getData().getAccountId(), equalTo(identifier));
        assertThat(resp.getData().getId(), equalTo(baseImageHash));
    }
}
