package ru.netology.postman;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostmanTest1 {
    @Test
    void shouldCheckPostRequest() {
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("id", "100");
        bodyData.put("name", "долг");
        bodyData.put("number", "*6666");
        bodyData.put("balance", "10000000000");
        bodyData.put("currency", "RUB");

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(bodyData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("json.name", equalTo("долг"))
                .body("json.id", equalTo("100"))
                .body("json.number", equalTo("*6666"))
                .body("json.balance", equalTo("10000000000"))
                .body("json.currency", equalTo("RUB"))
        ;
    }
}
