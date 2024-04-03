package org.currency.parser.lesson9springrest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<CurrencyUSD, Long> {

    CurrencyUSD findByRate(Double rate);

    @Query("SELECT c FROM CurrencyUSD c WHERE c.exchangedate = :date")
    CurrencyUSD findByExchangedate(@Param("date") LocalDate date);

    List<CurrencyUSD> getAllByExchangedateBetween(LocalDate start, LocalDate end);

    @Query("SELECT AVG(c.rate) FROM CurrencyUSD c WHERE c.exchangedate BETWEEN ?1 AND ?2")
    Double findAverageRate(LocalDate start, LocalDate end);

    @Query("SELECT MIN(c.rate) FROM CurrencyUSD c WHERE c.exchangedate BETWEEN ?1 AND ?2")
    Double getMinRate(LocalDate start, LocalDate end);

    @Query("SELECT MAX(c.rate) FROM CurrencyUSD c WHERE c.exchangedate BETWEEN ?1 AND ?2")
    Double getMaxRate(LocalDate start, LocalDate end);
}
