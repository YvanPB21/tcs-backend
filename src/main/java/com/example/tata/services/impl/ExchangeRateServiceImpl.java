package com.example.tata.services.impl;

import com.example.tata.database.entities.ExchangeRateEntity;
import com.example.tata.database.repositories.ExchangeRateRepository;
import com.example.tata.dto.CurrencyDto;
import com.example.tata.dto.ExchangeRateDto;
import com.example.tata.dto.mappers.AbstractExchangeRateDtoMapper;
import com.example.tata.exception.CustomException;
import com.example.tata.services.CurrencyService;
import com.example.tata.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private AbstractExchangeRateDtoMapper exchangeRateDtoMapper;

    @Autowired
    private CurrencyService currencyService;

    @Override
    @Transactional
    public void addOrUpdateExchangeRate(ExchangeRateDto dto) throws CustomException {
        validateCurrencies(dto.getOriginCurrency().getCode(), dto.getDestinationCurrency().getCode());
        ExchangeRateEntity exchangeRate = exchangeRateRepository.findOptionalExchangeRateByCurrencyCodes(
                        dto.getOriginCurrency().getCode(), dto.getDestinationCurrency().getCode())
                .orElse(null);
        if (exchangeRate != null) { //update
            exchangeRate.setRate(dto.getRate());
            exchangeRateRepository.save(exchangeRate);
        } else { //create
            exchangeRateRepository.save(exchangeRateDtoMapper.fromDtoToEntity(dto));
        }
    }

    private void validateCurrencies(String origin, String destination) throws CustomException {
        CurrencyDto currencyOrigin = currencyService.findByCode(origin);
        if (currencyOrigin == null)
            throw new CustomException("Origin Currency does not exists.");
        //validate destination currency exists
        CurrencyDto destinationOrigin = currencyService.findByCode(destination);
        if (destinationOrigin == null)
            throw new CustomException("Destination Currency does not exists.");
    }

    @Override
    public List<ExchangeRateDto> getAll() {
        return exchangeRateDtoMapper.fromEntityListToDtoList(exchangeRateRepository.findAll());
    }
}
