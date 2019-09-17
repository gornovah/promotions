package com.architecture.promotions.api;

import com.architecture.promotions.actions.RedeemPromotion;
import com.architecture.promotions.domain.model.DiscountedProducts;
import com.architecture.promotions.domain.model.Product;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class PromotionsControllerTest {
    @Test public void
    delegates_redeem_promotioncode_to_RedeemPromotionService() {
        List<Product> products = Arrays.asList();
        String promotionCode = "";

        RedeemPromotion redeemPromotion = mock(RedeemPromotion.class);

        MapToDiscountedProduct mapToDiscountedProduct = mock(MapToDiscountedProduct.class);
        PromotionsController promotionsController = new PromotionsController(redeemPromotion, mapToDiscountedProduct);
        promotionsController.redeemPromotion(products, promotionCode);

        verify(redeemPromotion).execute(products, promotionCode);
    }

    @Test public void
    delegates_discountedProductsResource_mapping_to_MapToDiscountedProduct() {
        MapToDiscountedProduct mapToDiscountedProduct = mock(MapToDiscountedProduct.class);
        DiscountedProducts discountedProducts = null;
        RedeemPromotion redeemPromotion = mock(RedeemPromotion.class);
        PromotionsController promomotionsController = new PromotionsController(redeemPromotion, mapToDiscountedProduct);
        List<Product> products = Arrays.asList();
        String promotionCode = "";

        promomotionsController.redeemPromotion(products, promotionCode);

        verify(mapToDiscountedProduct).execute(discountedProducts);
    }

}
