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


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatronManager manager = new PatronManager();

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        System.out.print("Enter path to patron data file (or press Enter to use 'patrons.txt'): ");
        String input = scanner.nextLine().trim();
        String filePath = input.isEmpty() ? "patrons.txt" : input;

        manager.loadPatrons(filePath);
        manager.listPatrons();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new patron");
            System.out.println("2. Remove patron");
            System.out.println("3. List all patrons");
            System.out.println("4. Calculate total fines");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            handleUserSelection(choice);
        }
    }

    public static void handleUserSelection(int choice) {
        switch (choice) {
            case 1:
                try {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter fine amount: ");
                    double fine = Double.parseDouble(scanner.nextLine());

                    manager.addPatron(new Patron(id, name, address, fine));
                    manager.listPatrons();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. ID and fine must be numbers.");
                }
                break;

            case 2:
                try {
                    System.out.print("Enter ID of patron to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    manager.removePatron(removeId);
                    manager.listPatrons();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. ID must be a number.");
                }
                break;

            case 3:
                manager.listPatrons();
                break;

            case 4:
                System.out.printf("Total fines: $%.2f\n", manager.calculateTotalFines());
                break;

            case 5:
                System.out.println("Exiting LMS. Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}
