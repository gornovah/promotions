package com.architecture.promotions;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedeemPromotionCodeFeature {
    @LocalServerPort
    int port;

    @Before
    public void set_up() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void apply_a_percentage_discount_to_a_list_of_products() {
        String productList = "["+
                "{" +
                "\"id\": 123," +
                "\"size\": \"M\"," +
                "\"colour\": \"red\"," +
                "\"price\": 12.3" +
                "}]";

        String expectedDiscountedProducts = "{" +
                "totalDiscount: 10;" +
                "discountedProducts: [" +
                "{" +
                "\"id\": 123," +
                "\"size\": \"M\"," +
                "\"colour\": \"red\"," +
                "\"initialPrice\": 12.3," +
                "\"discountedPrice\":11.07" +
                "]}";

        given().contentType(ContentType.JSON)
            .body(productList)
            .post("/redeem-promotioncode/jackets")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .contentType(ContentType.JSON)
            .body(equalTo(expectedDiscountedProducts));
    }
}
