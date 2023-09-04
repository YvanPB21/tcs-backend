package com.example.tata.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse {

    CurrencyResponse originCurrency;

    CurrencyResponse destinationCurrency;
    Double rate;

    public CurrencyResponse getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(CurrencyResponse originCurrency) {
        this.originCurrency = originCurrency;
    }

    public CurrencyResponse getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(CurrencyResponse destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
