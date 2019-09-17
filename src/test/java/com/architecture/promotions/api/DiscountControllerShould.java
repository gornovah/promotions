package com.architecture.promotions.api;

import com.architecture.promotions.actions.RedeemPromotionCode;
import com.architecture.promotions.domain.model.Product;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class DiscountControllerShould {

    @Test
    public void call_to_discount_service() {
        List<Product> products = new ArrayList<>();
        RedeemPromotionCode redeemPromotionCode = Mockito.mock(RedeemPromotionCode.class);

        DiscountController discountController = new DiscountController(redeemPromotionCode);
        discountController.applyDiscount("code", products);

        Mockito.verify(redeemPromotionCode).execute("code", products);
    }

}