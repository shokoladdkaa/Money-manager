package me.golovata.balance.integration.mono;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.golovata.balance.model.Balance;
import me.golovata.currencies.CurrencyCode;
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
public class BalanceProvider {
    public static final String URL_CLIENT_INFO = "https://api.monobank.ua/personal/client-info";

    public List<Balance> getBalance(String token) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(
                        URI.create(URL_CLIENT_INFO))
                .header("X-Token", token)
                .header("accept", "application/json")
                .GET()
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ClientInfo clientInfoAsObject = objectMapper.readValue(response.body(), ClientInfo.class);

        return clientInfoAsObject.getAccounts().stream()
                .map(balance -> Balance.builder()
                        .cardType(balance.getType())
                        .balance(balance.getBalance())
                        .currencyCode(CurrencyCode.getCurrencyCode(balance.getCurrencyCode()))
                        .build())
                .collect(Collectors.toList());
    }
}
