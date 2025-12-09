package com.riwi.coopcredit.credit_application_service.infrastructure.client;

import com.riwi.coopcredit.credit_application_service.application.dto.RiskEvaluationRequestDto;
import com.riwi.coopcredit.credit_application_service.application.dto.RiskEvaluationResponseDto;
import com.riwi.coopcredit.credit_application_service.domain.enums.RiskLevel;
import com.riwi.coopcredit.credit_application_service.domain.model.RiskEvaluation;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.RiskEvaluationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RiskCentralRestAdapter implements RiskEvaluationPort {

    private final RestTemplate restTemplate;

    @Value("${coopcredit.risk-central.base-url}")
    private String riskCentralBaseUrl;

    @Override
    public RiskEvaluation evaluateRisk(String documentNumber) {

        RiskEvaluationRequestDto request = RiskEvaluationRequestDto.builder()
                .documentNumber(documentNumber)
                .build();

        RiskEvaluationResponseDto response = restTemplate.postForObject(
                riskCentralBaseUrl + "/risk-evaluation",
                request,
                RiskEvaluationResponseDto.class
        );

        if (response == null) {
            throw new IllegalStateException("RiskCentral service returned null response");
        }

        RiskLevel riskLevel = RiskLevel.valueOf(response.getRiskLevel().toUpperCase());

        return RiskEvaluation.builder()
                .riskScore(response.getRiskScore())
                .riskLevel(riskLevel)
                .message(response.getMessage())
                .build();
    }
}
