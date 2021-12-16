package com.example.currency.service;

import com.example.currency.entity.Currency;
import com.example.currency.entity.dto.CurrencyDto;
import com.example.currency.exceptions.NoEntityExceptions;
import com.example.currency.mapper.CurrencyMaper;
import com.example.currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository repository;
    private final CurrencyMaper mapper;

    public void save(List<Currency> currencyList) {
        repository.saveAll(currencyList);
    }

    public List<CurrencyDto> findEurCurrencies(LocalDate date, String currency) {
        validateRequest(date, currency);
        return mapper.map(repository.findAll(where(hasCurrency(currency)).and(hasDate(date))));
    }

    private void validateRequest(LocalDate date, String currency) {
        if (date == null && currency == null) {
            throw new NoEntityExceptions(currency);
        }
    }

    static Specification<Currency> hasCurrency(String currency) {
        return (currencyRoot, cq, cb) -> {
            if (currency == null) {
                return cb.conjunction();
            }
            return cb.equal(currencyRoot.get("currency"), currency);
        };
    }

    static Specification<Currency> hasDate(LocalDate date) {
        return (currencyRoot, cq, cb) -> {
            if (date == null) {
                return cb.conjunction();
            }
            return cb.equal(currencyRoot.get("date"), date);
        };
    }
}
