package org.ec.mallsy.domain.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

public class TokenDto {

    private String token;
    private Date validity;

    protected TokenDto() {
        super();
    }

    @Builder
    public TokenDto(String username, String token, Date validity) {
        this.token = token;
        this.validity = validity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }
}
