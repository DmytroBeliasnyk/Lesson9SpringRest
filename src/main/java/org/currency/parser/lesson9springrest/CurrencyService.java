package org.currency.parser.lesson9springrest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyRepository cr;

    public CurrencyService(CurrencyRepository cr) {
        this.cr = cr;
    }

    @Transactional
    public void save(CurrencyUSD currencyUSD) {
        cr.save(currencyUSD);
    }

    @Transactional
    public List<CurrencyUSD> getAll() {
        return cr.findAll();
    }

    @Transactional
    public CurrencyUSD getByDate(String date) {
        return cr.findByExchangedate(date);
    }

    @Transactional
    public Double getAverage(String start, String end) {
        return cr.findAverageRate(start, end);
    }

    @Transactional
    public CurrencyUSD getMinRate(String start, String end) {
        Double min = cr.getMinRate(start, end);
        return cr.findByRate(min);
    }

    @Transactional
    public CurrencyUSD getMaxRate(String start, String end) {
        Double min = cr.getMaxRate(start, end);
        return cr.findByRate(min);
    }

    @Transactional
    public List<CurrencyUSD> getAllByDate(String start, String end) {
        return cr.getAllByExchangedateBetween(start, end);
    }
}
