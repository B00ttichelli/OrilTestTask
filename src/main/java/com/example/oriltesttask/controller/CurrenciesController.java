package com.example.oriltesttask.controller;

import com.example.oriltesttask.service.CSVExportService;
import com.example.oriltesttask.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/cryptocurrencies")
@AllArgsConstructor
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


   private final CurrencyService currencyService;
   private final CSVExportService csvExportService;

    @GetMapping("/minprice")
    ResponseEntity<String> getMinPriceByName(@RequestParam String name ){

        return new ResponseEntity<>(currencyService.getMinPriceByName(name), HttpStatus.OK);

    }

    @GetMapping("/maxprice")
    ResponseEntity<String> getMaxPriceByName(@RequestParam String name) {

        return new ResponseEntity<>(currencyService.getMaxPriceByName(name), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<Map<String, Object>> getCurrencyByNamePagination(@RequestParam String name,
                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "price"); //sorted by price from lowest to highest.
        Map<String, Object> response = currencyService.findAllByNamePageable(name, pageable);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/csv")

    public void getCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition","attachment; filename=\"currencies.csv\"");
        csvExportService.writeMaxAndMinPriceToCSV(response.getWriter());
    }




}
