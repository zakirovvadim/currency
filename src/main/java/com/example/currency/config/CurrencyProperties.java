package com.example.currency.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("currency")
public class CurrencyProperties {
    private String url;
}
