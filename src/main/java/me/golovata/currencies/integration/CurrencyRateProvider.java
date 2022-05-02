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
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyRateProvider {
    public static final String URL_CLIENT_INFO = "https://api.monobank.ua/bank/currency";

    public List<Currency> getCurrencyInfo() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(
                        URI.create(URL_CLIENT_INFO))
                .header("accept", "application/json")
                .GET()
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<MonoCurrency> currencyResponses = objectMapper.readValue(response.body(),
                new TypeReference<List<MonoCurrency>>(){});

        return currencyResponses.stream()
                .map(currency -> Currency.builder()
                        .baseCurrency(currency.getBaseCurrency())
                        .targetCurrency(currency.getTargetCurrency())
                        .rateSell(currency.getRateSell())
                        .rateBuy(currency.getRateBuy())
                        .rateCross(currency.getRateCross())
                        .build())
                .collect(Collectors.toList());
    }
}
