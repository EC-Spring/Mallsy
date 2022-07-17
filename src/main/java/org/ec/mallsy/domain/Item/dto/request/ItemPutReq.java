package org.ec.mallsy.domain.Item.dto.request;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
public class ItemPutReq {

    @NotNull
    private Long id;

    @Size(min = 4, max = 64)
    private String title;
    @Size(min = 1, max = 64)
    private String brand;

    private Long price;
    @Size(min = 32, max = 2048)
    private String content;

    private String largeClass;
    private String mediumClass;
    private String smallClass;

    private Map<String, Integer> stocks;

    @Builder
    public ItemPutReq(Long id, String title, String brand, Long price, String content, String largeClass, String mediumClass, String smallClass, Map<String, Integer> stocks) {
        this.id = id;
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.content = content;
        this.largeClass = largeClass;
        this.mediumClass = mediumClass;
        this.smallClass = smallClass;
        this.stocks = stocks;
    }
}
