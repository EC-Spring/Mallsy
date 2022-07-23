package org.ec.mallsy.domain.Item.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.ec.mallsy.domain.Item.dto.request.ItemGetByClassReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPostReq;
import org.ec.mallsy.domain.Item.dto.request.ItemPutReq;
import org.ec.mallsy.domain.Item.dto.response.ItemGetRes;
import org.ec.mallsy.domain.Item.entity.Item;
import org.ec.mallsy.domain.Item.service.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ItemControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ItemController itemController;

    @MockBean
    private ItemService itemService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(itemController)
                .setCustomArgumentResolvers(
                        new PageableHandlerMethodArgumentResolver()
                )
                .build();
    }

    @Test
    void getSummarizedItemsByClassAsPage() throws Exception {

        // when
        when(itemService.getSummarizeItemsAsPage(any(), any())).thenReturn(new ArrayList<>());

        // then
        mockMvc.perform(get("/item/page")
                .param("largeClass", "l")
        ).andExpect(status().is(200));
    }

    @Test
    void getItemById() throws Exception {
        // given
        ItemGetRes itemGetRes = ItemGetRes.builder()
                .id(1L)
                .sellerId(1L)
                .partNumber(1L)
                .title("title")
                .brand("brand")
                .views(123L)
                .price(123L)
                .content("0123456789012345678901234567890123456789")
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .largeClass("l")
                .mediumClass("m")
                .smallClass("s")
                .stocks(new HashMap<>())
                .build();

        // when
        when(itemService.getItemById(any()))
                .thenReturn(itemGetRes);

        // then
        mockMvc.perform(get("/item/1"))
                .andExpect(status().is(200));
    }

    @Test
    void postItem() throws Exception {
        // given
        ItemPostReq itemPostReq = ItemPostReq.builder()
                .sellerId(1L)
                .brand("brand")
                .content("0123456789012345678901234567890123456789")
                .largeClass("l")
                .mediumClass("m")
                .partNumber(1L)
                .price(1L)
                .smallClass("s")
                .stocks(new HashMap<>())
                .title("title")
                .build();

        // when
        when(itemService.postItem(any()))
                .thenReturn(1L);

        // then
        mockMvc.perform(post("/item")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(itemPostReq))
        ).andExpect(status().is(200));
    }

    @Test
    void putItem() throws Exception {
        // given
        ItemPutReq itemPutReq = ItemPutReq.builder()
                .id(1L)
                .title("putTitle")
                .price(12345L)
                .build();

        // when
        when(itemService.putItem(any()))
                .thenReturn(1L);

        // then
        mockMvc.perform(put("/item")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(itemPutReq))
        ).andExpect(status().is(200));
    }

    @Test
    void deleteItem() throws Exception {
        // when
        doNothing().when(itemService).deleteItemById(any());

        // then
        mockMvc.perform(delete("/item/1")
        ).andExpect(status().is(200));
    }
}