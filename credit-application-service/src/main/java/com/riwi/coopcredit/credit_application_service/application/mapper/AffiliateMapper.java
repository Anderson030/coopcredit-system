package com.riwi.coopcredit.credit_application_service.application.mapper;

import com.riwi.coopcredit.credit_application_service.application.dto.AffiliateRequest;
import com.riwi.coopcredit.credit_application_service.application.dto.AffiliateResponse;
import com.riwi.coopcredit.credit_application_service.domain.model.Affiliate;
import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.AffiliateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AffiliateMapper {

    // DTO -> Domain
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creditApplications", ignore = true)
    @Mapping(target = "active", constant = "true")
    Affiliate toDomain(AffiliateRequest request);


    AffiliateResponse toResponse(Affiliate affiliate);


    @Mapping(target = "creditApplications", ignore = true)
    AffiliateEntity toEntity(Affiliate affiliate);


    @Mapping(target = "creditApplications", ignore = true)
    Affiliate toDomain(AffiliateEntity entity);
}
