package com.example.currency.mapper;

import com.example.currency.entity.Currency;
import com.example.currency.entity.dto.CurrencyDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface CurrencyMaper {
    List<CurrencyDto> map(List<Currency> course);

    CurrencyDto map(Currency course);

    Currency map(CurrencyDto dto);
}
