package com.example.currency.controller;

import com.example.currency.entity.Currency;
import com.example.currency.service.CubeService;
import com.example.currency.service.CurrencyService;
import com.example.currency.utlis.CurrencyApiXmlReader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/currencies")
public class CurrencyController {
    private final CubeService cubeService;
    private final CurrencyService currencyService;
    private final CurrencyApiXmlReader reader;


    @GetMapping(value = "/")
    public List<Currency> findAllCourse() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping(value = "/{data}")
    public List<Currency> findByDate(@PathVariable(name = "date") String date) {
        LocalDate localDate = reader.getDate(date);

        Integer cubeId = cubeService.findByDate(localDate);
        List<Currency> currencyList = currencyService.findByDate(cubeId);
        return currencyList;
    }

}
