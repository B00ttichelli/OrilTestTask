package com.example.oriltesttask.service;

import com.example.oriltesttask.model.dto.PriceDto;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface CurrencyService {
    void save(PriceDto priceDto);

    String getMinPriceByName(String name);

    String getMaxPriceByName(String name);

    Map<String, Object> findAllByNamePageable(String name, Pageable pageable);
}
