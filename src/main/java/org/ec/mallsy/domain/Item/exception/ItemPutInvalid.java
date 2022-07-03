package org.ec.mallsy.domain.Item.exception;

public class ItemPutInvalid extends RuntimeException {

    public ItemPutInvalid() {
        super("Item Put parameter is invalid");
    }
}
