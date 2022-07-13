package org.ec.mallsy.domain.Item.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.ec.mallsy.domain.Item.dto.request.ItemGetByClassReq;
import org.ec.mallsy.domain.Item.entity.QItem;

public class ItemClassPredicate {
    public static Predicate search(ItemGetByClassReq itemGetByClassReq) {
        QItem qItem = QItem.item;

        String largeClass = itemGetByClassReq.getLargeClass();
        String mediumClass = itemGetByClassReq.getMediumClass();
        String smallClass = itemGetByClassReq.getSmallClass();

        BooleanBuilder builder = new BooleanBuilder();
        if (!largeClass.equals("")) {
            builder.and(qItem.largeClass.eq(largeClass));
        }
        if (!mediumClass.equals("")) {
            builder.and(qItem.mediumClass.eq(mediumClass));
        }
        if (!smallClass.equals("")) {
            builder.and(qItem.smallClass.eq(smallClass));
        }

        return builder;
    }
}
