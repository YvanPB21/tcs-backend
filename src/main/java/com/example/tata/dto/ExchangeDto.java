package com.example.tata.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto {

    CurrencyDto originCurrency;

    CurrencyDto destinationCurrency;

    Double amount;

    Double amountWithExchange;

    String type;

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
