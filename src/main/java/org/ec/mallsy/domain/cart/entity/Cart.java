package org.ec.mallsy.domain.cart.entity;

import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.coupon.entity.Coupon;
import org.ec.mallsy.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long sellerId;

    @Column(nullable = false)
    private Long putAt;

//    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Item item;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Image image;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}
