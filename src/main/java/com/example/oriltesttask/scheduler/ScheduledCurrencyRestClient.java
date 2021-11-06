package com.example.oriltesttask.scheduler;

import com.example.oriltesttask.dto.PriceDto;
import com.example.oriltesttask.service.impl.CurrencyServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Slf4j
@Service
public class ScheduledCurrencyRestClient {

// currency list and url of api
private final String BTC = "BTC/USD";
private final String ETH =  "ETH/USD";
private final String XRP =  "XRP/USD";
private final String URL = "https://cex.io/api/last_price/";


private final RestTemplate restTemplate;
private final CurrencyServiceImpl currencyService;



@Scheduled(fixedRate = 10000)   // schedule every 10 seconds
public void fetchFromApiAndSave(){

    currencyService.save(getLastPrice(BTC));
    currencyService.save(getLastPrice(ETH));
    currencyService.save(getLastPrice(XRP));

}


public PriceDto getLastPrice(String currency){

    return restTemplate.getForObject(URL+currency,PriceDto.class);

}



}
