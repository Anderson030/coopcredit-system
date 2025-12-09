package com.riwi.coopcredit.risk_central_mock_service.dto;

import com.riwi.coopcredit.risk_central_mock_service.model.RiskLevel;
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
    private RiskLevel riskLevel;
    private String message;
}
