package com.example.tata.services.impl;

import com.example.tata.database.entities.CurrencyEntity;
import com.example.tata.database.entities.ExchangeRateEntity;
import com.example.tata.database.repositories.CurrencyRepository;
import com.example.tata.database.repositories.ExchangeRateRepository;
import com.example.tata.database.repositories.ExchangeRepository;
import com.example.tata.dto.CurrencyDto;
import com.example.tata.dto.ExchangeDto;
import com.example.tata.dto.mappers.AbstractExchangeDtoMapper;
import com.example.tata.exception.CustomException;
import com.example.tata.services.CurrencyService;
import com.example.tata.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private AbstractExchangeDtoMapper abstractExchangeDtoMapper;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public List<ExchangeDto> getAll() {
        return abstractExchangeDtoMapper.fromListToDtoList(exchangeRepository.findAll());
    }

    @Override
    public ExchangeDto doExchange(ExchangeDto dto) throws CustomException {
        ExchangeDto exchangeCreated = null;
        //validate origin currency exists
        CurrencyDto currencyOrigin = currencyService.findByCode(dto.getOriginCurrency().getCode());
        if (currencyOrigin == null)
            throw new CustomException("Origin Currency does not exists.");
        //validate destination currency exists
        CurrencyDto destinationOrigin = currencyService.findByCode(dto.getDestinationCurrency().getCode());
        if (destinationOrigin == null)
            throw new CustomException("Destination Currency does not exists.");
        //validate origin and destination not equals
        if(currencyOrigin.getCode().equals(destinationOrigin.getCode()))
            throw new CustomException("Origin and Destination currencies cannot be the same.");
        ExchangeRateEntity exchangeRate = exchangeRateRepository.findOptionalExchangeRateByCurrencyCodes(currencyOrigin.getCode(), destinationOrigin.getCode())
                .orElse(null);
        //validate if exchange rate exists
        if (exchangeRate == null)
            throw new CustomException("Exchange rate does not exists.");
        //calculate amount with exchange
        dto.setAmountWithExchange(dto.getAmount() * exchangeRate.getRate());
        dto.setType("Changeable");
        exchangeCreated = abstractExchangeDtoMapper.fromEntityToDto(
                exchangeRepository.save(abstractExchangeDtoMapper.fromDtoToEntity(dto))
        );
        return exchangeCreated;
    }
}
