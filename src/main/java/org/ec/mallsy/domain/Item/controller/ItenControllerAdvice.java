package org.ec.mallsy.domain.Item.controller;

import org.ec.mallsy.domain.Item.exception.ItemNotFoundExceotion;
import org.ec.mallsy.domain.Item.exception.ItemPostInvalid;
import org.ec.mallsy.domain.Item.exception.ItemPutInvalid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItenControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ItemNotFoundExceotion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundException(ItemNotFoundExceotion e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ItemPostInvalid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String itemPostInvalid(ItemPostInvalid e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ItemPutInvalid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String itemPutInvalid(ItemPostInvalid e) {
        return e.getMessage();
    }
}
