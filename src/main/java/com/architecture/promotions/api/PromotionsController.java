package com.architecture.promotions.api;

import com.architecture.promotions.actions.RedeemPromotion;
import com.architecture.promotions.domain.model.DiscountedProducts;
import com.architecture.promotions.domain.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionsController {
    private final RedeemPromotion redeemPromotion;
    private final MapToDiscountedProduct mapToDiscountedProduct;

    public PromotionsController(RedeemPromotion redeemPromotion, MapToDiscountedProduct mapToDiscountedProduct) {
        this.redeemPromotion = redeemPromotion;
        this.mapToDiscountedProduct = mapToDiscountedProduct;
    }

    @PostMapping("/redeem-promotioncode/{promotionCode}")
    public DiscountedProductsResource redeemPromotion(@RequestBody List<Product> products, @PathVariable String promotionCode) {
        DiscountedProducts discountedProducts = redeemPromotion.execute(products, promotionCode);
        return mapToDiscountedProduct.execute(discountedProducts);
    }
}
