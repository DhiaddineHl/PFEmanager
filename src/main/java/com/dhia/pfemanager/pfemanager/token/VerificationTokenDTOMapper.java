package com.dhia.pfemanager.pfemanager.token;

import java.util.function.Function;

public class VerificationTokenDTOMapper implements Function<VerificationToken,VerificationTokenDTO> {
    @Override
    public VerificationTokenDTO apply(VerificationToken verificationToken) {
        return new VerificationTokenDTO(
                verificationToken.getVerificationToken(),
                verificationToken.isExpired(),
                verificationToken.getExpireAt(),
                verificationToken.getUser().getId()
        );
    }
}
