package org.ec.mallsy.domain.coupon.entity;

import org.ec.mallsy.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 64)
    private String type;
    @Column(nullable = false)
    private Long discount;
    @Column(nullable = false)
    private Long atLeastBuy;

    @Column(nullable = false)
    private Long beginDate;
    @Column(nullable = false)
    private Long expiryDate;

    @MapKeyColumn(length = 64)
    @Column(length = 64)
    @ElementCollection
    @CollectionTable(name = "CouponRestriction",
            joinColumns = {@JoinColumn(name = "restrictionId", referencedColumnName = "id")})
    private Map<String, String> restrictions;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}
