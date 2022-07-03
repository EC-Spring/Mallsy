package org.ec.mallsy.domain.coupon.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCoupon is a Querydsl query type for Coupon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCoupon extends EntityPathBase<Coupon> {

    private static final long serialVersionUID = 314656549L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCoupon coupon = new QCoupon("coupon");

    public final NumberPath<Long> atLeastBuy = createNumber("atLeastBuy", Long.class);

    public final NumberPath<Long> beginDate = createNumber("beginDate", Long.class);

    public final NumberPath<Long> discount = createNumber("discount", Long.class);

    public final NumberPath<Long> expiryDate = createNumber("expiryDate", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final MapPath<String, String, StringPath> restrictions = this.<String, String, StringPath>createMap("restrictions", String.class, String.class, StringPath.class);

    public final StringPath type = createString("type");

    public final org.ec.mallsy.domain.user.entity.QUser user;

    public QCoupon(String variable) {
        this(Coupon.class, forVariable(variable), INITS);
    }

    public QCoupon(Path<? extends Coupon> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCoupon(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCoupon(PathMetadata metadata, PathInits inits) {
        this(Coupon.class, metadata, inits);
    }

    public QCoupon(Class<? extends Coupon> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new org.ec.mallsy.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

