package org.currency.parser.lesson9springrest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MyController {
    private final CurrencyService currencyService;

    public MyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String index() {
        StringBuilder sb = new StringBuilder();

        sb
                .append("Get all (from 01.01.2024 to 30.03.2024): /show \r\n")
                .append("Get rate by date: /show/dd.MM.yyyy \r\n")
                .append("Get the average rate in the date range: /average?start=dd.MM.yyyy&end=dd.MM.yyyy \r\n")
                .append("Get the min or max rate in the date range (replace the min with the max):" +
                        " /min?start=dd.MM.yyyy&end=dd.MM.yyyy \r\n");

        return sb.toString();
    }

    @GetMapping("/show")
    public List<CurrencyUSD> getAll() {
        return currencyService.getAll();
    }

    @GetMapping("/show/{date}")
    public CurrencyUSD getByDate(@PathVariable(name = "date")
                                 @DateTimeFormat(pattern = "dd.MM.yyyy")
                                 LocalDate date) {
        return currencyService.getByDate(date);
    }

    @GetMapping("/average")
    public Double getAverage(@RequestParam LocalDate start,
                             @RequestParam LocalDate end) {
        return currencyService.getAverage(start, end);
    }

    @GetMapping("/min")
    public CurrencyUSD getMin(@RequestParam LocalDate start,
                              @RequestParam LocalDate end) {
        return currencyService.getMinRate(start, end);
    }

    @GetMapping("/max")
    public CurrencyUSD getMax(@RequestParam LocalDate start,
                              @RequestParam LocalDate end) {
        return currencyService.getMaxRate(start, end);
    }
}
