package problem.no51to60;

import utils.FileUtils;

import java.nio.charset.StandardCharsets;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem59 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=59
        problem("XOR decryption");
        solution(decrypt("/0059_cipher.txt"));
    }

    private static int decrypt(String s) {
        Byte[] encryptedBytes = FileUtils.getStringsBetweenSeparator(s, ",").map(Byte::valueOf).toArray(Byte[]::new);

        byte[] encrypted = new byte[encryptedBytes.length];
        for (int i = 0; i < encryptedBytes.length; i++) {
            encrypted[i] = encryptedBytes[i];
        }

        for (char i = 'a'; i <= 'z'; i++)
            for (char j = 'a'; j <= 'z'; j++)
                for (char k = 'a'; k <= 'z'; k++) {
                    byte[] decrypted = decrypt(encrypted, i, j, k);
                    if(contains(decrypted," the ")) {
                        System.out.println("Key=" + i + j + k);
                        dump(decrypted);
                        return new String(decrypted, StandardCharsets.UTF_8).chars().sum();
                    }
                }

        return 0;
    }

    private static boolean contains(byte[] decrypted, String word) {
        byte[] bytes = word.getBytes(StandardCharsets.UTF_8);
        for(int i=0;i<decrypted.length-word.length();i++)
            if(decrypted[i] == bytes[0]) {
                boolean found = true;
                for(int j=0;j<bytes.length;j++)
                    if(decrypted[i+j] != bytes[j]) {
                        found = false;
                        break;
                    }

                if(found)
                    return true;
            }

        return false;
    }

    private static byte[] decrypt(byte[] encrypted, char a, char b, char c) {
        byte[] decrypted = new byte[encrypted.length];
        for (int i = 0; i < encrypted.length-2; i+=3) {
            decrypted[i + 0] = (byte) (encrypted[i + 0] ^ a);
            decrypted[i + 1] = (byte) (encrypted[i + 1] ^ b);
            decrypted[i + 2] = (byte) (encrypted[i + 2] ^ c);
        }
        if(encrypted.length % 3 == 1)
            decrypted[encrypted.length-1] = (byte) (encrypted[encrypted.length-1] ^ a);
        if(encrypted.length % 3 == 2) {
            decrypted[encrypted.length-2] = (byte) (encrypted[encrypted.length-2] ^ a);
            decrypted[encrypted.length-1] = (byte) (encrypted[encrypted.length-1] ^ b);
        }
        return decrypted;
    }

    private static void dump(byte[] encrypted) {
        for (byte b : encrypted)
            System.out.print((char) b);

        System.out.println();
    }
}
