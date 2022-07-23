package org.ec.mallsy.domain.user.dto;

import lombok.Builder;

public class UserSummaryDto {

    private Long id;
    private String username;

    public UserSummaryDto() {
        super();
    }

    @Builder
    public UserSummaryDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
