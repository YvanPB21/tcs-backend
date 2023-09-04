package com.example.tata.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CreateExchangeRateRequest {
    String originCurrencyCode;
    String destinationCurrencyCode;
    Double rate;

    public String getOriginCurrencyCode() {
        return originCurrencyCode;
    }

    public void setOriginCurrencyCode(String originCurrencyCode) {
        this.originCurrencyCode = originCurrencyCode;
    }

    public String getDestinationCurrencyCode() {
        return destinationCurrencyCode;
    }

    public void setDestinationCurrencyCode(String destinationCurrencyCode) {
        this.destinationCurrencyCode = destinationCurrencyCode;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CreateExchangeRateRequest{" +
                "originCurrencyCode='" + originCurrencyCode + '\'' +
                ", destinationCurrencyCode='" + destinationCurrencyCode + '\'' +
                ", rate=" + rate +
                '}';
    }
}
