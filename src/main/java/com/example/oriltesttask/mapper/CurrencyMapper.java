package com.example.oriltesttask.mapper;

import com.example.oriltesttask.domain.CurrencyPrice;
import com.example.oriltesttask.dto.PriceDto;

public interface CurrencyMapper {
    CurrencyPrice PriceDtoToCurrencyPrice (PriceDto priceDto);

}
