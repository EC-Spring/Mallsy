package org.ec.mallsy.domain.Item.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ItemGetByClassReq {

    @NotNull
    private String largeClass;
    private String mediumClass;
    private String smallClass;

    @Builder
    public ItemGetByClassReq(String largeClass, String mediumClass, String smallClass) {
        this.largeClass = largeClass;
        this.mediumClass = mediumClass;
        this.smallClass = smallClass;
    }
}
