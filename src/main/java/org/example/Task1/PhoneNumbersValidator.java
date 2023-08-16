package org.example.Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumbersValidator {
    public static void main(String[] args) {
        String filename = "src/files/file.txt";
        validatePhoneNumbers(filename);
    }

    public static void validatePhoneNumbers(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
    }
}
