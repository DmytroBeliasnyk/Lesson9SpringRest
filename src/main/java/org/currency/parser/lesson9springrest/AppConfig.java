package org.currency.parser.lesson9springrest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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
                List<CurrencyUSD> request = om.readValue(new URL(api), new TypeReference<List<CurrencyUSD>>() {
                });
                for (var jsonString : request) {
                    cs.save(jsonString);
                }
            }
        };
    }
}
