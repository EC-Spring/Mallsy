package org.ec.mallsy.domain.Item.util.converter;

import org.ec.mallsy.domain.Image.entity.Image;
import org.ec.mallsy.domain.Item.dto.request.ItemPostReq;
import org.ec.mallsy.domain.Item.dto.response.ItemGetRes;
import org.ec.mallsy.domain.Item.dto.response.SummarizedItemGetRes;
import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.comment.entity.Comment;

import java.util.List;
import java.util.Map;

public class ItemEntityConverter {

    public static Item toItem(ItemPostReq itemPostReq) {
        Long sellerId = itemPostReq.getSellerId();
        Long partNumber = itemPostReq.getPartNumber();
        String title = itemPostReq.getTitle();
        String brand = itemPostReq.getBrand();
        Long price = itemPostReq.getPrice();
        String content = itemPostReq.getContent();
        String largeClass = itemPostReq.getLargeClass();
        String mediumClass = itemPostReq.getMediumClass();
        String smallClass = itemPostReq.getSmallClass();
        Map<String, Integer>stocks = itemPostReq.getStocks();

        return new Item(sellerId, partNumber, title, brand, price, content, largeClass, mediumClass, smallClass, stocks);
    }

    public static ItemGetRes toItemGetRes(Item item) {
        Long id = item.getId();
        Long sellerId = item.getSellerId();
        Long partNumber = item.getPartNumber();
        String title = item.getTitle();
        String brand = item.getBrand();
        Long views = item.getViews();
        Long price = item.getPrice();
        String content = item.getContent();
        Long createdAt = item.getCreatedAt();
        Long updatedAt = item.getUpdatedAt();
        String largeClass = item.getLargeClass();
        String mediumClass = item.getMediumClass();
        String smallClass = item.getSmallClass();
        List<Image> images = item.getImages();
        List<Comment> comments = item.getComments();
        Map<String, Integer>stocks = item.getStocks();

        return new ItemGetRes(id, sellerId, partNumber, title, brand, views, price, content, createdAt, updatedAt, largeClass, mediumClass, smallClass, images, comments, stocks);
    }

    public static SummarizedItemGetRes toSummarizedItemGetRes(Item item) {
        Long id = item.getId();
        Long sellerId = item.getSellerId();
        Long partNumber = item.getPartNumber();
        String title = item.getTitle();
        String brand = item.getBrand();
        Long views = item.getViews();
        Long price = item.getPrice();
        Long createdAt = item.getCreatedAt();
        Long updatedAt = item.getUpdatedAt();
        String largeClass = item.getLargeClass();
        String mediumClass = item.getMediumClass();
        String smallClass = item.getSmallClass();
        Map<String, Integer>stocks = item.getStocks();

        return new SummarizedItemGetRes(id, sellerId, partNumber, title, brand, views, price, createdAt, updatedAt, largeClass, mediumClass, smallClass, stocks);
    }
}
