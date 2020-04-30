package com.jiker.keju;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Taxi {
    private static final int TRAFFIC_TEXT_STEPS_INDEX_MILES = 0;
    private static final int TRAFFIC_TEXT_STEPS_INDEX_WAITING_MINUTES = 1;

    private String extractNumberRegEx;
    private Pattern extractNumberPattern;

    public Taxi() {
        this.extractNumberRegEx = "[^0-9]";
        this.extractNumberPattern = Pattern.compile(extractNumberRegEx);
    }

    public String calculateFare(String trafficText) {
        String[] trafficStepTexts = trafficText.split(",");
        int miles = extractNumberFromTrafficStepText(trafficStepTexts[TRAFFIC_TEXT_STEPS_INDEX_MILES]);
        int waitingMinutes =
                extractNumberFromTrafficStepText(trafficStepTexts[TRAFFIC_TEXT_STEPS_INDEX_WAITING_MINUTES]);
        Taximeter taximeter = new Taximeter();
        double fare = taximeter.calculateFare(miles, waitingMinutes);
        return String.format("收费%.0f元", fare);
    }

    private int extractNumberFromTrafficStepText(String trafficStepText) {
        Matcher matcher = this.extractNumberPattern.matcher(trafficStepText);
        int number = Integer.parseInt(matcher.replaceAll("").trim());
        return number;
    }
}
