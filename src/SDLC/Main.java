package SDLC; // Declares the package name SDLC
import java.util.Scanner; // Imports the Scanner class for user input


/**
 * Main.java
 *
 * This is the main entry point for the Library Management System (LMS) application.
 * It allows the user to manage patron records through a text-based menu.
 *
 * ===============================================
 * SDLC Documentation
 * ===============================================
 *
 * Step 1: Planning
 * - Goal: Build a console-based Library Management System.
 * - Scope: Manage patrons with options to load, add, remove, list, and calculate fines.
 *
 * Step 2: Analysis
 * - Input: File with patron data; user menu choices.
 * - Output: Console display of patrons and total fines.
 * - Functional Requirements:
 *   - Load patron data from file
 *   - Add/remove patrons
 *   - List patrons
 *   - Calculate total fines
 *
 * Step 3: Design
 * - Classes: Main, Patron, PatronManager
 * - Flow:
 *   User -> Menu -> PatronManager -> Patron List
 *
 * Step 4: Implementation
 * - Java classes implemented with OOP
 * - File I/O and menu loop handled in Main
 * - PatronManager manages the core logic
 *
 * Step 5: Deployment
 * - Compile:
 *     javac SDLC/*.java
 * - Run:
 *     java SDLC.Main
 * - Sample file format (CSV):
 *     101, John Doe, 123 Main St, 5.50
 *     102, Jane Smith, 456 Oak Ave, 0.00
 * - Full Code:
 *     See Main.java, Patron.java, and PatronManager.java for source code.
 *
 * ===============================================
 *
 *  Professor: Ashley Evans
 *  Student name: Minh Ngoc Tran
 *  Course: 202530-CEN-3024C-31774
 *  Date : May 18 - 2025
 *
 */

// Declares the Main class
public class Main {
    // Creates a Scanner object for reading user input from the console
    private static final Scanner scanner = new Scanner(System.in);

    // Creates an instance of PatronManager to manage patron-related operations
    private static final PatronManager manager = new PatronManager();

    // Main method - starts the application
    public static void main(String[] args) {
        // Calls method to display menu and start interaction
        displayMenu();
    }

    // Displays the main menu and handles the user loop
    public static void displayMenu() {
        // Prints the current working directory for reference
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // Prompts user to enter path to patron data file, or press Enter for default
        System.out.print("Enter path to patron data file (or press Enter to use 'patrons.txt'): ");
        String input = scanner.nextLine().trim(); // Reads user input and trims whitespace
        String filePath = input.isEmpty() ? "patrons.txt" : input; // Uses default if input is empty

        // Loads patrons from the specified file
        manager.loadPatrons(filePath);

        // Lists loaded patrons
        manager.listPatrons();

        // Infinite loop to keep the menu running until user exits
        while (true) {
            // Displays menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add new patron");
            System.out.println("2. Remove patron");
            System.out.println("3. List all patrons");
            System.out.println("4. Calculate total fines");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                // Attempts to read and parse user's menu selection
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // Catches invalid (non-numeric) input
                System.out.println("Invalid input. Please enter a number.");
                continue; // Restarts loop
            }

            // Processes the selected menu option
            handleUserSelection(choice);
        }
    }

    // Handles actions based on user's menu selection
    public static void handleUserSelection(int choice) {
        switch (choice) {
            case 1: // Add new patron
                try {
                    // Prompt and read patron ID
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    // Prompt and read patron name
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    // Prompt and read patron address
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    // Prompt and read patron fine
                    System.out.print("Enter fine amount: ");
                    double fine = Double.parseDouble(scanner.nextLine());

                    // Creates new Patron and adds to list
                    manager.addPatron(new Patron(id, name, address, fine));

                    // Lists updated patrons
                    manager.listPatrons();
                } catch (NumberFormatException e) {
                    // Handles invalid ID or fine input
                    System.out.println("Invalid input. ID and fine must be numbers.");
                }
                break;

            case 2: // Remove a patron
                try {
                    // Prompt and read ID of patron to remove
                    System.out.print("Enter ID of patron to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());

                    // Removes patron by ID
                    manager.removePatron(removeId);

                    // Lists updated patrons
                    manager.listPatrons();
                } catch (NumberFormatException e) {
                    // Handles invalid input
                    System.out.println("Invalid input. ID must be a number.");
                }
                break;

            case 3: // List all patrons
                manager.listPatrons(); // Displays list of patrons
                break;

            case 4: // Calculate total fines
                // Calculates and displays total fine amount
                System.out.printf("Total fines: $%.2f\n", manager.calculateTotalFines());
                break;

            case 5: // Exit the program
                System.out.println("Exiting LMS. Goodbye!");
                System.exit(0); // Terminates program
                break;

            default: // Handles invalid menu selection
                System.out.println("Invalid option. Try again.");
        }
    }
}