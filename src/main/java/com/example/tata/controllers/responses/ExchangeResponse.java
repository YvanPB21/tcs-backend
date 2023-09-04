package com.example.tata.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResponse {

    String originCurrencyCode;

    String destinationCurrencyCode;

    Double amount;

    Double amountWithExchange;

    String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
