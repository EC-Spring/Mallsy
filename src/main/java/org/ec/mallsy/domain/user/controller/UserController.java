package org.ec.mallsy.domain.user.controller;

import org.ec.mallsy.domain.user.dto.TokenDto;
import org.ec.mallsy.domain.user.dto.UserDto;
import org.ec.mallsy.domain.user.dto.UserSummaryDto;
import org.ec.mallsy.domain.user.service.UserService;
import org.ec.mallsy.global.security.provider.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUser() {
        return "user";
    }

    @GetMapping("/auth")
    public String getAuth() {
        return "auth";
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserSummaryDto> signUp(@RequestBody UserDto userDto) {
        return ResponseEntity
                .created(URI.create("/user/signUp"))
                .body(userService.signUp(userDto));
    }

    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody UserDto userDto) {
        return ResponseEntity
                .ok(userService.signIn(userDto));
    }
}
