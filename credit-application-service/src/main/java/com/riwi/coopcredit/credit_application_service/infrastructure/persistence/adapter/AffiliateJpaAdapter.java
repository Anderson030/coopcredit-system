package com.riwi.coopcredit.credit_application_service.infrastructure.persistence.adapter;

import com.riwi.coopcredit.credit_application_service.application.mapper.AffiliateMapper;
import com.riwi.coopcredit.credit_application_service.domain.model.Affiliate;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.AffiliateEntity;
import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.repository.AffiliateJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AffiliateJpaAdapter implements AffiliateRepositoryPort {

    private final AffiliateJpaRepository affiliateJpaRepository;
    private final AffiliateMapper affiliateMapper;

    @Override
    public Affiliate save(Affiliate affiliate) {
        AffiliateEntity entity = affiliateMapper.toEntity(affiliate);
        AffiliateEntity saved = affiliateJpaRepository.save(entity);
        return affiliateMapper.toDomain(saved);
    }

    @Override
    public Optional<Affiliate> findById(Long id) {
        return affiliateJpaRepository.findById(id)
                .map(affiliateMapper::toDomain);
    }

    @Override
    public Optional<Affiliate> findByDocumentNumber(String documentNumber) {
        return affiliateJpaRepository.findByDocumentNumber(documentNumber)
                .map(affiliateMapper::toDomain);
    }

    @Override
    public List<Affiliate> findAll() {
        return affiliateJpaRepository.findAll()
                .stream()
                .map(affiliateMapper::toDomain)
                .toList();
    }
}
