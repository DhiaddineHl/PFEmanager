package com.dhia.pfemanager.pfemanager.confirmationwithemail;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetRepository extends JpaRepository<PasswordResetEntity, Integer> {

    Optional<PasswordResetEntity> findPasswordResetEntityByToken(String token);
}
