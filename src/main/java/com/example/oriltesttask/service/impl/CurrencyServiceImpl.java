package com.example.oriltesttask.service.impl;

import com.example.oriltesttask.exception.CustomException;
import com.example.oriltesttask.mapper.CurrencyMapper;
import com.example.oriltesttask.domain.CurrencyPrice;
import com.example.oriltesttask.dto.PriceDto;
import com.example.oriltesttask.repository.CurrencyRepository;
import com.example.oriltesttask.service.CurrencyService;
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
        CurrencyPrice firstByNameOrderByPriceAsc = currencyRepository.findFirstByNameOrderByPriceAsc(name);
        if(firstByNameOrderByPriceAsc == null){
            throw  new CustomException("Currency name is invalid or DB is empty");
        }
        return firstByNameOrderByPriceAsc.getPrice().toString();
    }

    @Override
    public String getMaxPriceByName(String name) {
        CurrencyPrice firstByNameOrderByPriceDesc = currencyRepository.findFirstByNameOrderByPriceDesc(name);

        if(firstByNameOrderByPriceDesc == null){
            throw  new CustomException("Currency name is invalid or DB is empty");
        }
        return firstByNameOrderByPriceDesc.getPrice().toString();
    }

    @Override
    public Map<String, Object> findAllByNamePageable(String name, Pageable pageable) {
        Map<String,Object> result = new HashMap<>();
        Page<CurrencyPrice> page = currencyRepository.findAllByName(name,pageable);
        if(page == null){
            throw  new CustomException("Currency name is invalid or DB is empty");
        }
        result.put("Currencies",page.getContent());
        result.put("CurrentPage",page.getNumber());
        result.put("totalItems:",page.getTotalElements());
        result.put("Pages:",page.getTotalPages());

        return result;
    }
}
