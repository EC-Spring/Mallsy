package org.ec.mallsy.domain.Item.exception;

public class ItemNotFoundExceotion extends RuntimeException{

    public ItemNotFoundExceotion(Long id) {
        super("Item is not found: " + id);
    }
}
