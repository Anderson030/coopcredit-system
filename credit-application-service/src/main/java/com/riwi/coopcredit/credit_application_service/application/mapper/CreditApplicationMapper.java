package com.riwi.coopcredit.credit_application_service.application.mapper;

import com.riwi.coopcredit.credit_application_service.application.dto.CreditApplicationRequest;
import com.riwi.coopcredit.credit_application_service.application.dto.CreditApplicationResponse;
import com.riwi.coopcredit.credit_application_service.domain.enums.CreditStatus;
import com.riwi.coopcredit.credit_application_service.domain.model.CreditApplication;
import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.CreditApplicationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditApplicationMapper {

    // DTO -> Domain
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "affiliate", ignore = true)
    @Mapping(target = "monthlyInstallment", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "riskEvaluation", ignore = true)
    CreditApplication toDomain(CreditApplicationRequest request);

    // Domain -> DTO
    @Mapping(target = "affiliateId", source = "affiliate.id")
    CreditApplicationResponse toResponse(CreditApplication creditApplication);

    // Domain -> Entity
    @Mapping(target = "affiliate", ignore = true)
    CreditApplicationEntity toEntity(CreditApplication creditApplication);

    // Entity -> Domain
    @Mapping(target = "affiliate", ignore = true)
    @Mapping(target = "riskEvaluation", ignore = true)
    CreditApplication toDomain(CreditApplicationEntity entity);


    default String mapStatusToString(CreditStatus status) {
        return status != null ? status.name() : null;
    }
}
