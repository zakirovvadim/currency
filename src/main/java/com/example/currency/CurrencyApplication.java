package com.example.currency;

import com.example.currency.config.CurrencyProperties;
import com.example.currency.entity.Cube;
import com.example.currency.utlis.CurrencyApiXmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties(CurrencyProperties.class)
public class CurrencyApplication {

    @Autowired
    private CurrencyApiXmlReader xmlReader;

    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
    }
//    @Override
//    public void run(String... args) throws IOException, ParserConfigurationException, SAXException, XMLStreamException, JAXBException, SOAPException {
//        Cube cube = xmlReader.getCurrencies();
//        System.out.println(cube.toString());
//    }

}
