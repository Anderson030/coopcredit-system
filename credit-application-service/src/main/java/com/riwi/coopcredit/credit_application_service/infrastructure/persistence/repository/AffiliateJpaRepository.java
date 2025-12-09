package com.riwi.coopcredit.credit_application_service.infrastructure.persistence.repository;

import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.AffiliateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AffiliateJpaRepository extends JpaRepository<AffiliateEntity, Long> {

    Optional<AffiliateEntity> findByDocumentNumber(String documentNumber);
}
