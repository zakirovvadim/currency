package com.example.currency.service;

import com.example.currency.entity.Currency;
import com.example.currency.exceptions.NoEntityExceptions;
import com.example.currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository repository;

    public List<Currency> getAllCurrencies() {
        return repository.findAll();
    }


    public List<Currency> findByDate(Integer id) {
        return repository.findCurrencyByDate(id).orElseThrow(() -> new NoEntityExceptions(id.toString()));
    }
}
