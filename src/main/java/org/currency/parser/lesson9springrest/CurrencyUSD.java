package org.currency.parser.lesson9springrest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
public class CurrencyUSD {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, name = "name")
    private String enname;
    @Column(nullable = false)
    private String exchangedate;
    @Column(nullable = false)
    private double rate;

    public CurrencyUSD() {
    }

    public CurrencyUSD(String enname, String exchangedate, double rate) {
        this.enname = enname;
        this.exchangedate = exchangedate;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CurrencyUSD{" +
                "id=" + id +
                ", enname='" + enname + '\'' +
                ", exchangedate=" + exchangedate +
                ", rate=" + rate +
                '}';
    }
}
