package me.golovata.balance.service;

import lombok.AllArgsConstructor;
import me.golovata.balance.integration.mono.BalanceProvider;
import me.golovata.balance.model.Balance;
import me.golovata.currencies.CurrencyCode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class BalanceService {
    private final BalanceProvider balanceProvider;

    public List<Balance> getBalance(String token) throws IOException, InterruptedException {
        return balanceProvider.getBalance(token);
    }
}
