package com.dhia.pfemanager.pfemanager.confirmationwithemail;


import com.dhia.pfemanager.pfemanager.exceptions.UserNotFoundException;
import com.dhia.pfemanager.pfemanager.user.appUser.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetService {

    private final UserRepository userRepository;
    private final PasswordResetRepository passwordResetRepository;


    public void resetPassword(String userEmail) {
        createPasswordResetEntity(userEmail);
        // send the email

    }

    public void createPasswordResetEntity(String userEmail){
        if (!userRepository.existsByEmail(userEmail)){
            throw new UserNotFoundException("User not found, try a valid email");
        }
        var user  = userRepository.findUserByEmailAddress(userEmail);
        PasswordResetEntity passwordResetEntity = new PasswordResetEntity(user);
        passwordResetRepository.save(passwordResetEntity);
    }
}
