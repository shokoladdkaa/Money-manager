package me.golovata.currencies.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.golovata.currencies.model.Currency;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyRateProvider {
    public List<Currency> getCurrencyInfo() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(
                        URI.create(String.format("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date="+  getCurrentDate() + "&json")))
                .header("accept", "application/json")
                .GET()
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<MinfinCurrency> currencyResponses = objectMapper.readValue(response.body(),
                new TypeReference<List<MinfinCurrency>>(){});

        return currencyResponses.stream()
                .map(currency -> Currency.builder()
                        .currencyNumber(currency.getCurrencyNumber())
                        .currencyFullName(currency.getCurrencyFullName())
                        .rate(currency.getRate())
                        .currencyCode(currency.getCurrencyCode())
                        .build())
                .collect(Collectors.toList());
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
