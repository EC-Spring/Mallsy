package org.ec.mallsy.domain.Image.entity;

import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.cart.entity.Cart;
import org.ec.mallsy.domain.comment.entity.Comment;
import org.ec.mallsy.domain.delivery.delivery.Delivery;

import javax.persistence.*;

@Entity
@Table(name = "Image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 256)
    private String url;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "commentId", insertable = false, updatable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "itemId", insertable = false, updatable = false)
    private Item item;

    @OneToOne
    @MapsId
    @JoinColumn(name = "deliveryId")
    private Delivery delivery;
}
