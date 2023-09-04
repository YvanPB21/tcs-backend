package com.example.tata.controllers;

import com.example.tata.controllers.requests.ExchangeRequest;
import com.example.tata.dto.mappers.AbstractExchangeDtoMapper;
import com.example.tata.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private AbstractExchangeDtoMapper abstractExchangeDtoMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(abstractExchangeDtoMapper.fromDtoListToResponseList(exchangeService.getAll()));
    }

    @PostMapping
    ResponseEntity<?> doExchange(@RequestBody ExchangeRequest request) throws Exception {
        return ResponseEntity.ok(
                abstractExchangeDtoMapper.fromDtoToResponse(
                        exchangeService.doExchange(
                                abstractExchangeDtoMapper.fromRequestToDto(request)
                        )));

    }
}
