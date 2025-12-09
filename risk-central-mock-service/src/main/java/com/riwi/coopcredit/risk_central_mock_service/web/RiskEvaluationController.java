package com.riwi.coopcredit.risk_central_mock_service.web;

import com.riwi.coopcredit.risk_central_mock_service.dto.RiskEvaluationRequestDto;
import com.riwi.coopcredit.risk_central_mock_service.dto.RiskEvaluationResponseDto;
import com.riwi.coopcredit.risk_central_mock_service.service.RiskEvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk-evaluation")
@RequiredArgsConstructor
public class RiskEvaluationController {

    private final RiskEvaluationService riskEvaluationService;

    @PostMapping
    public ResponseEntity<RiskEvaluationResponseDto> evaluate(
            @Valid @RequestBody RiskEvaluationRequestDto request) {

        RiskEvaluationResponseDto response = riskEvaluationService.evaluate(request);
        return ResponseEntity.ok(response);
    }
}
