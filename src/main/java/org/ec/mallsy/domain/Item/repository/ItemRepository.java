package org.ec.mallsy.domain.Item.repository;

import org.ec.mallsy.domain.Item.entity.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
