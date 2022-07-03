package org.ec.mallsy.domain.Item.controller;

import lombok.RequiredArgsConstructor;
import org.ec.mallsy.domain.Item.dto.request.ItemGetByClassReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPostReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPutReq;
import org.ec.mallsy.domain.Item.dto.response.ItemGetRes;
import org.ec.mallsy.domain.Item.dto.response.SummarizedItemGetRes;
import org.ec.mallsy.domain.Item.service.ItemService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/page")
    public ResponseEntity getSummarizedItemsByClassAsPage(@PageableDefault() Pageable pageable, ItemGetByClassReq itemGetByClassReq) {
        List<SummarizedItemGetRes> summarizedItemGetResList = itemService.getSummarizeItemsAsPage(pageable, itemGetByClassReq);
        return ResponseEntity.ok(summarizedItemGetResList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getItemById(@PathVariable Long id) {
        ItemGetRes itemGetRes = itemService.getItemById(id);
        return ResponseEntity.ok(itemGetRes);
    }

    @PostMapping()
    public ResponseEntity postItem(@RequestBody ItemPostReq itemPostReq) {
        Long id = itemService.postItem(itemPostReq);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity putItem(@RequestBody ItemPutReq itemPutReq) {
        Long id = itemService.putItem(itemPutReq);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok("");
    }

}
