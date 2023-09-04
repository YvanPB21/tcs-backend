package com.example.tata.controllers;

import com.example.tata.controllers.requests.CreateExchangeRateRequest;
import com.example.tata.dto.mappers.AbstractExchangeRateDtoMapper;
import com.example.tata.services.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private AbstractExchangeRateDtoMapper exchangeRateDtoMapper;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(exchangeRateDtoMapper.fromDtoListToResponseList(exchangeRateService.getAll()));
    }

    @PostMapping("")
    public ResponseEntity<?> addExchangeRate(@RequestBody CreateExchangeRateRequest request) throws Exception {
        exchangeRateService.addOrUpdateExchangeRate(exchangeRateDtoMapper.fromRequestToDto(request));
        return ResponseEntity.ok().body(null);
    }

}
