package me.golovata.balance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.golovata.balance.integration.mono.CardType;
import me.golovata.currencies.CurrencyCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Balance {
    private CardType cardType;
    private Integer balance;
    private CurrencyCode currencyCode;
}
