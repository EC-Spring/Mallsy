package org.ec.mallsy.domain.Item.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 689481823L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItem item = new QItem("item");

    public final StringPath brand = createString("brand");

    public final org.ec.mallsy.domain.cart.entity.QCart cart;

    public final ListPath<org.ec.mallsy.domain.comment.entity.Comment, org.ec.mallsy.domain.comment.entity.QComment> comments = this.<org.ec.mallsy.domain.comment.entity.Comment, org.ec.mallsy.domain.comment.entity.QComment>createList("comments", org.ec.mallsy.domain.comment.entity.Comment.class, org.ec.mallsy.domain.comment.entity.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final NumberPath<Long> createdAt = createNumber("createdAt", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<org.ec.mallsy.domain.Image.entity.Image, org.ec.mallsy.domain.Image.entity.QImage> images = this.<org.ec.mallsy.domain.Image.entity.Image, org.ec.mallsy.domain.Image.entity.QImage>createList("images", org.ec.mallsy.domain.Image.entity.Image.class, org.ec.mallsy.domain.Image.entity.QImage.class, PathInits.DIRECT2);

    public final StringPath largeClass = createString("largeClass");

    public final StringPath mediumClass = createString("mediumClass");

    public final NumberPath<Long> partNumber = createNumber("partNumber", Long.class);

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final NumberPath<Long> sellerId = createNumber("sellerId", Long.class);

    public final StringPath smallClass = createString("smallClass");

    public final MapPath<String, Integer, NumberPath<Integer>> stocks = this.<String, Integer, NumberPath<Integer>>createMap("stocks", String.class, Integer.class, NumberPath.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> updatedAt = createNumber("updatedAt", Long.class);

    public final NumberPath<Long> views = createNumber("views", Long.class);

    public QItem(String variable) {
        this(Item.class, forVariable(variable), INITS);
    }

    public QItem(Path<? extends Item> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItem(PathMetadata metadata, PathInits inits) {
        this(Item.class, metadata, inits);
    }

    public QItem(Class<? extends Item> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new org.ec.mallsy.domain.cart.entity.QCart(forProperty("cart"), inits.get("cart")) : null;
    }

}

