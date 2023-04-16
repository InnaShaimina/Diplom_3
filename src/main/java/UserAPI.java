import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserAPI {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/api";
    public static final String USER_AUTH = "/auth/login";
    public static final String USER_DEL_DELETE = "/auth/user";

    public static RequestSpecification getReqSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .build();
    }

    public ValidatableResponse loginUser(String email, String password) {
        String json = "{\"email\":\"" + email + "\","
                + "\"password\":\"" + password + "\"}";
        return given()
                .spec(getReqSpec())
                .body(json)
                .when()
                .post(USER_AUTH)
                .then();
    }

    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getReqSpec())
                .header("authorization", accessToken)
                .when()
                .delete(USER_DEL_DELETE)
                .then();
    }
}
