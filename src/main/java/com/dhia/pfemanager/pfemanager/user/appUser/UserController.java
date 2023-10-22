package com.dhia.pfemanager.pfemanager.user.appUser;


import com.dhia.pfemanager.pfemanager.authentication.UserInformationResponse;
import com.dhia.pfemanager.pfemanager.token.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping("/user/credentials")
//    public ResponseEntity<UserInformationResponse> getUserInformationByToken(
//            @RequestBody Token jwtToken
//            ){
//        return new ResponseEntity<>();
//    }

}
