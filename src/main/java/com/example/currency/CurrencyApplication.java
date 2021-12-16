package com.example.currency;

import com.example.currency.config.CurrencyProperties;
import com.example.currency.utlis.CurrencyApiXmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CurrencyProperties.class)
public class CurrencyApplication {

    @Autowired
    private CurrencyApiXmlReader xmlReader;

    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
    }

}
