package com.example.tata.services;

import com.example.tata.database.entities.ExchangeRateEntity;
import com.example.tata.dto.ExchangeRateDto;
import com.example.tata.exception.CustomException;

import java.util.List;

public interface ExchangeRateService {
    void addOrUpdateExchangeRate(ExchangeRateDto dto) throws CustomException;
    List<ExchangeRateDto> getAll();

}
