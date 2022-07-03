package org.ec.mallsy.domain.Item.exception;

public class ItemPostInvalid extends RuntimeException {

    public  ItemPostInvalid() {
        super("Item Post parameter is invalid");
    }
}
