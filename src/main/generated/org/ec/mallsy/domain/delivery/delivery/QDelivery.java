package org.ec.mallsy.domain.delivery.delivery;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDelivery is a Querydsl query type for Delivery
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDelivery extends EntityPathBase<Delivery> {

    private static final long serialVersionUID = -993881456L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDelivery delivery = new QDelivery("delivery");

    public final StringPath address = createString("address");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath optional = createString("optional");

    public final NumberPath<Long> orderedAt = createNumber("orderedAt", Long.class);

    public final NumberPath<Long> orderNumber = createNumber("orderNumber", Long.class);

    public final NumberPath<Long> partNumber = createNumber("partNumber", Long.class);

    public final org.ec.mallsy.domain.Image.entity.QImage previewImage;

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final NumberPath<Long> sellerId = createNumber("sellerId", Long.class);

    public final StringPath status = createString("status");

    public final StringPath title = createString("title");

    public final org.ec.mallsy.domain.user.entity.QUser user;

    public QDelivery(String variable) {
        this(Delivery.class, forVariable(variable), INITS);
    }

    public QDelivery(Path<? extends Delivery> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDelivery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDelivery(PathMetadata metadata, PathInits inits) {
        this(Delivery.class, metadata, inits);
    }

    public QDelivery(Class<? extends Delivery> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.previewImage = inits.isInitialized("previewImage") ? new org.ec.mallsy.domain.Image.entity.QImage(forProperty("previewImage"), inits.get("previewImage")) : null;
        this.user = inits.isInitialized("user") ? new org.ec.mallsy.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

