package com.architecture.promotions;


import com.architecture.promotions.domain.model.DiscountedProduct;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedeemPromotionCodeFeature {
    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    @Ignore
    public void apply_a_percentage_discount_to_a_list_of_products_old() throws JSONException {


        JSONObject product = new JSONObject();
        product.put("id", 1);
        product.put("size", "M");
        product.put("colour", "Rojo");
        product.put("price", 100);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(product);

        JSONObject jsonExpectedDiscountedProducts = new JSONObject();
        DiscountedProduct discountedProduct = new DiscountedProduct(1, "M", "Rojo", 100, 90);
        List<DiscountedProduct> discountedProducts = new ArrayList<>();
        discountedProducts.add(discountedProduct);

        jsonExpectedDiscountedProducts.put("totalDiscount", 100);
        jsonExpectedDiscountedProducts.put("discountedProducts", discountedProducts);

        given().contentType(ContentType.JSON)
                .body(jsonArray)
                .post("/redeem-promotioncode/jackets")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("response.totalDiscount", equalTo(anyInt()))
                .body("response.discountedProducts", equalTo(jsonExpectedDiscountedProducts));
    }

    @Test
    public void apply_a_percentage_discount_to_a_list_of_products(){

        String products = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"size\": \"M\",\n" +
                "    \"colour\": \"Rojo\",\n" +
                "    \"price\": 100\n" +
                "  }\n" +
                "]";
        String expectedDiscountedProducts = "{\n" +
                "  \"totalDiscount\": 10,\n" +
                "  \"discountedProducts\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"size\": \"M\",\n" +
                "      \"colour\": \"Rojo\",\n" +
                "      \"initialPrice\": 100,\n" +
                "      \"discountedPrice\": 90\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        given()
                .pathParam("promotioncode", "chaquetas10")
                .contentType(ContentType.JSON)
                .body(products)
                .post("/redeem-promotioncode/{promotioncode}")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .body(equalTo(expectedDiscountedProducts)).statusCode(200);
    }
}
