package com.example.oriltesttask.scheduler;

import com.example.oriltesttask.model.dto.PriceDto;
import com.example.oriltesttask.service.CurrencyServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Slf4j
@Service
public class ScheduledCurrencyRestClient {

  /*  You need to create a cron job timer that runs every 10 seconds and pulls cryptocurrency last prices from CEX.IO.
   Hint: use endpoint that returns last price of selected pair. For this task you should pull last prices for the following pairs: BTC/USD, ETH/USD and XRP/USD.
   This data should be stored in database, since you will use this data in the next two parts of the task.
   Feel free to store any additional information to database like ‘createdAt’ date etc.



   Example
   Get https://cex.io/api/last_price/BTC/USD

   Response
      {
         " lprice": "62313.7",
          "curr1": "BTC",
          "curr2": "USD"
      }
   */

// currency list and url of api
private final String BTC = "BTC/USD";
private final String ETH =  "ETH/USD";
private final String XRP =  "XRP/USD";
private final String URL = "https://cex.io/api/last_price/";




private final RestTemplate restTemplate;
private final CurrencyServiceImpl currencyService;



@Scheduled(fixedRate = 10000)   // schedule every 10 seconds
public void fetchFromApiAndSave(){


    PriceDto btc = getLastPrice(BTC);
    PriceDto eth = getLastPrice(ETH);
    PriceDto xrp = getLastPrice(XRP);

    currencyService.save(btc);
    currencyService.save(eth);
    currencyService.save(xrp);


    log.info("btc"+btc.getLprice()+ "XRP "+ xrp.getLprice() + "Eth " + eth.getLprice());

}


public PriceDto getLastPrice(String currency){

    return restTemplate.getForObject(URL+currency,PriceDto.class);

}



}
