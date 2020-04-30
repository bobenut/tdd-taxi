package com.jiker.keju;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxiTest {
    @Test
    public void should_show_price_given_only_paying_starting_fare() {
        assertEquals("收费6元", calculateTaxiFare("1公里,等待0分钟"));
    }

    @Test
    public void should_show_price_given_paying_fare_per_miles() {
        assertEquals("收费7元", calculateTaxiFare("3公里,等待0分钟"));
    }

    @Test
    public void should_show_price_given_paying_long_distance_fare() {
        assertEquals("收费13元", calculateTaxiFare("10公里,等待0分钟"));
    }

    @Test
    public void should_show_price_given_paying_waiting_fare() {
        assertEquals("收费7元", calculateTaxiFare("2公里,等待3分钟"));
    }

    private String calculateTaxiFare(String trafficText) {
        Taxi taxi = new Taxi();
        return taxi.calculateFare(trafficText);
    }
}
