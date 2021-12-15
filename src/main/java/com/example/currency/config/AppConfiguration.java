package com.example.currency.config;

import com.example.currency.utlis.CurrencyApiXmlReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.URL;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class AppConfiguration {

    private final CurrencyApiXmlReader xmlReader;
    private final CurrencyProperties properties;

    @Scheduled(fixedRate = 30, timeUnit = TimeUnit.MINUTES)
    public void downloadInfo() {
        String url = properties.getUrl();
        boolean check = xmlReader.getCurrencies(url);
        if(check == true) {
            log.info("The xml of currenccies was loaded");
        }
    }
}
