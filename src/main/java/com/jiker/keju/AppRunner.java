package com.jiker.keju;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        String receipt = calculateFareFromFile(testDataFile);
        System.out.println(receipt);
    }

    private static String calculateFareFromFile(String filePath) {
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            result = readLineFromBuffeReader(br);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private static String readLineFromBuffeReader(BufferedReader bufferedReader) throws IOException {
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
