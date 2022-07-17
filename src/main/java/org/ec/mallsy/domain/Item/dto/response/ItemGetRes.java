package org.ec.mallsy.domain.Item.dto.response;

import lombok.*;
import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.comment.entity.Comment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ItemGetRes {

    @NotNull
    private Long id;
    @NotNull
    private Long sellerId;

    @NotNull
    private Long partNumber;
    @NotNull @Size(min = 4, max = 64)
    private String title;
    @NotNull @Size(min = 1, max = 64)
    private String brand;
    @NotNull
    private Long views;
    @NotNull
    private Long price;
    @NotNull @Size(min = 32, max = 2048)
    private String content;

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


    private List<Image> images;
    private List<Comment> comments;

    @NotNull
    private Map<String, Integer> stocks;

    @Builder
    public ItemGetRes(Long id, Long sellerId, Long partNumber, String title, String brand, Long views, Long price, String content, Long createdAt, Long updatedAt, String largeClass, String mediumClass, String smallClass, List<Image> images, List<Comment> comments, Map<String, Integer> stocks) {
        this.id = id;
        this.sellerId = sellerId;
        this.partNumber = partNumber;
        this.title = title;
        this.brand = brand;
        this.views = views;
        this.price = price;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.largeClass = largeClass;
        this.mediumClass = mediumClass;
        this.smallClass = smallClass;
        this.images = images;
        this.comments = comments;
        this.stocks = stocks;
    }
}
