package com.example.oriltesttask.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class MaxMinPriceDto {

    private String name;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
}
