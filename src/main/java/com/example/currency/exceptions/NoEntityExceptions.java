package com.example.currency.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoEntityExceptions extends RuntimeException{
    public NoEntityExceptions(String identificator) {
        super("The attribute with identificator:" + identificator + " is not exist");
        log.error("The attribute with identificator:" + identificator + " is not exist");
    }
}
