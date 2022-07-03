package org.ec.mallsy.domain.Item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ItemPutReq {

    @NotNull
    private Long id;

    @Size(min = 4, max = 64)
    private String title;
    @Size(min = 1, max = 64)
    private String brand;

    @Max(1)
    private Long price;
    @Size(min = 32, max = 2048)
    private String content;

    private String largeClass;
    private String mediumClass;
    private String smallClass;

    private Map<String, Integer> stocks;
}
