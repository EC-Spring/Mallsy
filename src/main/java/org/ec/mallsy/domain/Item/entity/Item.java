package org.ec.mallsy.domain.Item.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.cart.entity.Cart;
import org.ec.mallsy.domain.comment.entity.Comment;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Item")
@NoArgsConstructor
@Getter
@DynamicUpdate
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

    @Column(nullable = false)
    private String largeClass;
    @Column(nullable = false)
    private String mediumClass;
    @Column(nullable = false)
    private String smallClass;

    @OneToMany(mappedBy = "item")
    private List<Image> images;

    @OneToMany(mappedBy = "item")
    private List<Comment> comments;

//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "id")
//    private Cart cart;

    @MapKeyColumn(length = 64)
    @ElementCollection()
    @CollectionTable(name = "ItemStock",
            joinColumns = {@JoinColumn(name = "stockId", referencedColumnName = "id")})
    private Map<String, Integer> stocks;

    public Item(Long sellerId, Long partNumber,
                String title, String brand, Long price, String content,
                String largeClass, String mediumClass, String smallClass, Map<String, Integer> stocks) {
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

        this.views = 0L;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    @Builder
    public Item(Long id, String title, String brand, Long price, String content, String largeClass, String mediumClass, String smallClass, Map<String, Integer> stocks) {
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

    public void increaseViews() {
        this.views++;
    }

    public void setUpdatedAt() {
        updatedAt = System.currentTimeMillis();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLargeClass(String largeClass) {
        this.largeClass = largeClass;
    }

    public void setMediumClass(String mediumClass) {
        this.mediumClass = mediumClass;
    }

    public void setSmallClass(String smallClass) {
        this.smallClass = smallClass;
    }

    public void setStocks(Map<String, Integer> stocks) {
        this.stocks = stocks;
    }
}
