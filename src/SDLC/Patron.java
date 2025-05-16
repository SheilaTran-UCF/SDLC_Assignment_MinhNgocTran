package SDLC; // Declares that this class belongs to the package named 'SDLC'

/*
 * Patron.java
 *
 * This class represents a Patron in the Library Management System.
 * It includes attributes for the patron's ID, name, address, and fine amount.
 *
 * Key Features:
 * - Constructors: A default and a parameterized constructor to initialize Patron objects.
 * - Getters and Setters: For accessing and modifying each field.
 * - toString() Method: Returns a formatted string representation of the patron's information.
 *
 * This class is used to store and manage individual patron records
 * within the SDLC-based Library Management System.
 *
 * Professor: Ashley Evans
 * Student name: Minh Ngoc Tran
 * Course:202530-CEN-3024C-31774
 * Date : May 18 - 2025
 *
 */
// Define the Patron class to represent a library patron
public class Patron {

    // Declare a private integer variable to store the patron's ID
    private int id;

    // Declare a private String variable to store the patron's name
    private String name;

    // Declare a private String variable to store the patron's address
    private String address;

    // Declare a private double variable to store the amount of fine owed by the patron
    private double fine;

    // Constructor to initialize a new Patron object with id, name, address, and fine
    public Patron(int id, String name, String address, double fine) {
        this.id = id;                 // Set the patron's ID
        this.name = name;             // Set the patron's name
        this.address = address;       // Set the patron's address
        this.fine = fine;             // Set the patron's fine amount
    }

    // Getter method to return the patron's ID
    public int getId() {
        return id;
    }

    // Getter method to return the patron's fine amount
    public double getFine() {
        return fine;
    }

    // Override the toString method to provide a formatted string representing the patron
    @Override
    public String toString() {
        // Format and return the patron's details as a string
        return String.format("ID: %d, Name: %s, Address: %s, Fine: $%.2f", id, name, address, fine);
    }
}
