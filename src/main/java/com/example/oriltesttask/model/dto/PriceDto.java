package com.example.oriltesttask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto {

    private BigDecimal lprice;
    private String curr1;
    private String curr2;


}
