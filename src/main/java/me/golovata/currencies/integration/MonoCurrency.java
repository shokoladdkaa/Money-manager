package me.golovata.currencies.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class MonoCurrency {

    @JsonProperty("currencyCodeA")
    private Integer targetCurrency;

    @JsonProperty("currencyCodeB")
    private Integer baseCurrency;

    @JsonProperty("date")
    private Timestamp date;

    @JsonProperty("rateBuy")
    private Double rateBuy;

    @JsonProperty("rateSell")
    private Double rateSell;

    @JsonProperty("rateCross")
    private Double rateCross;
}
