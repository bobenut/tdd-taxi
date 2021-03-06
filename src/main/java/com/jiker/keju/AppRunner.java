package com.jiker.keju;

import java.io.*;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = String.format("src/main/resources/%s", args[0]);
        String receipt = calculateFareFromFile(testDataFile);
        System.out.println(receipt);
    }

    private static String calculateFareFromFile(String filePath) {
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            result = calculateAllLinesFromBuffeReader(br);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private static String calculateAllLinesFromBuffeReader(BufferedReader bufferedReader) throws IOException {
        String result = "";
        Taxi taxi = new Taxi();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            result += taxi.calculateFare(line);
            result += "\n";
        }
        return result;
    }
}
