package com.example.oriltesttask.service.impl;

import com.example.oriltesttask.repository.CurrencyRepository;
import com.example.oriltesttask.service.CSVExportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import com.example.oriltesttask.dto.MaxMinPriceDto;

import java.io.IOException;
import java.io.Writer;

@Service
@AllArgsConstructor
@Slf4j
public class CSVExportServiceImpl implements CSVExportService {

    private final CurrencyRepository currencyRepository;

    @Override
    public void writeMaxAndMinPriceToCSV(Writer writer) {
            MaxMinPriceDto btc = creatFromRepository("BTC");
            MaxMinPriceDto eth = creatFromRepository("ETH");
            MaxMinPriceDto xrp = creatFromRepository("XRP");
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)){
                    csvPrinter.printRecord(btc.getName(),btc.getMinPrice(),btc.getMaxPrice());
                    csvPrinter.printRecord(eth.getName(),eth.getMinPrice(),eth.getMaxPrice());
                    csvPrinter.printRecord(xrp.getName(),xrp.getMinPrice(),xrp.getMaxPrice());

            } catch (IOException e) {
                log.error("CSVExportServiceImpl: Error while writing csv");
            }
    }


    private MaxMinPriceDto creatFromRepository (String name){

        return MaxMinPriceDto.builder()
                .name(name)
                .minPrice(currencyRepository.findFirstByNameOrderByPriceDesc(name).getPrice())
                .maxPrice(currencyRepository.findFirstByNameOrderByPriceAsc(name).getPrice())
                .build();
    }

}
