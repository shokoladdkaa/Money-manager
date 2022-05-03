package me.golovata.currencies.controller;

import lombok.AllArgsConstructor;
import me.golovata.currencies.model.Currency;
import me.golovata.currencies.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/currencies")
    public List<Currency> getAllCurrencies() {
        return currencyService.findAllCurrencies();
    }

    @GetMapping("/currencies/{currencyCode}")
    public Currency getCurrencyByCurrencyCode(@PathVariable("currencyCode") String currencyCode) {
        return currencyService.findByCurrencyCode(currencyCode);
    }
}
