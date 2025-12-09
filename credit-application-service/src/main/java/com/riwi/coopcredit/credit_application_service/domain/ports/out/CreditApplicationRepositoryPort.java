package com.riwi.coopcredit.credit_application_service.domain.ports.out;

import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;

import java.util.List;
import java.util.Optional;

public interface CreditApplicationRepositoryPort {

    CreditApplication save(CreditApplication creditApplication);

    Optional<CreditApplication> findById(Long id);

    List<CreditApplication> getAll();
}
