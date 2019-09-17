package com.architecture.promotions.domain.repository;

import com.architecture.promotions.domain.model.PromotionCode;
import org.springframework.data.repository.Repository;

public interface PromotionCodeRepository {
    PromotionCode findByName(String promotionCodeName);
}
