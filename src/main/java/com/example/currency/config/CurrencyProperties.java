package com.example.currency.config;

import com.example.currency.entity.Currency;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Data
@ConfigurationProperties("currency")
public class CurrencyProperties {
    private String url;

}
