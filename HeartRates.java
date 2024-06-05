// Programmer: Destiney Allen-Suarez, Viet Trinh Nguyen, Sofia Lacki
// Source: DD/W3school/ChatGBT
// Class: CS142
// Purpose: HeartRateCalculator class calculates and displays important heart rate information for a person,
// including their age, maximum heart rate, and target heart rate range. This helps people who want
// to exercise safely understand their heart's response to physical activity.

import java.util.Calendar;
import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private String birthDate;

    // Constructor to initialize the class with the person's first name, last name, and birth date
    public HeartRates(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = Integer.parseInt(birthDate.substring(6)); // Extracting the year part from the birth date
        if (birthYear < 1900) {
            throw new IllegalArgumentException("Year of birth cannot be earlier than 1900.");
        }
        return currentYear - birthYear;
    }
    
    public int getMaxHeartRate() {
        return 220 - getAge();
    }

    public int getMinimumHeartRate() {
        return (int) (getMaxHeartRate() * 0.5);
    }

    public int getMaximumHeartRate() {
        return (int) (getMaxHeartRate() * 0.85);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
    
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
    
        String birthDate;
        boolean validInput = false;

        do {
            System.out.println("Enter your birth date (MM/DD/YYYY):");
            birthDate = scanner.nextLine();
            // Validate the input format
            if (birthDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                int birthYear = Integer.parseInt(birthDate.substring(6));
                if (birthYear >= 1900) {
                    validInput = true;
                } else {
                    System.out.println("Year of birth cannot be earlier than 1900.");
                }
            } else {
                System.out.println("Invalid input format. Please enter the date in MM/DD/YYYY format.");
            }
        } while (!validInput);

        HeartRates person = new HeartRates(firstName, lastName, birthDate);
        System.out.println("First Name: " + person.getFirstName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Maximum Heart Rate: " + person.getMaxHeartRate());
        System.out.println("Target Heart Rate Range: " + person.getMinimumHeartRate() + " - " + person.getMaximumHeartRate());
    
        scanner.close(); // Closing the scanner to prevent resource leak
    }
}