package com.riwi.coopcredit.credit_application_service.domain.ports.in;

import com.riwi.coopcredit.credit_application_service.domain.model.Affiliate;

public interface RegisterAffiliateUseCase {

    Affiliate registerAffiliate(Affiliate affiliate);
}
