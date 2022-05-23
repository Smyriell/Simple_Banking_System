//package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Program {

    public static void printMainMenu() {
        System.out.println("1. Create an account\n2. Log into account\n0. Exit");
    }

    public static void printAccountMenu() {
        System.out.println("1. Balance\n2. Log out\n0. Exit");
    }

    public static long generateCardNumber() {
        Random random = new Random();
        long cardBIN = 4000000000000000l;

        long cardNumber = random.nextInt(999999) + cardBIN;
        return cardNumber;
    }

    public static int generatePinCode() {
        Random random = new Random();

        int pinNumber = random.nextInt(9999);
        return pinNumber;
    }

    public static void createNewAccount(String[] card) {
        System.out.println("\nYour card has been created");
        Long cardNumber = generateCardNumber();
        card[0] = String.format("%016d", cardNumber);
        System.out.println("Your card number:\n" + card[0]);
        int pinNumber = generatePinCode();
        card[1] = String.format("%04d", pinNumber);
        System.out.println("Your card PIN:\n" + card[1] + "\n");
    }

    public static void accountMenu(Scanner scanner, String[] card) {
        while (true) {
            printAccountMenu();
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Balance: " + card[2] + "\n");
                    break;
                case 2:
                    System.out.println("\nYou have successfully logged out!\n");
                    return;
                case 0:
                    System.out.println("\nBye!");
                    System.exit(0);
                default:
                    System.out.println("\nError! Wrong input! Try again\n");
            }
        }
    }

    public static void logIntoAccount(Scanner scanner, String[] card) {
        System.out.println("\nEnter your card number:");
        long inputedCardNumber = scanner.nextLong();
        System.out.println("Enter your PIN:");
        int inputedPinNumber = scanner.nextInt();
        if (!(Long.toString(inputedCardNumber).equals(card[0]) && Integer.toString(inputedPinNumber).equals(card[1]))) {
            System.out.println("\nWrong card number or PIN!\n");
            return;
        }
        System.out.println("\nYou have successfully logged in!\n");
        accountMenu(scanner, card);
    }

    public static void parseUserInput(Scanner scanner, String[] card) {
        switch (scanner.nextInt()) {
            case 1:
                createNewAccount(card);
                break;
            case 2:
                logIntoAccount(scanner, card);
                break;
            case 0:
                System.out.println("\nBye!");
                System.exit(0);
            default:
                System.out.println("\nError! Wrong input! Try again\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] card = new String[3];

        while (true) {
            printMainMenu();
            parseUserInput(scanner, card);
        }
    }
}

//    private String generatePin() {
//        int num = ThreadLocalRandom.current().nextInt(9999);
//        String formatted = String.format("%04d", num);
//        System.out.println(formatted);
//
//        return formatted;
//    }