package com.riwi.coopcredit.credit_application_service.domain.ports.out;

import com.riwi.coopcredit.credit_application_service.domain.model.Affiliate;

import java.util.List;
import java.util.Optional;

public interface AffiliateRepositoryPort {

    Affiliate save(Affiliate affiliate);

    Optional<Affiliate> findById(Long id);

    Optional<Affiliate> findByDocumentNumber(String documentNumber);

    List<Affiliate> findAll();
}
