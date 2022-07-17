package org.ec.mallsy.domain.Item.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

    @Builder
    public ItemPostReq(Long sellerId, Long partNumber, String title, String brand, Long price, String content, String largeClass, String mediumClass, String smallClass, Map<String, Integer> stocks) {
        this.sellerId = sellerId;
        this.partNumber = partNumber;
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
