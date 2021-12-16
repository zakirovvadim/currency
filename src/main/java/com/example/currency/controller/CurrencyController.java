package com.example.currency.controller;

import com.example.currency.entity.dto.CurrencyDto;
import com.example.currency.service.CurrencyService;
import com.example.currency.utlis.CurrencyApiXmlReader;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(value = "/eur")
    public List<CurrencyDto> findByDate(@RequestParam(name = "date", required = false)
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                        @RequestParam(name = "currency", required = false) String currency) {

        return currencyService.findEurCurrencies(date, currency);
    }

}
