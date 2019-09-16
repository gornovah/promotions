package com.architecture.promotions;


import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedeemPromotionCodeFeature {
    @Test
    public void apply_a_percentage_discount_to_a_list_of_products() {


        JSONObject productList = new JSONObject();

        JSONObject expectedDiscountedProducts = new JSONObject();

        given().contentType(ContentType.JSON)
                .body(productList)
                .post("/redeem-promotioncode/jackets")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("response.totalDiscount", equalTo(anyInt()))
                .body("response.discountedProducts", equalTo(expectedDiscountedProducts));
    }
}
