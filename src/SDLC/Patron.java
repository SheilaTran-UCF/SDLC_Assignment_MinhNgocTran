package SDLC;

public class Patron {
    private int patronID;
    private String name;
    private String address;
    private double fineAmount;

    public Patron() {}

    public Patron(int patronID, String name, String address, double fineAmount) {
        this.patronID = patronID;
        this.name = name;
        this.address = address;
        this.fineAmount = fineAmount;
    }

    // Getters and Setters
    public int getPatronID() { return patronID; }
    public void setPatronID(int patronID) { this.patronID = patronID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getFineAmount() { return fineAmount; }
    public void setFineAmount(double fineAmount) { this.fineAmount = fineAmount; }

    @Override
    public String toString() {
        return patronID + ", " + name + ", " + address + ", $" + fineAmount;
    }
}