package org.example;

/**
 * This class is used to encrypt and decrypt messages using the Caesar Cipher.
 * The Caesar Cipher is a simple substitution cipher that replaces each letter
 * Cipher encrypt ukrainian text.
 */
public final class CaesarCipher {
    public static int KEY = 3 + 6; // 27 + 9 = 36 than 3 + 6 = 9
    public static final String ALPHABET = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя:., АБВГДЕЁЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ„”";

    public static final int LENGTH = ALPHABET.length();

    private CaesarCipher() {}


    /**
     * This method is used to encrypt a text using the Caesar Cipher.
     * @param text the text to encrypt
     * @return The encrypted message.
     */
    public static String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letterIndex = ALPHABET.indexOf(letter);
            if (letterIndex != -1) {
                int newLetterIndex = (letterIndex + KEY) % LENGTH;
                encryptedText.append(ALPHABET.charAt(newLetterIndex));
            } else {
                encryptedText.append(letter);
            }
        }
        return encryptedText.toString();
    }

    /**
     * This method is used to decrypt a text using the Caesar Cipher.
     * @param text the text to decrypt
     * @return The decrypted message.
     */
    public static String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letterIndex = ALPHABET.indexOf(letter);
            if (letterIndex != -1) {
                int newLetterIndex = (letterIndex - KEY) % LENGTH;
                if (newLetterIndex < 0) {
                    newLetterIndex += LENGTH;
                }
                decryptedText.append(ALPHABET.charAt(newLetterIndex));
            } else {
                decryptedText.append(letter);
            }
        }
        return decryptedText.toString();
    }

    /**
     * This method prints letters of alphabet with key offset.
     */
    public static void printIndexes() {
        for (int i = 0; i < LENGTH; i++) {
            System.out.println(ALPHABET.charAt(i) + " " + (i + KEY) % LENGTH);
        }
    }

    public static void increaseKey() {
        KEY++;
    }
}
