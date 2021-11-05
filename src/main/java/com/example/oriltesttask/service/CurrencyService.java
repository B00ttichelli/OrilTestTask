package com.example.oriltesttask.service;

import com.example.oriltesttask.model.dto.PriceDto;

public interface CurrencyService {
    void save(PriceDto priceDto);

    String getMinPriceByName(String name);

    String getMaxPriceByName(String name);
}
