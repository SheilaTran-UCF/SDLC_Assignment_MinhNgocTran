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
public class Patron {
    private int id;
    private String name;
    private String address;
    private double fine;

    public Patron(int id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;
    }

    public int getId() {
        return id;
    }

    public double getFine() {
        return fine;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Address: %s, Fine: $%.2f", id, name, address, fine);
    }
}
