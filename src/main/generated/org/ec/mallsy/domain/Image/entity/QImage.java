package org.ec.mallsy.domain.Image.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImage extends EntityPathBase<Image> {

    private static final long serialVersionUID = 1564162687L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImage image = new QImage("image");

    public final org.ec.mallsy.domain.cart.entity.QCart cart;

    public final org.ec.mallsy.domain.comment.entity.QComment comment;

    public final org.ec.mallsy.domain.delivery.delivery.QDelivery delivery;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.ec.mallsy.domain.Item.entity.QItem item;

    public final StringPath url = createString("url");

    public QImage(String variable) {
        this(Image.class, forVariable(variable), INITS);
    }

    public QImage(Path<? extends Image> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImage(PathMetadata metadata, PathInits inits) {
        this(Image.class, metadata, inits);
    }

    public QImage(Class<? extends Image> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new org.ec.mallsy.domain.cart.entity.QCart(forProperty("cart"), inits.get("cart")) : null;
        this.comment = inits.isInitialized("comment") ? new org.ec.mallsy.domain.comment.entity.QComment(forProperty("comment"), inits.get("comment")) : null;
        this.delivery = inits.isInitialized("delivery") ? new org.ec.mallsy.domain.delivery.delivery.QDelivery(forProperty("delivery"), inits.get("delivery")) : null;
        this.item = inits.isInitialized("item") ? new org.ec.mallsy.domain.Item.entity.QItem(forProperty("item"), inits.get("item")) : null;
    }

}

