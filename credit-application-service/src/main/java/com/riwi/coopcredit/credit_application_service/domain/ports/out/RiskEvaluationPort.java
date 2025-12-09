package com.riwi.coopcredit.credit_application_service.domain.ports.out;

import com.riwi.coopcredit.credit_application_service.domain.model.RiskEvaluation;

public interface RiskEvaluationPort {

    RiskEvaluation evaluateRisk(String documentNumber);
}
