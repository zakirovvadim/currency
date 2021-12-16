package com.example.currency.utlis;

import com.example.currency.entity.Currency;
import com.example.currency.exceptions.DownloadCurrencyException;
import com.example.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyApiXmlReader {

    private final CurrencyService currencyService;

    private List<Currency> currencyList = new ArrayList<>();

    public void parseCurrency(String url) {
        Document document = getCurrencyByUrl(url);
        List<Currency> currencyList = parseCurrency(document).stream().filter(t -> switch(t.getCurrency()) {
            case "USD", "RUB", "JPY" -> true;
            default -> false;
        }).collect(Collectors.toList());
        saveCurrencyToDb(currencyList);

    }

    private Document getCurrencyByUrl(String url) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document doc = null;
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(url);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new DownloadCurrencyException(e.getMessage());
        }
        return doc;
    }


    public List<Currency> parseCurrency(Document doc) {
        LocalDate localDate = LocalDate.now();

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
                if (currency != null && !currency.equals("") && !stringRate.equals("")) {
                    Double rate = Double.parseDouble(element.getAttribute("rate"));
                    Currency cur = new Currency();
                    cur.setCurrency(currency);
                    cur.setRate(rate);
                    cur.setDate(localDate);
                    currencyList.add(cur);
                }
            }
        }
        return currencyList;
    }

    public LocalDate getDate(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(time, formatter);
        return date;
    }

    public void saveCurrencyToDb(List<Currency> listCur) {
        currencyService.save(currencyList);
    }
}
