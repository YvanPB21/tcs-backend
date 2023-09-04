package com.example.tata.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateDto {

    CurrencyDto originCurrency;

    CurrencyDto destinationCurrency;

    Double rate;

    public CurrencyDto getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(CurrencyDto originCurrency) {
        this.originCurrency = originCurrency;
    }

    public CurrencyDto getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(CurrencyDto destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
