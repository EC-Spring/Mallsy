package org.ec.mallsy.domain.user.service.impl;

import org.ec.mallsy.domain.user.dto.TokenDto;
import org.ec.mallsy.domain.user.dto.UserDto;
import org.ec.mallsy.domain.user.dto.UserSummaryDto;
import org.ec.mallsy.domain.user.entity.User;
import org.ec.mallsy.domain.user.repository.UserRepository;
import org.ec.mallsy.domain.user.service.UserService;
import org.ec.mallsy.global.security.provider.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }

    @Override
    public TokenDto signIn(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found."));

        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword()))
                throw new IllegalArgumentException("Username and Password not matched.");

        Date now = new Date();
        Date validity = new Date(now.getTime() + JwtTokenProvider.tokenValidTime / 2);

        return TokenDto.builder()
                .token(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()))
                .validity(validity)
                .build();
    }

    @Override
    public UserSummaryDto signUp(UserDto userDto) {
        Long id = userRepository.save(User.builder()
                        .username(userDto.getUsername())
                        .password(passwordEncoder.encode(userDto.getPassword()))
                        .roles(Collections.singletonList("ROLE_CLIENT"))
                .build()).getId();

        return UserSummaryDto.builder()
                .id(id)
                .username(userDto.getUsername())
                .build();
    }
}
