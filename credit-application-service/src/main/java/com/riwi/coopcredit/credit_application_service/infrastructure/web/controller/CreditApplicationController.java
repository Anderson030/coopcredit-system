package com.riwi.coopcredit.credit_application_service.infrastructure.web.controller;

import com.riwi.coopcredit.credit_application_service.application.dto.CreditApplicationRequest;
import com.riwi.coopcredit.credit_application_service.application.dto.CreditApplicationResponse;
import com.riwi.coopcredit.credit_application_service.application.mapper.CreditApplicationMapper;
import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;
import com.riwi.coopcredit.credit_application_service.domain.ports.in.EvaluateCreditApplicationUseCase;
import com.riwi.coopcredit.credit_application_service.domain.ports.in.RegisterCreditApplicationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-applications")
@RequiredArgsConstructor
public class CreditApplicationController {

    private final RegisterCreditApplicationUseCase registerUseCase;
    private final EvaluateCreditApplicationUseCase evaluateUseCase;
    private final CreditApplicationMapper mapper;

    @PostMapping
    public ResponseEntity<CreditApplicationResponse> create(
            @Valid @RequestBody CreditApplicationRequest request) {

        CreditApplication toCreate = mapper.toDomain(request);
        CreditApplication created = registerUseCase.register(toCreate);
        CreditApplicationResponse response = mapper.toResponse(created);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{id}/evaluate")
    public ResponseEntity<CreditApplicationResponse> evaluate(@PathVariable Long id) {
        CreditApplication evaluated = evaluateUseCase.evaluate(id);
        CreditApplicationResponse response = mapper.toResponse(evaluated);
        return ResponseEntity.ok(response);
    }
}
