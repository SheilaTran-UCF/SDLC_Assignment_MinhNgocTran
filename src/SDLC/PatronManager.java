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

// Manages a collection of Patron objects and basic operations on them
public class PatronManager {
    // In‑memory list that holds all Patron instances
    private List<Patron> patrons = new ArrayList<>();

    // ------------------------- File‑loading -------------------------

    /**
     * Reads patron records from a CSV‑style text file and populates the list.
     * @param filePath absolute or relative path to the data file
     */
    public void loadPatrons(String filePath) {
        patrons.clear();                     // Remove any existing patrons before loading new ones
        File file = new File(filePath);      // Wrap the provided path in a File object

        // Quick existence check so we can give a friendlier message than a generic exception
        if (!file.exists()) {
            System.out.println("Error: File not found -> " + filePath);
            return;                          // Abort the load operation
        }

        // Try‑with‑resources → ensures the reader is closed even if an exception occurs
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;                     // Will hold each line we read from the file

            // Read the file line‑by‑line until there are no more lines (i.e., readLine() returns null)
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");   // Split each line on commas to get CSV fields

                // Expect exactly 4 parts: id, name, address, fine
                if (parts.length != 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;                       // Skip malformed records but keep processing the rest
                }

                // Trim and convert the CSV strings to proper types
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String address = parts[2].trim();
                double fine = Double.parseDouble(parts[3].trim());

                // Create a new Patron object and add it to the list
                patrons.add(new Patron(id, name, address, fine));
            }
            System.out.println("Patrons loaded successfully."); // Report success after the loop ends
        } catch (IOException | NumberFormatException e) {        // Catch file I/O and parse errors
            System.out.println("Error loading patrons: " + e.getMessage());
        }
    }

    // ------------------------- CRUD operations -------------------------

    /**
     * Adds a single Patron to the list.
     * @param patron the new patron to add
     */
    public void addPatron(Patron patron) {
        patrons.add(patron);                 // Append to the existing list
        System.out.println("Patron added.");
    }

    /**
     * Removes a patron whose ID matches the given value (if present).
     * @param id unique identifier of the patron to remove
     */
    public void removePatron(int id) {
        patrons.removeIf(p -> p.getId() == id); // Java 8 lambda that removes matching patrons
        System.out.println("If patron existed, they were removed.");
    }

    /**
     * Prints each patron to the console, or a message if none exist.
     */
    public void listPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons to display.");
        } else {
            // Enhanced for‑loop prints each patron’s toString() representation
            for (Patron p : patrons) {
                System.out.println(p);
            }
        }
    }

    /**
     * @return sum of all fines owed by every patron
     */
    public double calculateTotalFines() {
        // Stream API → map each Patron to its fine, then sum all fines into a double
        return patrons.stream().mapToDouble(Patron::getFine).sum();
    }
}
