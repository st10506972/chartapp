package chartap;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QuickChat {

    static Scanner input = new Scanner(System.in);

    // Stored registration details
    static String storedUsername;
    static String storedPassword;
    static String storedCell;

    // Message counter
    static int numMessagesSent = 0;

    // =========================
    // USERNAME VALIDATION
    // =========================
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // =========================
    // PASSWORD VALIDATION
    // =========================
    public static boolean checkPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[^a-zA-Z0-9].*");
    }

    // =========================
    // CELL NUMBER VALIDATION
    // =========================
    public static boolean checkCellNumber(String number) {
        return Pattern.matches("^\\+27\\d{9}$", number);
    }

    // =========================
    // REGISTER USER
    // =========================
    public static void registerUser() {

        System.out.println("===== REGISTER =====");

        // Username
        System.out.print("Enter username: ");
        storedUsername = input.nextLine();

        if (checkUsername(storedUsername)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; "
                    + "please ensure that your username contains an underscore "
                    + "and is no more than five characters in length.");
        }

        // Password
        System.out.print("Enter password: ");
        storedPassword = input.nextLine();

        if (checkPassword(storedPassword)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; "
                    + "please ensure that the password contains at least "
                    + "eight characters, a capital letter, a number, "
                    + "and a special character.");
        }

        // Cell Number
        System.out.print("Enter SA cell number (+27831234567): ");
        storedCell = input.nextLine();

        if (checkCellNumber(storedCell)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted "
                    + "or does not contain international code.");
        }
    }

    // =========================
    // LOGIN USER
    // =========================
    public static boolean loginUser() {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (username.equals(storedUsername)
                && password.equals(storedPassword)) {

            System.out.println("Welcome " + username
                    + ", it is great to see you again.");

            return true;

        } else {

            System.out.println("Username or password incorrect, "
                    + "please try again.");

            return false;
        }
    }

    // =========================
    // GENERATE MESSAGE ID
    // =========================
    public static String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // =========================
    // CREATE MESSAGE HASH
    // =========================
    public static String createMessageHash(String messageID,
                                           int messageNumber,
                                           String message) {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        String firstTwoDigits = messageID.substring(0, 2);

        return firstTwoDigits + ":" + messageNumber
                + ":" + firstWord + lastWord;
    }

    // =========================
    // SEND MESSAGE
    // =========================
    public static void sendMessage() {

        System.out.println("\n===== SEND MESSAGE =====");

        // Recipient
        System.out.print("Enter recipient number (+27831234567): ");
        String recipient = input.nextLine();

        if (!checkCellNumber(recipient)) {

            System.out.println("Cell phone number incorrectly formatted "
                    + "or does not contain international code.");

            return;
        }

        // Message
        System.out.print("Enter your message: ");
        String message = input.nextLine();

        if (message.length() > 250) {

            System.out.println("Please enter a message "
                    + "of less than 250 characters.");

            return;
        }

        // Increment messages
        numMessagesSent++;

        // Generate ID
        String messageID = generateMessageID();

        // Generate hash
        String hash = createMessageHash(messageID,
                numMessagesSent,
                message);

        // Output
        System.out.println("\nMessage sent!");

        System.out.println("Message ID: " + messageID);

        System.out.println("Message Hash: " + hash);

        System.out.println("Recipient: " + recipient);

        System.out.println("Message: " + message);

        System.out.println("Total messages sent: "
                + numMessagesSent);
    }

    // =========================
    // MAIN PROGRAM
    // =========================
    public static void main(String[] args) {

        registerUser();

        boolean loggedIn = loginUser();

        if (loggedIn) {

            System.out.println("\nWelcome to QuickChat.");

            int option;

            do {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");

                System.out.print("Choose option: ");
                option = input.nextInt();
                input.nextLine();

                switch (option) {

                    case 1 -> sendMessage();

                    case 2 -> System.out.println("Coming Soon.");

                    case 3 -> System.out.println("Goodbye!");

                    default -> System.out.println("Invalid option.");
                }

            } while (option != 3);
        }
    }
}
