package com.example.oriltesttask.service;

import com.example.oriltesttask.mapper.CurrencyMapper;
import com.example.oriltesttask.model.CurrencyPrice;
import com.example.oriltesttask.model.dto.PriceDto;
import com.example.oriltesttask.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<String, Object> findAllByNamePageable(String name, Pageable pageable) {
        Map<String,Object> result = new HashMap<>();
        Page<CurrencyPrice> page = currencyRepository.findAllByName(name,pageable);
        result.put("Currencies",page.getContent());
        result.put("CurrentPage",page.getNumber());
        result.put("totalItems:",page.getTotalElements());
        result.put("Pages:",page.getTotalPages());

        return result;
    }
}
