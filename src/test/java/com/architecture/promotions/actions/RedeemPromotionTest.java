package com.architecture.promotions.actions;

import com.architecture.promotions.domain.model.Product;
import com.architecture.promotions.domain.repository.PromotionCodeRepository;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class RedeemPromotionTest {
    @Test public void
    check_promotion_code_exists() {
        PromotionCodeRepository promotionCodeRepository = mock(PromotionCodeRepository.class);
        RedeemPromotion redeemPromotion = new RedeemPromotion(promotionCodeRepository);
        String promotionCodeName = "JACKETS10";
        List<Product> products = Arrays.asList();

        redeemPromotion.execute(products, promotionCodeName);

        Mockito.verify(promotionCodeRepository).findByName(promotionCodeName);

    }

}