package com.architecture.promotions.infrastructure.data;

import com.architecture.promotions.domain.model.PromotionCode;
import com.architecture.promotions.domain.repository.PromotionCodeRepository;

public class PromotionCodeRepositoryAdapter implements PromotionCodeRepository {

    private final JpaPromotionCodeRepository jpaPromotionCodeRepository;
    private final MapToPromotionCode mapToPromotionCode;

    public PromotionCodeRepositoryAdapter(JpaPromotionCodeRepository jpaPromotionCodeRepository, MapToPromotionCode mapToPromotionCode) {
        this.jpaPromotionCodeRepository = jpaPromotionCodeRepository;
        this.mapToPromotionCode = mapToPromotionCode;
    }

    @Override
    public PromotionCode findByName(String promotionCodeName) {
        JpaPromotionCode jpaPromotionCode = jpaPromotionCodeRepository.findByName(promotionCodeName);
        return mapToPromotionCode.execute(jpaPromotionCode);
    }
}
