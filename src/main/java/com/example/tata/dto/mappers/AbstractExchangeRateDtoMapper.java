package com.example.tata.dto.mappers;

import com.example.tata.controllers.requests.CreateExchangeRateRequest;
import com.example.tata.controllers.responses.ExchangeRateResponse;
import com.example.tata.database.entities.ExchangeRateEntity;
import com.example.tata.dto.ExchangeRateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AbstractUUIDMapper.class, AbstractCurrencyDtoMapper.class})
public interface AbstractExchangeRateDtoMapper {

    @Mapping(source = "originCurrencyCode", target = "originCurrency.code")
    @Mapping(source = "destinationCurrencyCode", target = "destinationCurrency.code")
    ExchangeRateDto fromRequestToDto(CreateExchangeRateRequest req);

    ExchangeRateEntity fromDtoToEntity(ExchangeRateDto dto);

    List<ExchangeRateDto> fromEntityListToDtoList(List<ExchangeRateEntity> list);

    List<ExchangeRateResponse> fromDtoListToResponseList(List<ExchangeRateDto> list);

    ExchangeRateResponse fromDtoToResponse(ExchangeRateDto dto);
}
