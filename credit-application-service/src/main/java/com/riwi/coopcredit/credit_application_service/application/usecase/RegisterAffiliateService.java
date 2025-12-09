package com.riwi.coopcredit.credit_application_service.application.usecase;

import com.riwi.coopcredit.credit_application_service.domain.model.Affiliate;
import com.riwi.coopcredit.credit_application_service.domain.ports.in.RegisterAffiliateUseCase;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterAffiliateService implements RegisterAffiliateUseCase {

    private final AffiliateRepositoryPort affiliateRepositoryPort;

    @Override
    @Transactional
    public Affiliate registerAffiliate(Affiliate affiliate) {

        if (affiliate.getSalary() == null || affiliate.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero");
        }

        affiliateRepositoryPort.findByDocumentNumber(affiliate.getDocumentNumber())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Document number is already registered");
                });

        affiliate.setActive(true);

        return affiliateRepositoryPort.save(affiliate);
    }
}
