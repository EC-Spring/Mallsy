package org.ec.mallsy.domain.Item.service.impl;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.ec.mallsy.domain.Item.dto.request.ItemGetByClassReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPostReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPutReq;
import org.ec.mallsy.domain.Item.dto.response.ItemGetRes;
import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.Item.predicate.ItemClassPredicate;
import org.ec.mallsy.domain.Item.repository.ItemRepository;
import org.ec.mallsy.domain.Item.service.ItemService;
import org.ec.mallsy.domain.Item.util.converter.ItemEntityConverter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;


@ExtendWith(MockitoExtension.class)
@Transactional
class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl itemService;
    @Mock
    private ItemRepository itemRepository;

    private static Map<Long, Item> virtualDB;

    private static Item createItem(Long id, String largeClass, String mediumClass, String smallClass) {
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

    @BeforeAll
    static void setUp() {
        virtualDB = new HashMap<>();

        Long id = 0L;
        for (int l = 0; l < 5; l++)
            for (int m = 0; m < 20; m++)
                for (int s = 0; s < 50; s++) {
                    virtualDB.put(id, createItem(id, Integer.toString(l), Integer.toString(m), Integer.toString(s)));
                    id++;
                }
    }

    @Test
    void getSummarizeItemsAsPage() {
//        when(itemRepository.findAll(ItemClassPredicate.search(any(ItemGetByClassReq.class)), any(Pageable.class)))
//                .thenAnswer(invocation -> {
//                    return getSelectedItems(finalItemGetByClassReq);
//                });

        ItemGetByClassReq itemGetByClassReq = new ItemGetByClassReq("0", null, null);

        ItemGetByClassReq finalItemGetByClassReq = itemGetByClassReq;
        when(itemRepository.findAll(any(Predicate.class), any(Pageable.class)))
                .thenAnswer(invocation -> {
                    return getSelectedItems(finalItemGetByClassReq);
                });

        Pageable pageable = PageRequest.of(0, 5000);

        assertEquals("message", itemService.getSummarizeItemsAsPage(pageable, itemGetByClassReq).size(), 1000);
    }

    private Page<Item> getSelectedItems(ItemGetByClassReq itemGetByClassReq) {
        List<Item> items = new ArrayList<>();

        for (Item item : virtualDB.values()) {
            String largeValue = item.getLargeClass();
            String mediumValue = item.getMediumClass();
            String smallValue = item.getSmallClass();

            String largeCmp = itemGetByClassReq.getLargeClass();
            String mediumCmp = itemGetByClassReq.getMediumClass();
            String smallCmp = itemGetByClassReq.getSmallClass();

            if (largeCmp != null && !largeValue.equals(largeCmp))
                continue;
            if (mediumCmp != null && !mediumValue.equals(mediumCmp))
                continue;
            if (smallCmp != null && !smallValue.equals(smallCmp))
                continue;

            items.add(item);
        }

        return new PageImpl<>(items);
    }

    @Test
    void getItemById() {
        when(itemRepository.findById(anyLong()))
                .thenAnswer((invocation) -> {
                    Long id = invocation.getArgument(0, Long.class);
                    return Optional.of(virtualDB.get(id));
                });

        when(itemRepository.save(any(Item.class))).thenAnswer(invocation -> {
            Item item = invocation.getArgument(0, Item.class);
            return item;
        });

        ItemGetRes itemGetRes = itemService.getItemById(0L);
        assertEquals("message", "title", itemGetRes.getTitle());
    }

    @Test
    void deleteItemById() {
        when(itemRepository.existsById(anyLong())).thenAnswer(invocation -> {
            Long id = invocation.getArgument(0, Long.class);
            return virtualDB.containsKey(id);
        });

        doAnswer(invocation -> {
            Long id = invocation.getArgument(0, Long.class);
            virtualDB.remove(id);
            return null;
        }).when(itemRepository).deleteById(anyLong());

        itemService.deleteItemById(1L);
        assertTrue("message", !itemRepository.existsById(1L));
    }

    @Test
    void putItem() {
        when(itemRepository.findById(anyLong()))
                .thenAnswer((invocation) -> {
                    Long id = invocation.getArgument(0, Long.class);
                    return Optional.of(virtualDB.get(id));
                });

        ItemPutReq itemPutReq = ItemPutReq.builder()
                .id(2L)
                .title("title111")
                .build();
        itemService.putItem(itemPutReq);

        Optional<Item> item = itemRepository.findById(2L);

        assertEquals("message", item.get().getTitle(), "title111");
    }

    @Test
    void postItem() {
        when(itemRepository.existsById(anyLong())).thenAnswer(invocation -> {
            Long id = invocation.getArgument(0, Long.class);
            return virtualDB.containsKey(id);
        });

        when(itemRepository.save(any(Item.class)))
                .thenAnswer(invocation -> {
                    Item item = invocation.getArgument(0, Item.class);
                    item.setId(101L);
                    virtualDB.put(101L, item);
                    return item;
                });

        Long sellerId = Long.MAX_VALUE;
        Long partNumber = Long.MAX_VALUE;
        String title = "title232";
        String brand =  "brand";
        Long price = Long.MAX_VALUE;
        String content = "012345678901234567890123456789";
        String largeClass = "l";
        String mediumClass = "m";
        String smallClass = "s";
        Map<String, Integer> stocks = new HashMap<>();
        stocks.put("M", Integer.MAX_VALUE);
        stocks.put("L", Integer.MAX_VALUE);
        stocks.put("XL", Integer.MAX_VALUE);

        ItemPostReq itemPostReq = new ItemPostReq(sellerId, partNumber, title, brand, price, content, largeClass, mediumClass, smallClass, stocks);
        Long id = itemService.postItem(itemPostReq);
        assertTrue("message", itemRepository.existsById(id));
    }
}