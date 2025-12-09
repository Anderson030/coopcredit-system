package com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity;

import com.riwi.coopcredit.credit_application_service.domain.enums.CreditStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "credit_applications")
@Getter
@Setter
public class CreditApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "affiliate_id", nullable = false)
    private AffiliateEntity affiliate;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Integer installments;

    @Column(name = "monthly_installment", nullable = false)
    private Double monthlyInstallment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CreditStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
