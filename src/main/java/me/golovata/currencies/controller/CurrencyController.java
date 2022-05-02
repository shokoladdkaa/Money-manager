package me.golovata.currencies.controller;

import lombok.AllArgsConstructor;
import me.golovata.currencies.model.Currency;
import me.golovata.currencies.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/currencies")
    public List<Currency> getAllCurrencies() throws IOException, InterruptedException {
        return currencyService.findAllCurrencies();
    }

    @GetMapping("/currencies/{targetCurrencyId}")
    public Currency getCurrencyById(@PathVariable("targetCurrencyId") int targetCurrencyId) {
        return currencyService.findByTargetCurrencyId(targetCurrencyId);
    }
}
