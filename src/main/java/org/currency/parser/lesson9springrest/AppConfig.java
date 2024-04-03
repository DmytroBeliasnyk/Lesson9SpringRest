package org.currency.parser.lesson9springrest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class AppConfig {
    private final String api = "https://bank.gov.ua/NBU_Exchange/exchange_site?start=20240101&end=20240330&valcode=usd&sort=exchangedate&order=desc&json";

    @Bean
    public CommandLineRunner demo(CurrencyService cs) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ObjectMapper om = new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                List<CurrencyUSD> request = om.readValue(new URL(api), new TypeReference<>() {
                });
                for (var currencyUSD : request) {
                    cs.save(currencyUSD);
                }
            }
        };
    }
}
