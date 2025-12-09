package com.riwi.coopcredit.credit_application_service.domain.ports.in;

import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;

public interface RegisterCreditApplicationUseCase {

    CreditApplication register(CreditApplication creditApplication);
}
