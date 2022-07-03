package org.ec.mallsy.domain.Item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ItemPostReq {

    @NotNull
    private Long sellerId;

    @NotNull
    private Long partNumber;
    @NotNull @Size(min = 4, max = 64)
    private String title;
    @NotNull @Size(min = 1, max = 64)
    private String brand;
    @NotNull
    private Long price;
    @NotNull @Size(min = 32, max = 2048)
    private String content;

    @NotNull
    private String largeClass;
    @NotNull
    private String mediumClass;
    @NotNull
    private String smallClass;

    @NotNull
    private Map<String, Integer> stocks;
}
