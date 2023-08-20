package com.dhia.pfemanager.pfemanager.token;

import java.time.LocalDateTime;

public record VerificationTokenDTO(
        String verificationToken,
        boolean isExpired,
        LocalDateTime expiredAt,
        Integer userId
) {
}
