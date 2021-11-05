package com.example.oriltesttask.service;

import com.example.oriltesttask.mapper.CurrencyMapper;
import com.example.oriltesttask.model.CurrencyPrice;
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

    @Override
    public String getMinPriceByName(String name) {
        CurrencyPrice firstByNameOOrderByPriceDesc = currencyRepository.findFirstByNameOrderByPriceAsc(name);
        return firstByNameOOrderByPriceDesc.getPrice().toString();
    }

    @Override
    public String getMaxPriceByName(String name) {
        CurrencyPrice firstByNameOrderByPriceDesc = currencyRepository.findFirstByNameOrderByPriceDesc(name);
        return firstByNameOrderByPriceDesc.getPrice().toString();
    }
}
