package org.example;

public class Main {
    public static void main(String[] args) {
        String message = """
                Шифр Цезаря. Цей шифр реалізує таке перетворення
                відкритого тексту: кожна літера замінюється третьою після неї літерою
                алфавіту, який вважається написаним по колу, тобто після „я” йде „а”.
                Відмітимо, що Цезарь замінював її третьою літерою, але можна міняти і будь-
                якою іншою. Головне, щоби адресат цього повідомлення знав величину і
                напрямок цього зсуву. Клас шифрів, до якого відноситься шифр Цезаря,
                називається шифрами заміни.
                З цього, напевне зрозуміло, що створення хорошого шифру є задачею
                непростою. Тому бажано збільшити час життя шифру, але тут зростає
                імовірність того, що криптоаналітики противника зможуть розкрити шифр і
                читати зашифровані повідомлення. Якщо у шифрі є змінний „ключ”, то його
                заміна призводить до того, що розроблені противником методи вже не дадуть
                ефекту.
                """;

        String encryptedMessage = CaesarCipher.encrypt(message);
        String decryptedMessage = CaesarCipher.decrypt(encryptedMessage);

        System.out.println("===============================================================");
        System.out.println("Keys: \n");
        CaesarCipher.printIndexes();
        CaesarCipher.increaseKey();
        System.out.println("===============================================================");
        System.out.println("Increased keys: \n");
        CaesarCipher.printIndexes();
        System.out.println("===============================================================");
        System.out.println("Message: \n" + message);
        System.out.println("===============================================================");
        System.out.println("Encrypted message: \n" + encryptedMessage);
        System.out.println("===============================================================");
        System.out.println("Decrypted message: \n" + decryptedMessage);
        System.out.println("===============================================================");

        System.out.println("===============================================================");
        System.out.println("Vigenere cipher: \n");
        message = "Мова зникає не тому, що її не вчать інші, а тому, що нею не говорять ті, хто її знає.";
        String key = "товариш";
        String encryptedMessageVigenere = VigenereCipher.encrypt(message, key);
        System.out.println("Message: \n" + message);
        System.out.println("===============================================================");
        System.out.println("Encrypted message: \n" + encryptedMessageVigenere);
        System.out.println("===============================================================");
        System.out.println("Decrypted message: \n" + VigenereCipher.decrypt(encryptedMessageVigenere, key));
        System.out.println("===============================================================");
        VigenereCipher.printDecipherTable(key);
    }
}