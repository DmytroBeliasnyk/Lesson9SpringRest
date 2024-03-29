package org.currency.parser.lesson9springrest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
