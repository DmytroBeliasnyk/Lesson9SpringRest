package org.currency.parser.lesson9springrest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    public CurrencyUSD getByDate(LocalDate date) {
        return cr.findByExchangedate(date);
    }

    @Transactional
    public Double getAverage(LocalDate start, LocalDate end) {
        return cr.findAverageRate(start, end);
    }

    @Transactional
    public CurrencyUSD getMinRate(LocalDate start, LocalDate end) {
        Double min = cr.getMinRate(start, end);
        return cr.findByRate(min);
    }

    @Transactional
    public CurrencyUSD getMaxRate(LocalDate start, LocalDate end) {
        Double min = cr.getMaxRate(start, end);
        return cr.findByRate(min);
    }

    @Transactional
    public List<CurrencyUSD> getAllByDate(LocalDate start, LocalDate end) {
        return cr.getAllByExchangedateBetween(start, end);
    }
}
