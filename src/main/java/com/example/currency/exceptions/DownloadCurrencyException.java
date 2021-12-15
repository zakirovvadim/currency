package com.example.currency.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DownloadCurrencyException  extends RuntimeException {
    public DownloadCurrencyException(String e) {
        super("The currency did not download " + e);
        log.error("The currency did not download " + e);
    }
}
