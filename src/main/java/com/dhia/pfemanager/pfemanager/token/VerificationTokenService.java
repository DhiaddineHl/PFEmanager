package com.dhia.pfemanager.pfemanager.token;


import com.dhia.pfemanager.pfemanager.user.appUser.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;


    public String createVerificationToken(User user){

        var verificationToken = VerificationToken.builder()
                        .verificationToken(UUID.randomUUID().toString())
                                .expired(false)
                                        .expireAt(LocalDateTime.now().plusHours(24))
                                                .user(user)

                .build();
        verificationTokenRepository.save(verificationToken);
           return verificationToken.getVerificationToken();
    }

}
