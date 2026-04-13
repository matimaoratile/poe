/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Mavenproject1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String firstname, lastname, username, password, cellnumber;

        // ===== REGISTRATION =====
        System.out.print("Enter First Name: ");
        firstname = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastname = input.nextLine();

        // Username validation loop
        do {
            System.out.print("Enter Username (must contain '_' and max 5 chars): ");
            username = input.nextLine();

            if (!checkUsername(username)) {
                System.out.println("Invalid username format. Try again.");
            }

        } while (!checkUsername(username));

        System.out.println("Username successfully captured.");

        // Password validation loop
        do {
            System.out.print("Enter Password (min 8 chars, 1 capital, 1 number, 1 special char): ");
            password = input.nextLine();

            if (!checkPasswordComplexity(password)) {
                System.out.println("Invalid password format. Try again.");
            }

        } while (!checkPasswordComplexity(password));

        System.out.println("Password successfully captured.");

        // Phone validation loop
        do {
            System.out.print("Enter Phone Number (+27 followed by 9 digits): ");
            cellnumber = input.nextLine();

            if (!checkCellNumber(cellnumber)) {
                System.out.println("Invalid phone number format. Try again.");
            }

        } while (!checkCellNumber(cellnumber));

        System.out.println("Cell number successfully captured.");

        // ===== LOGIN =====
        System.out.println("\n--- LOGIN ---");

        String loginUsername, loginPassword;
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter Username: ");
            loginUsername = input.nextLine();

            System.out.print("Enter Password: ");
            loginPassword = input.nextLine();

            if (loginUser(username, password, loginUsername, loginPassword)) {
                System.out.println("Login successful! Welcome " + firstname + " " + lastname);
                break;
            } else {
                attempts--;
                System.out.println("Incorrect details. Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Too many failed attempts. Access denied.");
        }

        input.close();
    }

    // Username validation
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public static boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return password.length() >= 8 && hasUpper && hasNumber && hasSpecial;
    }

    // Improved Cell number validation
    public static boolean checkCellNumber(String number) {
        return number.matches("\\+27\\d{9}");
    }

    // Login method
    public static boolean loginUser(String storedUsername, String storedPassword,
                                    String enteredUsername, String enteredPassword) {
        return storedUsername.equals(enteredUsername) &&
               storedPassword.equals(enteredPassword);
    }
}