package com.riwi.coopcredit.credit_application_service.infrastructure.web.controller;

import com.riwi.coopcredit.credit_application_service.application.dto.AffiliateRequest;
import com.riwi.coopcredit.credit_application_service.application.dto.AffiliateResponse;
import com.riwi.coopcredit.credit_application_service.application.mapper.AffiliateMapper;
import com.riwi.coopcredit.credit_application_service.domain.model.Affiliate;
import com.riwi.coopcredit.credit_application_service.domain.ports.in.RegisterAffiliateUseCase;
import com.riwi.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affiliates")
@RequiredArgsConstructor
public class AffiliateController {

    private final RegisterAffiliateUseCase registerAffiliateUseCase;
    private final AffiliateRepositoryPort affiliateRepositoryPort;
    private final AffiliateMapper affiliateMapper;

    @PostMapping
    public ResponseEntity<AffiliateResponse> register(@Valid @RequestBody AffiliateRequest request) {
        Affiliate affiliate = affiliateMapper.toDomain(request);
        Affiliate saved = registerAffiliateUseCase.registerAffiliate(affiliate);
        AffiliateResponse response = affiliateMapper.toResponse(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AffiliateResponse>> getAll() {
        List<AffiliateResponse> affiliates = affiliateRepositoryPort.findAll()
                .stream()
                .map(affiliateMapper::toResponse)
                .toList();

        return ResponseEntity.ok(affiliates);
    }
}
