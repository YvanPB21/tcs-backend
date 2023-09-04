package com.example.tata.dto.mappers;

import com.example.tata.controllers.requests.CreateCurrencyRequest;
import com.example.tata.controllers.responses.CurrencyResponse;
import com.example.tata.database.entities.CurrencyEntity;
import com.example.tata.dto.CurrencyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AbstractCurrencyDtoMapper {

    CurrencyEntity fromDtoToEntity(CurrencyDto dto);

    CurrencyDto fromEntityToDto(CurrencyEntity entity);

    CurrencyDto fromRequestToDto(CreateCurrencyRequest request);

    List<CurrencyDto> fromEntityListToDtoList(List<CurrencyEntity> list);

    List<CurrencyResponse> fromDtoListToResponseList(List<CurrencyDto> list);

    CurrencyResponse fromDtoToResponse(CurrencyDto dto);


}
