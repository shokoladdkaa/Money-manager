package me.golovata.currencies;

import java.util.Arrays;

public enum CurrencyCode {
    UAH(980),
    USD(840),
    EUR(978);

    private final int code;

    CurrencyCode(int code) {
        this.code = code;
    }

    public static CurrencyCode getCurrencyCode(int code) {
        return Arrays.stream(CurrencyCode.values()).filter(currencyCode -> currencyCode.code == code)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Currency code not found"));
    }
}
