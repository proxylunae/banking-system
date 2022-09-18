package application;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class AccountManager {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private final HashMap<Long, Account> accounts = new HashMap<>();
    private Account currentAccount;

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.showMenu();
    }

    public void showMenu() {
        if (currentAccount == null) {
            System.out.println("""
                    1. Create an account
                    2. Log into account
                    0. Exit""");
            switch (SCANNER.nextInt()) {
                case (1):
                    createAccount();
                    showMenu();
                    break;
                case (2):
                    login();
                    showMenu();
                    break;
                case (0):
                    break;
            }
        } else {
            System.out.println("""
                    1. Balance
                    2. Log out
                    0. Exit""");
            switch (SCANNER.nextInt()) {
                case (1):
                    showBalance();
                    showMenu();
                    break;
                case (2):
                    logout();
                    showMenu();
                    break;
                case (0):
                    System.out.println("Bye!");
                    break;
            }
        }
    }

    public void createAccount() {
        long number;
        String pin;
        StringBuilder builder = new StringBuilder();
        while (builder.length() < 16) {
            if (builder.isEmpty()) {
                builder.append(400000);
            } else {
                builder.append(RANDOM.nextInt(10));
            }
        }
        number = Long.parseLong(builder.toString());
        builder = new StringBuilder();
        while (builder.length() < 4) {
            builder.append(RANDOM.nextInt(10));
        }
        pin = builder.toString();
        accounts.put(number, new Account(number, pin, 0));
        System.out.printf("\nYour card has been created%n" +
                "Your card number:%n" +
                "%d%n" +
                "Your card PIN:%n" +
                "%s%n%n", number, pin);
    }

    public void login() {
        System.out.println("\nEnter your card number:");
        long number = SCANNER.nextLong();
        System.out.println("Enter your PIN:");
        String pin = SCANNER.next();
        try {
            if (Objects.equals(accounts.get(number).getCardPin(), pin)) {
                System.out.println("\nYou have successfully logged in!");
                currentAccount = accounts.get(number);
            } else {
                System.out.println("\nWrong card number or PIN!\n");
            }
        } catch (Exception e) {
            System.out.println("\nWrong card number or PIN!\n");
        }
    }
    public void showBalance() {
        System.out.printf("Balance: %d%n%n", currentAccount.getBalance());
    }
    public void logout() {
        currentAccount = null;
        System.out.println("You have successfully logged out!");
    }
}
