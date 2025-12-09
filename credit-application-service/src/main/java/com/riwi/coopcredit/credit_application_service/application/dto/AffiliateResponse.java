package com.riwi.coopcredit.credit_application_service.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateResponse {

    private Long id;
    private String documentNumber;
    private String fullName;
    private Double salary;
    private boolean active;
}
