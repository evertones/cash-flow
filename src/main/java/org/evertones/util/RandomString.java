package org.evertones.util;

import java.security.SecureRandom;

public class RandomString {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom secureRandom = new SecureRandom();

    public String randomText(String text) {
        return String.format("Test - %s - %s", text, randomText(10));
    }

    public String randomText(Integer length) {
        StringBuilder sb = new StringBuilder(length);
        for( int i = 0; i < length; i++ )
            sb.append( ALPHABET.charAt( secureRandom.nextInt(ALPHABET.length()) ) );
        return sb.toString();
    }

}
