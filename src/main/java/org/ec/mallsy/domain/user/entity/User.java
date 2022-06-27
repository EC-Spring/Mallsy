package org.ec.mallsy.domain.user.entity;

import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.address.entity.Address;
import org.ec.mallsy.domain.cart.entity.Cart;
import org.ec.mallsy.domain.coupon.entity.Coupon;
import org.ec.mallsy.domain.delivery.delivery.Delivery;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 64)
    private String username;

    @Column(nullable = false, length = 1024)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "user")
    private List<Coupon> coupons;
}
