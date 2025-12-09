package com.riwi.coopcredit.credit_application_service.application.usecase;

import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;
import com.riwi.coopcredit.credit_application_service.domain.ports.in.RegisterCreditApplicationUseCase;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.CreditApplicationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterCreditApplicationService implements RegisterCreditApplicationUseCase {

    private final CreditApplicationRepositoryPort creditApplicationRepositoryPort;

    @Override
    @Transactional
    public CreditApplication register(CreditApplication creditApplication) {
        return creditApplicationRepositoryPort.save(creditApplication);
    }
}
