package org.ec.mallsy.domain.user.service;

import org.ec.mallsy.domain.user.dto.TokenDto;
import org.ec.mallsy.domain.user.dto.UserDto;
import org.ec.mallsy.domain.user.dto.UserSummaryDto;

public interface UserService {

    public TokenDto signIn(UserDto userDto);
    public UserSummaryDto signUp(UserDto userDto);
}
