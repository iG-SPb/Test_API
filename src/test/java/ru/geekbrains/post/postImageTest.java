package ru.geekbrains.post;

import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.geekbrains.base.BaseApiTest;
import ru.geekbrains.dto.PostResponseNegative;
import ru.geekbrains.utils.FileEncodingUtils;
import ru.geekbrains.utils.TestEndpoints;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static java.lang.Boolean.TRUE;
import ru.geekbrains.dto.PostResponseImage;
import ru.geekbrains.utils.TestImagesNegative;
import ru.geekbrains.utils.TestImagesPositive;

public class postImageTest extends BaseApiTest {

    @ParameterizedTest
    @EnumSource(TestImagesPositive.class)
    @Step("test Post positive")
    void putImagePositiveTest(TestImagesPositive imagesPositive) {
        String fileName = imagesPositive.getPath();
        FileEncodingUtils.setInputImageFilePath(fileName);
        PostResponseImage resp = given()
                .log()
                .uri()
                .log()
                .method()
                .spec(requestSpecPost)
                .multiPart("image", FileEncodingUtils.getFileContent())
                .when()
                .post(TestEndpoints.POST_IMAGE)
                .then()
                .spec(responseSpecPostPositive)
                .extract()
                .body()
                .as(PostResponseImage.class);
        assertThat(resp.getData().getAccountId(), equalTo(identifier));
        assertThat(resp.getData().getSize(), allOf(greaterThan(0)));
        hashImage = resp.getData().getDeletehash();
        imageloadingFlag = TRUE;
    }

    @ParameterizedTest
    @EnumSource(TestImagesNegative.class)
    @Step("test Post negative")
    void putImageNegativeTest(TestImagesNegative imagesNegative) {
        String fileName = imagesNegative.getPath();
        FileEncodingUtils.setInputImageFilePath(fileName);
        PostResponseNegative resp = given()
                .log()
                .uri()
                .log()
                .method()
                .spec(requestSpecPost)
                .multiPart("image", FileEncodingUtils.getFileContent())
                .when()
                .post(TestEndpoints.POST_IMAGE)
                .then()
                .spec(responseSpecPostNegative)
                .extract()
                .body()
                .as(PostResponseNegative.class);
    }
}
