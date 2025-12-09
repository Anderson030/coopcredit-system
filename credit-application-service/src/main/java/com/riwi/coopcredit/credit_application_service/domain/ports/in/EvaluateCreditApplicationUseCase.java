package com.riwi.coopcredit.credit_application_service.domain.ports.in;

import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;

public interface EvaluateCreditApplicationUseCase {

    CreditApplication evaluate(Long creditApplicationId);
}
