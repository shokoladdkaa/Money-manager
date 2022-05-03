package me.golovata.currencies.repository;

import me.golovata.currencies.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    Currency findByCurrencyCode(String currencyCode);
}
