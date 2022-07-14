package org.ec.mallsy.domain.Item.service.impl;

import lombok.RequiredArgsConstructor;
import org.ec.mallsy.domain.Item.dto.request.ItemPostReq;
import org.ec.mallsy.domain.Item.dto.response.ItemGetRes;
import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.Item.predicate.ItemClassPredicate;
import org.ec.mallsy.domain.Item.repository.ItemRepository;
import org.ec.mallsy.domain.Item.service.ItemService;
import org.ec.mallsy.domain.Item.util.converter.ItemEntityConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@ExtendWith(MockitoExtension.class)
@Transactional
class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl itemService;
    @Mock
    private ItemRepository itemRepository;

    private Item createItem(Long id, String largeClass, String mediumClass, String smallClass) {
        Long sellerId = Long.MAX_VALUE;
        Long partNumber = Long.MAX_VALUE;
        String title = "title";
        String brand =  "brand";
        Long price = Long.MAX_VALUE;
        String content = "012345678901234567890123456789";
        Map<String, Integer> stocks = new HashMap<>();
        stocks.put("M", Integer.MAX_VALUE);
        stocks.put("L", Integer.MAX_VALUE);
        stocks.put("XL", Integer.MAX_VALUE);

        return new Item(id, sellerId, partNumber,
                title, brand, price, content,
                largeClass, mediumClass, smallClass, stocks);
    }

    @Test
    void getSummarizeItemsAsPage() {
        List<Item> items = new ArrayList<>();

        Long cnt = 0L;
        for (int l = 0; l < 5; l++)
            for (int m = 0; m < 20; m++)
                for (int s = 0; s < 50; s++)
                    items.add(createItem(cnt++, Integer.toString(l), Integer.toString(m), Integer.toString(s)));


    }

    @Test
    void getItemById() {
        Item item = createItem(0L, "l", "m", "s");
        when(itemRepository.findById(0L)).thenReturn(Optional.of(item));
        when(itemRepository.save(item)).thenReturn(item);

        ItemGetRes itemGetRes = itemService.getItemById(0L);

        assertEquals("message", "title", itemGetRes.getTitle());
    }

    @Test
    void deleteItemById() {
    }

    @Test
    void putItem() {
    }

    @Test
    void postItem() {
    }
}