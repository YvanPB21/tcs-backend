package com.example.tata.services;

import com.example.tata.database.entities.CurrencyEntity;
import com.example.tata.dto.CurrencyDto;
import com.example.tata.exception.CustomException;

import java.util.List;

public interface CurrencyService {

    void addCurrency(CurrencyDto request) throws CustomException;
    List<CurrencyDto> getAll();

    CurrencyDto findByCode(String code);
}
