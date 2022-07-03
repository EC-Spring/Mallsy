package org.ec.mallsy.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1021571503L;

    public static final QUser user = new QUser("user");

    public final ListPath<org.ec.mallsy.domain.address.entity.Address, org.ec.mallsy.domain.address.entity.QAddress> addresses = this.<org.ec.mallsy.domain.address.entity.Address, org.ec.mallsy.domain.address.entity.QAddress>createList("addresses", org.ec.mallsy.domain.address.entity.Address.class, org.ec.mallsy.domain.address.entity.QAddress.class, PathInits.DIRECT2);

    public final ListPath<org.ec.mallsy.domain.cart.entity.Cart, org.ec.mallsy.domain.cart.entity.QCart> carts = this.<org.ec.mallsy.domain.cart.entity.Cart, org.ec.mallsy.domain.cart.entity.QCart>createList("carts", org.ec.mallsy.domain.cart.entity.Cart.class, org.ec.mallsy.domain.cart.entity.QCart.class, PathInits.DIRECT2);

    public final ListPath<org.ec.mallsy.domain.coupon.entity.Coupon, org.ec.mallsy.domain.coupon.entity.QCoupon> coupons = this.<org.ec.mallsy.domain.coupon.entity.Coupon, org.ec.mallsy.domain.coupon.entity.QCoupon>createList("coupons", org.ec.mallsy.domain.coupon.entity.Coupon.class, org.ec.mallsy.domain.coupon.entity.QCoupon.class, PathInits.DIRECT2);

    public final ListPath<org.ec.mallsy.domain.delivery.delivery.Delivery, org.ec.mallsy.domain.delivery.delivery.QDelivery> deliveries = this.<org.ec.mallsy.domain.delivery.delivery.Delivery, org.ec.mallsy.domain.delivery.delivery.QDelivery>createList("deliveries", org.ec.mallsy.domain.delivery.delivery.Delivery.class, org.ec.mallsy.domain.delivery.delivery.QDelivery.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

