package com.riwi.coopcredit.credit_application_service.infrastructure.persistence.adapter;

import com.riwi.coopcredit.credit_application_service.application.mapper.CreditApplicationMapper;
import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.CreditApplicationRepositoryPort;
import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.CreditApplicationEntity;
import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.repository.CreditApplicationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreditApplicationJpaAdapter implements CreditApplicationRepositoryPort {

    private final CreditApplicationJpaRepository creditApplicationJpaRepository;
    private final CreditApplicationMapper creditApplicationMapper;

    @Override
    public CreditApplication save(CreditApplication creditApplication) {
        CreditApplicationEntity entity = creditApplicationMapper.toEntity(creditApplication);
        CreditApplicationEntity saved = creditApplicationJpaRepository.save(entity);
        return creditApplicationMapper.toDomain(saved);
    }

    @Override
    public Optional<CreditApplication> findById(Long id) {
        return creditApplicationJpaRepository.findById(id)
                .map(creditApplicationMapper::toDomain);
    }

    @Override
    public List<CreditApplication> getAll() {
        return creditApplicationJpaRepository.findAll()
                .stream()
                .map(creditApplicationMapper::toDomain)
                .collect(Collectors.toList());
    }
}
