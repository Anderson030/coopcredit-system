package com.riwi.coopcredit.risk_central_mock_service.service;

import com.riwi.coopcredit.risk_central_mock_service.dto.RiskEvaluationRequestDto;
import com.riwi.coopcredit.risk_central_mock_service.dto.RiskEvaluationResponseDto;
import com.riwi.coopcredit.risk_central_mock_service.model.RiskLevel;
import org.springframework.stereotype.Service;

@Service
public class RiskEvaluationServiceImpl implements RiskEvaluationService {

    @Override
    public RiskEvaluationResponseDto evaluate(RiskEvaluationRequestDto request) {
        String document = request.getDocumentNumber();

        // Hash determinístico basado en el documento (0 - 99)
        int hash = Math.abs(document.hashCode());
        int score = hash % 100;

        RiskLevel level;
        String message;

        if (score < 30) {
            level = RiskLevel.LOW;
            message = "Cliente con bajo riesgo.";
        } else if (score < 60) {
            level = RiskLevel.MEDIUM;
            message = "Cliente con riesgo medio.";
        } else if (score < 80) {
            level = RiskLevel.HIGH;
            message = "Cliente con riesgo alto.";
        } else {
            level = RiskLevel.CRITICAL;
            message = "Cliente con riesgo crítico.";
        }

        return RiskEvaluationResponseDto.builder()
                .riskScore(score)
                .riskLevel(level)
                .message(message)
                .build();
    }
}
