package SDLC;  // Defines the package name SDLC for organizing related classes.

import java.io.*;       // Imports classes for input/output operations.
import java.util.*;     // Imports utility classes like List, ArrayList, Scanner, Iterator, etc.

/**
 * PatronManager.java
 *
 * This class is responsible for managing library patrons in a console-based
 * Library Management System. It provides methods to:
 *
 * - Load patron data from a text file (CSV format)
 * - Add a new patron
 * - Remove an existing patron by ID
 * - List all patrons
 * - Calculate the total fine amount owed by all patrons
 *
 * The data is stored in a dynamic list using an ArrayList of Patron objects.
 * File input is handled using Java's Scanner class, and basic error handling
 * is included to manage issues like file not found or parsing errors.
 *
 * Assumes a separate Patron class exists with appropriate constructors,
 * getter methods (especially getPatronID() and getFineAmount()), and
 * a meaningful toString() override for display.
 *
 *  Professor: Ashley Evans
 *  Student name: Minh Ngoc Tran
 *  Course:202530-CEN-3024C-31774
 *  Date : May 18 - 2025
 *
 */
import java.io.*;
import java.util.*;

public class PatronManager {
    private List<Patron> patrons = new ArrayList<>();

    public void loadPatrons(String filePath) {
        patrons.clear();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Error: File not found -> " + filePath);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String address = parts[2].trim();
                double fine = Double.parseDouble(parts[3].trim());

                patrons.add(new Patron(id, name, address, fine));
            }
            System.out.println("Patrons loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading patrons: " + e.getMessage());
        }
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron added.");
    }

    public void removePatron(int id) {
        patrons.removeIf(p -> p.getId() == id);
        System.out.println("If patron existed, they were removed.");
    }

    public void listPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons to display.");
        } else {
            for (Patron p : patrons) {
                System.out.println(p);
            }
        }
    }

    public double calculateTotalFines() {
        return patrons.stream().mapToDouble(Patron::getFine).sum();
    }
}
