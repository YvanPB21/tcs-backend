package com.example.tata.database.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "exchange_rate")
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "origin_currency")
    private CurrencyEntity originCurrency;

    @ManyToOne
    @JoinColumn(name = "destination_currency")
    private CurrencyEntity destinationCurrency;

    private Double rate;

    public CurrencyEntity getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(CurrencyEntity originCurrency) {
        this.originCurrency = originCurrency;
    }

    public CurrencyEntity getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(CurrencyEntity destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
