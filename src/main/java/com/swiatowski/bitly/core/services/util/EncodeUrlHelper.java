package com.swiatowski.bitly.core.services.util;

/**
 * Created by Piotrek on 8/24/2015.
 */
public class EncodeUrlHelper {
    private static final String CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-=";
    private static final int BASE = CHAR.length();

    public static String encode(Long id) {
        StringBuilder sb = new StringBuilder();
        while (id != 0) {
            sb.append(CHAR.charAt((int) (id % BASE)));
            id /= BASE;
        }
        return sb.reverse().toString();
    }
}
