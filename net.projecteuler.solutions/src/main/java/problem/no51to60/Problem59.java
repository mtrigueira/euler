package problem.no51to60;

import utils.FileUtils;

import java.nio.charset.StandardCharsets;

import static problem.Solution.problem;

public class Problem59 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=59
        problem("XOR decryption",
        () -> decrypt(MESSAGE));
    }

    static int decrypt(byte[] encrypted) {
        for (char i = 'a'; i <= 'z'; i++)
            for (char j = 'a'; j <= 'z'; j++)
                for (char k = 'a'; k <= 'z'; k++) {
                    byte[] decrypted = decrypt(encrypted, i, j, k);
                    if(contains(decrypted)) {
                        System.out.println("Key=" + i + j + k);
                        dump(decrypted);
                        return new String(decrypted, StandardCharsets.UTF_8).chars().sum();
                    }
                }

        return 0;
    }

    private static boolean contains(byte[] decrypted) {
        byte[] bytes = " the ".getBytes(StandardCharsets.UTF_8);
        for(int i = 0; i<decrypted.length- " the ".length(); i++)
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

    static byte[] decrypt(byte[] encrypted, char a, char b, char c) {
        byte[] decrypted = new byte[encrypted.length];
        byte[] key = new byte[]{(byte) a, (byte) b, (byte) c};

        for (int i = 0; i < encrypted.length; i++)
            decrypted[i] = (byte) (encrypted[i] ^ key[i % 3]);

        return decrypted;
    }

    private static void dump(byte[] encrypted) {
        for (byte b : encrypted)
            System.out.print((char) b);

        System.out.println();
    }

    private static final byte[] MESSAGE = FileUtils.getString("/0059_cipher.txt").getBytes(StandardCharsets.UTF_8);
}
