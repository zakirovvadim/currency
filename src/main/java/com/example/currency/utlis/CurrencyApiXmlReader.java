package com.example.currency.utlis;

import com.example.currency.config.CurrencyProperties;
import com.example.currency.entity.Cube;
import com.example.currency.entity.Currency;
import com.example.currency.exceptions.DownloadCurrencyException;
import com.example.currency.service.CubeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyApiXmlReader {

    private final CubeService cubeService;

    @Autowired
    private Cube cube;

    private LocalDate localDate;
    @Autowired
    private List<Currency> currencyList;
    @Autowired
    private Currency cur;



    public boolean getCurrencies(String url) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);

            NodeList nodeList = doc.getElementsByTagName("Cube");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String date = element.getAttribute("time");
                    if (!date.equals("")) {
                        String dateCheck = date.replace("\'", "");
                        localDate = getDate(dateCheck);
                    }
                    String currency = element.getAttribute("currency");
                    String stringRate = element.getAttribute("rate");
                    if (!currency.equals("") && !stringRate.equals("")) {
                        Double rate = Double.parseDouble(element.getAttribute("rate"));
                        cur.setCurrencies(currency);
                        cur.setRate(rate);
                        currencyList.add(cur);
                    }
                }
            }
            cube.setTime(localDate);
            cube.setCurrencies(currencyList);
            cubeService.saveCube(cube);

            return true;

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new DownloadCurrencyException(e.getMessage());
        }
    }

    public LocalDate getDate(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date= LocalDate.parse(time, formatter);
        return date;
    }
}
