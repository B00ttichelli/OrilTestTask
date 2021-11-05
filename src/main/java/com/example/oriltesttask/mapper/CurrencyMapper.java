package com.example.oriltesttask.mapper;

import com.example.oriltesttask.model.CurrencyPrice;
import com.example.oriltesttask.model.dto.PriceDto;
import org.springframework.stereotype.Component;

public interface CurrencyMapper {
    CurrencyPrice PriceDtoToCurrencyPrice (PriceDto priceDto);

}
