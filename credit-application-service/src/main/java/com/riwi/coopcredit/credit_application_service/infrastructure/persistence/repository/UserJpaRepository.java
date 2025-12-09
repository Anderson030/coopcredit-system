package com.riwi.coopcredit.credit_application_service.infrastructure.persistence.repository;

import com.riwi.coopcredit.credit_application_service.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
