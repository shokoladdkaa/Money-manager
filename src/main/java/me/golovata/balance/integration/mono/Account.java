package me.golovata.balance.integration.mono;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Account {
    private String id;
    private String sendId;
    private Integer currencyCode;
    private CashbackType cashbackType;
    private Integer balance;
    private Integer creditLimit;
    private List<String> maskedPan;
    private CardType type;
    private String iban;
}
