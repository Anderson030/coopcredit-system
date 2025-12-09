package com.riwi.coopcredit.credit_application_service.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateRequest {

    @NotBlank
    private String documentNumber;

    @NotBlank
    private String fullName;

    @NotNull
    @Min(1)
    private Double salary;
}
