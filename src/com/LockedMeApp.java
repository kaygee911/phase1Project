package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeApp {
    private static List<String> fileNames = new ArrayList<>();

    public static void main(String[] args) {
        displayWelcomeScreen();
        Scanner scanner = new Scanner(System.in);

        int userChoice;
        do {
            displayMainMenu();
            userChoice = getUserInput(scanner, 1, 3);

            switch (userChoice) {
                case 1:
                    retrieveFileNames();
                    break;
                case 2:
                    handleBusinessOperations(scanner);
                    break;
                case 3:
                    System.out.println("Closing the application. Goodbye!");
                    break;
            }

        } while (userChoice != 3);

        scanner.close();
    }

    private static void displayWelcomeScreen() {
        System.out.println("Welcome to LockedMe.com!");
        System.out.println("Developed by [Kgaogelo Tshehla]\n");
    }

    private static void displayMainMenu() {
        System.out.println("User Interface Options:");
        System.out.println("1. Retrieve File Names");
        System.out.println("2. Business Operations");
        System.out.println("3. Close Application");
    }

    private static void retrieveFileNames() {
        if (fileNames.isEmpty()) {
            System.out.println("\n\t***No files found in the directory.\n");
        } else {
            Collections.sort(fileNames);
            System.out.println("\nCurrent File Names in Ascending Order:");
            for (String fileName : fileNames) {
                System.out.println("\t- " + fileName);
            }
            System.out.println("");
        }
    }

    private static void handleBusinessOperations(Scanner scanner) {
        int businessChoice;
        do {
            displayBusinessOperationsMenu();
            businessChoice = getUserInput(scanner, 1, 5);

            switch (businessChoice) {
                case 1:
                    addFile(scanner);
                    break;
                case 2:
                    deleteFile(scanner);
                    break;
                case 3:
                    searchFile(scanner);
                    break;
                case 4:
                    System.out.println("Returning to the main menu.");
                    break;
                case 5:
                    System.out.println("Closing the application. Goodbye!");
                    System.exit(0);
            }

        } while (businessChoice != 4);
    }

    private static void displayBusinessOperationsMenu() {
        System.out.println("\nBusiness Operations Menu:");
        System.out.println("1. Add a File");
        System.out.println("2. Delete a File");
        System.out.println("3. Search for a File");
        System.out.println("4. Return to Main Menu");
        System.out.println("5. Close Application");
    }

    private static void addFile(Scanner scanner) {
        System.out.print("\nEnter the file name to add: ");
        String newFile = scanner.next().toLowerCase(); // Ignore case sensitivity
        fileNames.add(newFile);
        System.out.println("File added successfully.");
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("\nEnter the file name to delete: ");
        String fileToDelete = scanner.next();
        boolean isDeleted = fileNames.removeIf(fileName -> fileName.equals(fileToDelete));
        if (isDeleted) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found. Deletion unsuccessful.");
        }
    }

    private static void searchFile(Scanner scanner) {
        System.out.print("\nEnter the file name to search: ");
        String fileToSearch = scanner.next();
        boolean isFileFound = fileNames.contains(fileToSearch);
        if (isFileFound) {
            System.out.println("File found: " + fileToSearch);
        } else {
            System.out.println("File not found.");
        }
    }

    private static int getUserInput(Scanner scanner, int lowerBound, int upperBound) {
        int userInput;
        while (true) {
            try {
                System.out.print("\nEnter your choice (" + lowerBound + "-" + upperBound + "): ");
                userInput = Integer.parseInt(scanner.next());
                if (userInput >= lowerBound && userInput <= upperBound) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + lowerBound + " and " + upperBound + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return userInput;
    }
}

