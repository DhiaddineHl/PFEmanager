package com.dhia.pfemanager.pfemanager.token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {

    VerificationToken findByVerificationToken(String verificationToken);

}
