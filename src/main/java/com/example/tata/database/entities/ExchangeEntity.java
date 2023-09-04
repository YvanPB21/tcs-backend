package com.example.tata.database.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "exchange")
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "origin_currency")
    private CurrencyEntity originCurrency;

    @ManyToOne
    @JoinColumn(name = "destination_currency")
    private CurrencyEntity destinationCurrency;

    private Double amount;

    private Double amountWithExchange;

    private String type ;

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
