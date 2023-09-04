package com.example.tata.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRequest {

    String originCurrencyCode;
    String destinationCurrencyCode;
    Double amount;
    Double amountWithExchange;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmountWithExchange() {
        return amountWithExchange;
    }

    public void setAmountWithExchange(Double amountWithExchange) {
        this.amountWithExchange = amountWithExchange;
    }

    @Override
    public String toString() {
        return "ExchangeRequest{" +
                "originCurrencyCode='" + originCurrencyCode + '\'' +
                ", destinationCurrencyCode='" + destinationCurrencyCode + '\'' +
                ", amount=" + amount +
                ", amountWithExchange=" + amountWithExchange +
                '}';
    }
}
