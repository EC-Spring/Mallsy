package org.ec.mallsy.domain.Item.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SummarizedItemGetRes {

    @NotNull
    private Long id;
    @NotNull
    private Long sellerId;

    @NotNull
    private Long partNumber;
    @NotNull
    private String title;
    @NotNull @Size(min = 1, max = 64)
    private String brand;
    @NotNull
    private Long views;
    @NotNull
    private Long price;

    @NotNull
    private Long createdAt;
    @NotNull
    private Long updatedAt;

    @NotNull
    private String largeClass;
    @NotNull
    private String mediumClass;
    @NotNull
    private String smallClass;

    @NotNull
    private Map<String, Integer> stocks;
}
