package org.ec.mallsy.domain.user.entity;

import lombok.Builder;
import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.address.entity.Address;
import org.ec.mallsy.domain.cart.entity.Cart;
import org.ec.mallsy.domain.coupon.entity.Coupon;
import org.ec.mallsy.domain.delivery.delivery.Delivery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 64, unique = true)
    private String username;

    @Column(nullable = false, length = 1024)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "user")
    private List<Coupon> coupons;

    protected User() {
    }

    @Builder
    public User(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
