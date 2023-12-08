package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.RequestModels.AuthRegRequest;
import models.RequestModels.CartRequest;
import models.ResponseModels.AuthRegResponse;
import models.ResponseModels.CartResponse;

import javax.swing.*;

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
    public AuthRegResponse userAuthorization(String baseURL, AuthRegRequest authRegRequest, Integer statusCode){
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

    @Step("Добавление товара в корзину")
    public void addToCart(String baseURL, CartRequest cartRequest, Integer statusCode){
        given()
            .baseUri(baseURL)
            .contentType("application/json")
            .body(cartRequest)
            .when()
            .post("/addtocart")
            .then()
            .statusCode(statusCode);
    }

    @Step("Получение товаров в корзине")
    public CartResponse viewCart(String baseURL, CartRequest cartRequest, Integer statusCode){
        return given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(cartRequest)
                .when()
                .post("/viewcart")
                .then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON)
                .extract().body().as(CartResponse.class);
    }

    public void deleteItemFromCart(String baseURL, CartRequest cartRequest, Integer statusCode){
        given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(cartRequest)
                .when()
                .post("/deleteitem")
                .then()
                .statusCode(statusCode);
    }
    public String deleteCart(String baseURL, CartRequest cartRequest, Integer statusCode){
        return given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(cartRequest)
                .when()
                .post("/deletecart")
                .then()
                .statusCode(statusCode)
                .extract().body().asString();
    }
}
