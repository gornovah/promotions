package com.architecture.promotions;

import com.architecture.promotions.actions.RedeemPromotion;
import com.architecture.promotions.api.MapToDiscountedProduct;
import com.architecture.promotions.domain.repository.PromotionCodeRepository;
import com.architecture.promotions.infrastructure.data.JpaPromotionCodeRepository;
import com.architecture.promotions.infrastructure.data.PromotionCodeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public RedeemPromotion redeemPromotion(PromotionCodeRepository promotionCodeRepository) {
        return new RedeemPromotion(promotionCodeRepository);
    }

    @Bean
    public MapToDiscountedProduct mapToDiscountedProduct() {
        return new MapToDiscountedProduct();
    }

    @Bean
    public PromotionCodeRepositoryAdapter promotionCodeRepositoryAdapter(JpaPromotionCodeRepository jpaPromotionCodeRepository) {
        return new PromotionCodeRepositoryAdapter(jpaPromotionCodeRepository, mapToPromotionCode);
    }
}
