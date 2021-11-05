package com.example.oriltesttask.service;

import com.example.oriltesttask.mapper.CurrencyMapper;
import com.example.oriltesttask.model.dto.PriceDto;
import com.example.oriltesttask.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @Override
    public void save(PriceDto priceDto) {
        currencyRepository.save(currencyMapper.PriceDtoToCurrencyPrice(priceDto));
    }
}
