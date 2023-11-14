package com;
import java.util.Scanner;

public class EmailSearch {
    public static void main(String[] args) {
        String[] emailList = new String[7];
        populateEmailList(emailList);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an email ID to search: ");
        String searchInput = input.nextLine().toLowerCase();

        String foundEmail = findEmail(emailList, searchInput);

        if (foundEmail != null) {
            System.out.println("\nEmail ID: " + searchInput + ", was found in the list.\nComplete Email: " + foundEmail);
        } else {
            System.out.println("\nEmail ID was not found in the list.");
        }

        input.close();
    }

    // Method to search for an email in the list
    public static String findEmail(String[] emailList, String searchInput) {
        // Iterate through the array to search for the email
        for (String email : emailList) {
            String emailLower = email.toLowerCase();

            // Check if the search input matches the entire email or just the email ID prefix
            if (emailLower.equals(searchInput) || emailLower.startsWith(searchInput + "@")) {
                return email;
            }

            // Check if the search input matches the email ID prefix without the domain
            int atIndex = emailLower.indexOf('@');
            if (atIndex != -1 && emailLower.substring(0, atIndex).equals(searchInput)) {
                return email;
            }
        }
        return null;
    }

    // Method to populate the email array
    public static void populateEmailList(String[] emailList) {
        // Create an array of email IDs
        emailList[0] = "alpha.alpha@something.com";
        emailList[1] = "bravo.bravo@something.com";
        emailList[2] = "hotel.hotel@something.com";
        emailList[3] = "india.india@something.com";
        emailList[4] = "oscar.oscar@something.com";
        emailList[5] = "romeo.romeo@something.com";
        emailList[6] = "tango.tango@something.com";
    }
}
