package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.RequestModels.AuthRegRequest;
import models.ResponseModels.AuthRegResponse;

import static io.restassured.RestAssured.given;

public class API_Steps {

    @Step("Создание пользователя")
    public AuthRegResponse userRegistration(String baseURL, AuthRegRequest authRegRequest, Integer statusCode){
        return given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(authRegRequest)
                .when()
                .post("/signup")
                .then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON)
                .extract().body().as(AuthRegResponse.class);
    }

    @Step("Авторизация пользователя")
    public AuthRegResponse authorizationSuccessful(String baseURL, AuthRegRequest authRegRequest, Integer statusCode){
        return given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(authRegRequest)
                .when()
                .post("/login")
                .then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON)
                .extract().body().as(AuthRegResponse.class);
    }
}
