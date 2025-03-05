package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Single Scanner instance

        System.out.println("Enter your Input:");
        StringBuilder input = new StringBuilder(in.nextLine()); // Use StringBuilder for mutability

        // This function manages processes.
        Control(input, in);

        System.out.println("Final Modified Input: " + input.toString()); // Check changes in main

        in.close(); // Close Scanner after use
    }

    public static void Control(StringBuilder s, Scanner in) {
        // Declaration of Variables
        CaesarCipher caesar = new CaesarCipher();
        String status;
        int key;
        boolean isComplete = true;

        while (isComplete) {
            System.out.println("Do you want to Encode or Decode the Input? (inc/dec):");
            status = in.nextLine().trim().toLowerCase();

            System.out.println("Enter your encryption key:");
            while (!in.hasNextInt()) { // Ensure valid integer input
                System.out.println("Invalid key. Please enter an integer:");
                in.next(); // Consume invalid input
            }
            key = in.nextInt();
            in.nextLine(); // Consume newline left by nextInt()

            switch (status) {
                case "inc":
                    String encrypted = caesar.caesarCipherEncryption(s.toString(), key); // Encrypt
                    s.setLength(0); // Clear previous content
                    s.append(encrypted); // Store modified text
                    System.out.println("Encoded Output: " + s);
                    break;
                case "dec":
                    String decrypted = caesar.caesarCipherDecryption(s.toString(), key); // Decrypt
                    s.setLength(0);
                    s.append(decrypted);
                    System.out.println("Decoded Output: " + s);
                    break;
                default:
                    System.out.println("Invalid option. Please enter 'inc' or 'dec'.");
                    continue; // Restart loop if input is invalid
            }

            System.out.println("Are you complete? (yes/no)");
            isComplete = isComplete(in);

            System.out.println("===================================");
        }
    }

    public static boolean isComplete(Scanner in) {
        String input = in.nextLine().trim().toLowerCase(); // Normalize input
        return input.equals("yes"); // Returns true if user enters "yes", otherwise false
    }
}
