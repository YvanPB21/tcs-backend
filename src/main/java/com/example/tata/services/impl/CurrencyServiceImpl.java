package com.example.tata.services.impl;

import com.example.tata.database.entities.CurrencyEntity;
import com.example.tata.database.repositories.CurrencyRepository;
import com.example.tata.dto.CurrencyDto;
import com.example.tata.dto.mappers.AbstractCurrencyDtoMapper;
import com.example.tata.exception.CustomException;
import com.example.tata.services.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private AbstractCurrencyDtoMapper currencyDtoMapper;

    @Override
    @Transactional
    public void addCurrency(CurrencyDto request) throws CustomException {
        CurrencyDto dto = findByCode(request.getCode().toUpperCase());
        if (dto != null)
            throw new CustomException("This Currency already exists.");
        request.setCode(request.getCode().toUpperCase());
        currencyRepository.save(currencyDtoMapper.fromDtoToEntity(request));
    }

    @Override
    public List<CurrencyDto> getAll() {
        return currencyDtoMapper.fromEntityListToDtoList(currencyRepository.findAll());
    }

    @Override
    public CurrencyDto findByCode(String code) {
        return currencyDtoMapper.fromEntityToDto(currencyRepository.findByCode(code).orElse(null));
    }
}
