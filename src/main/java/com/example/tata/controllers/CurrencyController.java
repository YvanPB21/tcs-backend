package com.example.tata.controllers;

import com.example.tata.controllers.requests.CreateCurrencyRequest;
import com.example.tata.dto.mappers.AbstractCurrencyDtoMapper;
import com.example.tata.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private AbstractCurrencyDtoMapper currencyDtoMapper;

    @Autowired
    private CurrencyService currencyService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(currencyDtoMapper.fromDtoListToResponseList(currencyService.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCurrency(@RequestBody CreateCurrencyRequest request) throws Exception {
        currencyService.addCurrency(currencyDtoMapper.fromRequestToDto(request));
        return ResponseEntity.ok().body(null);
    }
}
