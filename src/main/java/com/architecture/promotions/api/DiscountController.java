package com.architecture.promotions.api;

import com.architecture.promotions.domain.model.DiscountedProducts;
import com.architecture.promotions.domain.model.Product;
import com.architecture.promotions.actions.RedeemPromotionCode;

import java.util.List;

public class DiscountController {

    private RedeemPromotionCode redeemPromotionCode;

    public DiscountController(RedeemPromotionCode service) {
        this.redeemPromotionCode = service;
    }

    public DiscountedProducts applyDiscount(String code, List<Product> products) {
         return redeemPromotionCode.execute(code, products);
    }
}
