package org.ec.mallsy.domain.Item.service.impl;

import lombok.RequiredArgsConstructor;
import org.ec.mallsy.domain.Item.dto.request.ItemGetByClassReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPostReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPutReq;
import org.ec.mallsy.domain.Item.dto.response.ItemGetRes;
import org.ec.mallsy.domain.Item.dto.response.SummarizedItemGetRes;
import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.Item.exception.ItemNotFoundExceotion;
import org.ec.mallsy.domain.Item.predicate.ItemClassPredicate;
import org.ec.mallsy.domain.Item.repository.ItemRepository;
import org.ec.mallsy.domain.Item.service.ItemService;
import org.ec.mallsy.domain.Item.util.converter.ItemEntityConverter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

//    @Override
//    public List<SummarizedItemGetRes> getSummarizeItemsAsPage(Pageable pageable, ItemGetByClassReq itemGetByClassReq) {
//        Iterable<Item> items = itemRepository.findAll(ItemClassPredicate.search(itemGetByClassReq), pageable);
//        List<SummarizedItemGetRes> itemsRes = new ArrayList<>();
//        for (Item item : items)
//                itemsRes.add(ItemEntityConverter.toSummarizedItemGetRes(item));
//        return itemsRes;
//    }

    @Override
    public ItemGetRes getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundExceotion(id));
        item.increaseViews();
        return ItemEntityConverter.toItemGetRes(itemRepository.save(item));
    }

    @Override
    public void deleteItemById(Long id) {
        if (itemRepository.existsById(id))
            itemRepository.deleteById(id);
        else throw new ItemNotFoundExceotion(id);
    }

//    @Override
//    @Transactional
//    public Long putItem(ItemPutReq itemPutReq) {
//        Long id = itemPutReq.getId();
//        Item item = itemRepository.findById(id)
//                .orElseThrow(() -> new ItemNotFoundExceotion(id));
//
//        String title = itemPutReq.getTitle();
//        String brand = itemPutReq.getBrand();
//        Long price = itemPutReq.getPrice();
//        String content = itemPutReq.getContent();
//        String largeClass = itemPutReq.getLargeClass();
//        String mediumClass = itemPutReq.getMediumClass();
//        String smallClass = itemPutReq.getSmallClass();
//        Map<String, Integer> stocks = itemPutReq.getStocks();
//
//        if (title != null) item.setTitle(title);
//        if (brand != null) item.setBrand(brand);
//        if (price != null) item.setPrice(price);
//        if (content != null) item.setContent(content);
//        if (largeClass != null) item.setLargeClass(largeClass);
//        if (mediumClass != null) item.setMediumClass(mediumClass);
//        if (smallClass != null) item.setSmallClass(smallClass);
//        if (stocks != null) item.setStocks(stocks);
//
//        return id;
//    }

    @Override
    public Long postItem(ItemPostReq itemPostReq) {
        Item item = ItemEntityConverter.toItem(itemPostReq);
        return itemRepository.save(item).getId();
    }
}
