package com.riwi.coopcredit.credit_application_service.domain.model;

import com.riwi.coopcredit.credit_application_service.domain.enums.RiskLevel;
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
public class RiskEvaluation {

    private Long id;
    private int riskScore;
    private RiskLevel riskLevel;
    private String message;
}
