package org.currency.parser.lesson9springrest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<CurrencyUSD, Long> {

    CurrencyUSD findByRate(Double rate);

    CurrencyUSD findByExchangedate(String exchangedate);

    List<CurrencyUSD> getAllByExchangedateBetween(String start, String end);

    @Query("SELECT AVG(c.rate) FROM CurrencyUSD c WHERE c.exchangedate BETWEEN ?1 AND ?2")
    Double findAverageRate(String start, String end);

    @Query("SELECT MIN(c.rate) FROM CurrencyUSD c WHERE c.exchangedate BETWEEN ?1 AND ?2")
    Double getMinRate(String start, String end);

    @Query("SELECT MAX(c.rate) FROM CurrencyUSD c WHERE c.exchangedate BETWEEN ?1 AND ?2")
    Double getMaxRate(String start, String end);
}
