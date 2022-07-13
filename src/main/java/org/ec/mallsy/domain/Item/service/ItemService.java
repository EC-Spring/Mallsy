package org.ec.mallsy.domain.Item.service;

import org.ec.mallsy.domain.Item.dto.request.ItemGetByClassReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPostReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPutReq;
import org.ec.mallsy.domain.Item.dto.response.ItemGetRes;
import org.ec.mallsy.domain.Item.dto.response.SummarizedItemGetRes;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {

    List<SummarizedItemGetRes> getSummarizeItemsAsPage(Pageable pageable, ItemGetByClassReq itemGetByClassReq);
    ItemGetRes getItemById(Long id);
    void deleteItemById(Long id);
    Long putItem(ItemPutReq itemPutReq);
    Long postItem(ItemPostReq itemPostReq);
}
