package com.example.oriltesttask.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/currencies")*/
public class CurrenciesController {

   /* Rest Endpoints.
    You need to create a rest controller with the following endpoints

    GET /cryptocurrencies/minprice?name=[currency_name] - should return record with the lowest price of selected cryptocurrency.

    GET /cryptocurrencies/maxprice?name=[currency_name] - should return record with the highest price of selected cryptocurrency
     [currency_name] possible values: BTC, ETH or XRP. If some other value is provided then appropriate error message should be thrown.

    GET /cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size] - should return a selected page with selected number
    of elements and default sorting should be by price from lowest to highest. For example, if page=0&size=10, then you should return first 10
    elements from database, sorted by price from lowest to highest. [page_number] and [page_size] request parameters should be optional,
    so if they are missing then you should set them default values page=0, size=10.
*/




}
