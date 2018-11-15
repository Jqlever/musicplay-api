package com.weteam.musicplayapi.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    public static String md5(String palinTxt) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("md5");
        digest.update(palinTxt.getBytes());
        byte[] encrypt = digest.digest();
        return new BigInteger(1, encrypt).toString(16);
    }


}
