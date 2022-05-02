package me.golovata.currencies.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.golovata.currencies.model.Currency;
import me.golovata.currencies.integration.CurrencyRateProvider;
import me.golovata.currencies.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyRateProvider currencyRateProvider;

    @PostConstruct
    protected void prepareCurrencies() throws IOException, InterruptedException {
        log.info("Prepare currencies");
        List<Currency> infoAboutCurrencyRates = currencyRateProvider.getCurrencyInfo();
        log.info("Got {} currencies!", infoAboutCurrencyRates.size());

        log.info("Try to save all currencies to DB");
        currencyRepository.saveAll(infoAboutCurrencyRates);
        log.info("All currencies prepared!");
    }

    public List<Currency> findAllCurrencies() throws InterruptedException {
        return currencyRepository.findAll();
    }

    public Currency findByTargetCurrencyId(int code) {
        return currencyRepository.findByTargetCurrency(code);
    }

}
