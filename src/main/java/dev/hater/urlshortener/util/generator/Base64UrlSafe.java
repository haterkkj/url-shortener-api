package dev.hater.urlshortener.util.generator;

import java.nio.ByteBuffer;
import java.util.Base64;

public class Base64UrlSafe {

    public static String encode(long num) {
        ByteBuffer bb = ByteBuffer.allocate(Long.BYTES);
        bb.putLong(num);
        byte[] bytes = bb.array();

        String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);

        return encoded.replaceAll("^A+", "");
    }

}