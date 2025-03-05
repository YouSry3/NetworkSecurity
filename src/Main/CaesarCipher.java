package Main;

public class CaesarCipher {

    // Encryption method
    public String caesarCipherEncryption(String plainText, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            char cipheredChar;
            if (Character.isUpperCase(currentChar)) {
                cipheredChar = (char) (((currentChar - 'A' + key) % 26) + 'A');
            } else if (Character.isLowerCase(currentChar)) {
                cipheredChar = (char) (((currentChar - 'a' + key) % 26) + 'a');
            } else {
                cipheredChar = currentChar; // Keep non-alphabetic characters unchanged
            }
            sb.append(cipheredChar);
        }
        return sb.toString();
    }

    // Decryption method (Fixed)
    public String caesarCipherDecryption(String cipheredText, int key) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cipheredText.length(); j++) {
            char currentChar = cipheredText.charAt(j);
            char decipheredChar;

            if (Character.isLowerCase(currentChar)) {
                decipheredChar = (char) (((currentChar - 'a' - key + 26) % 26) + 'a');
            } else if (Character.isUpperCase(currentChar)) {
                decipheredChar = (char) (((currentChar - 'A' - key + 26) % 26) + 'A');
            } else {
                decipheredChar = currentChar; // Keep non-alphabetic characters unchanged
            }
            sb.append(decipheredChar);
        }
        return sb.toString();
    }
}
