package com.riwi.coopcredit.credit_application_service.application.usecase;

import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;
import com.riwi.coopcredit.credit_application_service.domain.model.RiskEvaluation;
import com.riwi.coopcredit.credit_application_service.domain.ports.in.EvaluateCreditApplicationUseCase;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.CreditApplicationRepositoryPort;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.RiskEvaluationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EvaluateCreditApplicationService implements EvaluateCreditApplicationUseCase {

    private final CreditApplicationRepositoryPort creditApplicationRepositoryPort;
    private final RiskEvaluationPort riskEvaluationPort;

    @Override
    @Transactional
    public CreditApplication evaluate(Long creditApplicationId) {

        CreditApplication creditApplication = creditApplicationRepositoryPort.findById(creditApplicationId)
                .orElseThrow(() -> new RuntimeException("Credit application not found"));

        String documentNumber = creditApplication.getAffiliate().getDocumentNumber();

        RiskEvaluation riskEvaluation = riskEvaluationPort.evaluateRisk(documentNumber);

        creditApplication.setRiskEvaluation(riskEvaluation);

        return creditApplicationRepositoryPort.save(creditApplication);
    }
}
