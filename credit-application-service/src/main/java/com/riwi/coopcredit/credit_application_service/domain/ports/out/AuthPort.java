package com.riwi.coopcredit.credit_application_service.domain.ports.out;

import com.riwi.coopcredit.credit_application_service.domain.model.User;

import java.util.Optional;

public interface AuthPort {

    User saveUser(User user);

    Optional<User> findByUsername(String username);
}
