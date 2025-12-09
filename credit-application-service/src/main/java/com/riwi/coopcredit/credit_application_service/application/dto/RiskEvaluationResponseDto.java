package com.riwi.coopcredit.credit_application_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskEvaluationResponseDto {

    private int riskScore;
    private String riskLevel;
    private String message;
}
