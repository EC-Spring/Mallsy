package org.ec.mallsy.domain.Item.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.comment.entity.Comment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
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
}
