package com.riwi.coopcredit.credit_application_service.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreditApplicationRequest {

    @NotNull
    private Long affiliateId;

    @NotNull
    @Min(1)
    private Double amount;

    @NotNull
    @Min(1)
    private Integer installments;

    public Long getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(Long affiliateId) {
        this.affiliateId = affiliateId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
