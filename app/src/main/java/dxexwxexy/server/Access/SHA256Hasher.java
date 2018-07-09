package dxexwxexy.server.Access;

import java.security.*;
import java.util.Scanner;
import javax.crypto.*;
public class SHA256Hasher {
    public static String hasher(String str) throws NoSuchAlgorithmException {
        System.out.print("Enter String to Hash: ");
        byte[] input = str.getBytes();
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        hasher.update(input);
        byte[] digest = hasher.digest();
        StringBuilder hexDigest = new StringBuilder();
        for (byte aDigest : digest) {
            hexDigest.append(Integer.toString((aDigest & 0xff) + 0x100, 16).substring(1));
        }
        return String.valueOf(hexDigest);
    }
}
