package com.jiker.keju;

public class Taximeter {
    private static final double FARE_PER_KILOMETER = 0.8;
    private static final double FARE_STARTING = 6;
    private static final int STARTING_MILES = 2;
    private static final double FARE_PERCENT_OF_LONG_DISTANCE = 0.5;
    private static final int LONG_DISTANCE_BASE_MILES = 8;
    private static final double FARE_PER_MINUTES = 0.25;

    public double calculateFare(int miles, int waitingMinutes) {
        double fareOfMiles = calculateFareOfMiles(miles);
        double fareOfLongDistance = calculateFareOfLongDistance(miles);
        double fareOfWaiting = calculateFareOfWaiting(waitingMinutes);
        return  Math.round(FARE_STARTING + fareOfMiles + fareOfLongDistance + fareOfWaiting);
    }

    private double calculateFareOfMiles(int miles) {
        int calculatedMiles = Math.max(miles - STARTING_MILES, 0);
        return calculatedMiles * FARE_PER_KILOMETER;
    }

    private double calculateFareOfLongDistance(int miles) {
        int calculatedLongDistanceMiles = Math.max(miles - LONG_DISTANCE_BASE_MILES, 0);
        return FARE_PER_KILOMETER * FARE_PERCENT_OF_LONG_DISTANCE *  calculatedLongDistanceMiles;
    }

    private double calculateFareOfWaiting(int waitingMinutes) {
        return FARE_PER_MINUTES * waitingMinutes;
    }
}
