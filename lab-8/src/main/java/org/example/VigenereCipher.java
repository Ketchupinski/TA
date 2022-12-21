package org.example;

/**
 * Vigenere cipher. This cipher implements such a transformation of the open text:
 * the first letter of the open text is encrypted by the first letter of the key,
 * the second letter of the open text is encrypted by the second letter of the key,
 * and so on. If the key is shorter than the open text, it is repeated as many times
 * as necessary. The encryption of a letter is performed by the Caesar cipher with
 * the shift equal to the ordinal number of the letter of the key in the alphabet.
 * The decryption is performed in the same way.
 *
 * @author Arsen
 * @version 1.0
 */
public final class VigenereCipher {
    private VigenereCipher() {
    }

    /**
     * Encrypts the open text using the Vigenere cipher.
     *
     * @param openText the open text to encrypt
     * @param key      the key
     * @return the encrypted text
     */
    public static String encrypt(String openText, String key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < openText.length(); i++) {
            char letter = openText.charAt(i);
            int letterIndex = CaesarCipher.ALPHABET.indexOf(letter);
            if (letterIndex != -1) {
                int keyIndex = CaesarCipher.ALPHABET.indexOf(key.charAt(i % key.length()));
                int newLetterIndex = (letterIndex + keyIndex) % CaesarCipher.LENGTH;
                encryptedText.append(CaesarCipher.ALPHABET.charAt(newLetterIndex));
            } else {
                encryptedText.append(letter);
            }
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts the encrypted text using the Vigenere cipher.
     *
     * @param encryptedText the encrypted text to decrypt
     * @param key           the key
     * @return the decrypted text
     */
    public static String decrypt(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char letter = encryptedText.charAt(i);
            int letterIndex = CaesarCipher.ALPHABET.indexOf(letter);
            if (letterIndex != -1) {
                int keyIndex = CaesarCipher.ALPHABET.indexOf(key.charAt(i % key.length()));
                int newLetterIndex = (letterIndex - keyIndex) % CaesarCipher.LENGTH;
                if (newLetterIndex < 0) {
                    newLetterIndex += CaesarCipher.LENGTH;
                }
                decryptedText.append(CaesarCipher.ALPHABET.charAt(newLetterIndex));
            } else {
                decryptedText.append(letter);
            }
        }
        return decryptedText.toString();
    }

    /**
     * Prints decipher table.
     *
     * @param key the key
     */
    public static void printDecipherTable(String key) {
        System.out.println("Decipher table:");
        for (int i = 0; i < CaesarCipher.ALPHABET.length(); i++) {
            System.out.print(CaesarCipher.ALPHABET.charAt(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < CaesarCipher.ALPHABET.length(); i++) {
            System.out.print(CaesarCipher.ALPHABET.charAt(i) + " ");
            for (int j = 0; j < CaesarCipher.ALPHABET.length(); j++) {
                int keyIndex = CaesarCipher.ALPHABET.indexOf(key.charAt(i % key.length()));
                int newLetterIndex = (j - keyIndex) % CaesarCipher.LENGTH;
                if (newLetterIndex < 0) {
                    newLetterIndex += CaesarCipher.LENGTH;
                }
                System.out.print(CaesarCipher.ALPHABET.charAt(newLetterIndex) + " ");
            }
            System.out.println();
        }
    }
}
