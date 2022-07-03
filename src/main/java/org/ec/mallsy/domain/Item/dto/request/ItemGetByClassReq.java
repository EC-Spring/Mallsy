package org.ec.mallsy.domain.Item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class ItemGetByClassReq {

    @NotNull
    private String largeClass;
    private String mediumClass;
    private String smallClass;
}
