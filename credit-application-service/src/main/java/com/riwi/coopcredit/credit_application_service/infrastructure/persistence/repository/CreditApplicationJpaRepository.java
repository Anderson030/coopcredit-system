package com.riwi.coopcredit.credit_application_service.infrastructure.persistence.repository;

import com.riwi.coopcredit.credit_application_service.domain.enums.CreditStatus;
import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.CreditApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditApplicationJpaRepository
        extends JpaRepository<CreditApplicationEntity, Long> {

    List<CreditApplicationEntity> findByAffiliateId(Long affiliateId);

    List<CreditApplicationEntity> findByStatus(CreditStatus status);
}
