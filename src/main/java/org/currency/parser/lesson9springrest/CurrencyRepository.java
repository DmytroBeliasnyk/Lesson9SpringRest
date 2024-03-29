package org.currency.parser.lesson9springrest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyUSD, Long> {
}
