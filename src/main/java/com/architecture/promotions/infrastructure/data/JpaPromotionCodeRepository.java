package com.architecture.promotions.infrastructure.data;

import com.architecture.promotions.domain.model.PromotionCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JpaPromotionCodeRepository extends JpaRepository<JpaPromotionCode, Long> {
    JpaPromotionCode findByName(String promotionCodeName);
}
