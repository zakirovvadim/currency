package com.example.currency;

import com.example.currency.entity.dto.CurrencyDto;
import com.example.currency.repository.CurrencyRepository;
import com.example.currency.utlis.CurrencyApiXmlReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SenderApplicationTests {
//
//    public static final String API_CURRENCY = "api/currencies/";
//
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private CurrencyRepository repository;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @AfterEach
//    public void resetDb() {
//        repository.deleteAll();
//    }
//


    @Test
    void getCurrency_thenReturnCurency() throws Exception {
//        mockMvc.perform(post(API_CURRENCY)
//                        .content(objectMapper.writeValueAsString(prepareCur()))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
    }
//
//    private CurrencyDto prepareCur() {
//        CurrencyDto currencyDto = new CurrencyDto();
//        currencyDto.setId(1);
//        currencyDto.setCurrencies("USD");
//        currencyDto.setRate(1.521);
//        return currencyDto;
//    }

}
