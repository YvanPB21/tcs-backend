package com.example.tata.dto.mappers;

import com.example.tata.controllers.requests.ExchangeRequest;
import com.example.tata.controllers.responses.CurrencyResponse;
import com.example.tata.controllers.responses.ExchangeResponse;
import com.example.tata.database.entities.CurrencyEntity;
import com.example.tata.database.entities.ExchangeEntity;
import com.example.tata.dto.CurrencyDto;
import com.example.tata.dto.ExchangeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AbstractUUIDMapper.class, AbstractCurrencyDtoMapper.class})
public interface AbstractExchangeDtoMapper {


    ExchangeDto fromEntityToDto(ExchangeEntity entity);

    ExchangeEntity fromDtoToEntity(ExchangeDto dto);

    @Mapping(source = "originCurrencyCode", target = "originCurrency.code")
    @Mapping(source = "destinationCurrencyCode", target = "destinationCurrency.code")
    ExchangeDto fromRequestToDto(ExchangeRequest request);

    List<ExchangeDto> fromListToDtoList(List<ExchangeEntity> list );

    List<ExchangeResponse> fromDtoListToResponseList(List<ExchangeDto> list);

    @Mapping(source = "originCurrency.code", target = "originCurrencyCode")
    @Mapping(source = "destinationCurrency.code", target = "destinationCurrencyCode")
    ExchangeResponse fromDtoToResponse(ExchangeDto dto);

}
