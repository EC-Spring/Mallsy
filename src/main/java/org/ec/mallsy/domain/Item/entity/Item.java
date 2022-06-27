package org.ec.mallsy.domain.Item.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.cart.entity.Cart;
import org.ec.mallsy.domain.comment.entity.Comment;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Item")
@NoArgsConstructor
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long sellerId;

    @Column(nullable = false, unique = true)
    private Long partNumber;
    @Column(nullable = false, length = 64)
    private String title;
    @Column(nullable = false, length = 64)
    private String brand;
    @Column(nullable = false)
    private Long views;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false, length = 2048)
    private String content;

    @Column(nullable = false)
    private Long createdAt;
    @Column(nullable = false)
    private Long updatedAt;

    @OneToMany(mappedBy = "item")
    private List<Image> images;

    @OneToMany(mappedBy = "item")
    private List<Comment> comments;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Cart cart;

    @MapKeyColumn(length = 64)
    @ElementCollection()
    @CollectionTable(name = "ItemStock",
            joinColumns = {@JoinColumn(name = "stockId", referencedColumnName = "id")})
    private Map<String, Integer> stocks;
}
