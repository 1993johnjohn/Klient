package crypters;

public class Crypter {

    public static String encryptDecryptXOR(String input) {
        char[] key = {'K', 'K', 'K'};
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key[i % key.length]));
        }
        return output.toString();
    }
}
