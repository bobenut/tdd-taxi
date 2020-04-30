package com.jiker.keju;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TaximeterTest {
    @Test
    public void should_show_price_given_only_paying_starting_fare() {
        assertEquals(6.0, calculateTaxiFare(1, 0));
    }

    @Test
    public void should_show_price_given_paying_fare_per_miles() {
        assertEquals(7.0, calculateTaxiFare(3,0));
    }

    @Test
    public void should_show_price_given_paying_long_distance_fare() {
        assertEquals(13.0, calculateTaxiFare(10, 0));
    }

    @Test
    public void should_show_price_given_paying_waiting_fare() {
        assertEquals(7.0, calculateTaxiFare(2,3));
    }

    private double calculateTaxiFare(int miles, int waitingMinutes) {
        Taximeter taximeter = new Taximeter();
        return taximeter.calculateFare(miles, waitingMinutes);
    }
}
