package com.architecture.promotions.actions;

import com.architecture.promotions.domain.model.DiscountedProducts;
import com.architecture.promotions.domain.model.Product;
import com.architecture.promotions.domain.repository.PromotionCodeRepository;

import java.util.List;

public class RedeemPromotion {
    private PromotionCodeRepository promotionCodeRepository;

    public RedeemPromotion(PromotionCodeRepository promotionCodeRepository) {
        this.promotionCodeRepository = promotionCodeRepository;
    }

    public DiscountedProducts execute(List<Product> products, String promotionCodeName) {
        promotionCodeRepository.findByName(promotionCodeName);
        return null;
    }
}
