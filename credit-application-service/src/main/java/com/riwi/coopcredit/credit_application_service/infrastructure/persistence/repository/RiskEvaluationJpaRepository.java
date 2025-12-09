package com.riwi.coopcredit.credit_application_service.infrastructure.persistence.repository;

import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.RiskEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskEvaluationJpaRepository extends JpaRepository<RiskEvaluationEntity, Long> {
}
