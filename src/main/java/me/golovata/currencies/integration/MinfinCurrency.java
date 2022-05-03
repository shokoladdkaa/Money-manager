package me.golovata.currencies.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MinfinCurrency {

    @JsonProperty("r030")
    private Integer currencyNumber;

    @JsonProperty("txt")
    private String currencyFullName;

    @JsonProperty("rate")
    private Double rate;

    @JsonProperty("cc")
    private String currencyCode;
}
