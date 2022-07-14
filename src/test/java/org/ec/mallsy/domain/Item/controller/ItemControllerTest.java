package org.ec.mallsy.domain.Item.controller;

import org.ec.mallsy.domain.Item.service.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getSummarizedItemsByClassAsPage() {
    }

    @Test
    void getItemById() {
    }

    @Test
    void postItem() {
    }

    @Test
    void putItem() {
    }

    @Test
    void deleteItem() {
    }
}