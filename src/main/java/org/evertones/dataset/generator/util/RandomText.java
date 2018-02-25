package org.evertones.dataset.generator.util;

import java.security.SecureRandom;

public class RandomText {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int DEFAULT_LENGTH = 10;

    public String randomText(String text) {
        return String.format("Test - %s - %s", text, randomText());
    }

    public String randomText() {
        return randomText(DEFAULT_LENGTH);
    }

    public String randomText(Integer length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for( int i = 0; i < length; i++ )
            sb.append( ALPHABET.charAt( secureRandom.nextInt(ALPHABET.length()) ) );
        return sb.toString();
    }

}
