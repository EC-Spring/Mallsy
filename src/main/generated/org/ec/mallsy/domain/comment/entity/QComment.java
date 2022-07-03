package org.ec.mallsy.domain.comment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -576420385L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<org.ec.mallsy.domain.Image.entity.Image, org.ec.mallsy.domain.Image.entity.QImage> images = this.<org.ec.mallsy.domain.Image.entity.Image, org.ec.mallsy.domain.Image.entity.QImage>createList("images", org.ec.mallsy.domain.Image.entity.Image.class, org.ec.mallsy.domain.Image.entity.QImage.class, PathInits.DIRECT2);

    public final org.ec.mallsy.domain.Item.entity.QItem item;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new org.ec.mallsy.domain.Item.entity.QItem(forProperty("item"), inits.get("item")) : null;
    }

}

