package org.evertones.util;

public class Random {

    public static final java.util.Random random = new java.util.Random();

    public static String randomText(String text) {
        return String.format("Test - %s - %s", text, System.currentTimeMillis());
    }

    public static Double randomValue() {
        return random.nextDouble();
    }


}
