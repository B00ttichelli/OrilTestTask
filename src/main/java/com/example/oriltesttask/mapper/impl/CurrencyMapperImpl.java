package com.example.oriltesttask.mapper.impl;

import com.example.oriltesttask.mapper.CurrencyMapper;
import com.example.oriltesttask.model.CurrencyPrice;
import com.example.oriltesttask.model.dto.PriceDto;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapperImpl implements CurrencyMapper {
    @Override
    public CurrencyPrice PriceDtoToCurrencyPrice(PriceDto priceDto) {
        return CurrencyPrice.builder().price(priceDto.getLprice()).name(priceDto.getCurr1()).build();
    }
}
