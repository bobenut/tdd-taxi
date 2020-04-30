package com.jiker.keju;

import java.io.*;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        System.out.println(String.format("arg0: %s", System.getProperty("user.dir")));
        readfile(System.getProperty("user.dir"));
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

    private static boolean readfile(String filepath) {

        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }

}
