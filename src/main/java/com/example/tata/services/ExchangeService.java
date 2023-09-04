package com.example.tata.services;

import com.example.tata.dto.ExchangeDto;

import java.util.List;

public interface ExchangeService {

    List<ExchangeDto> getAll();
    ExchangeDto doExchange(ExchangeDto dto) throws Exception;
}
