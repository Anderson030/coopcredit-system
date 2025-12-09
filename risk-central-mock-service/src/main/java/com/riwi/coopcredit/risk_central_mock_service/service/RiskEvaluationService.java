package com.riwi.coopcredit.risk_central_mock_service.service;

import com.riwi.coopcredit.risk_central_mock_service.dto.RiskEvaluationRequestDto;
import com.riwi.coopcredit.risk_central_mock_service.dto.RiskEvaluationResponseDto;

public interface RiskEvaluationService {

    RiskEvaluationResponseDto evaluate(RiskEvaluationRequestDto request);
}
