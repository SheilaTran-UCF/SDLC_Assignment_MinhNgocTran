package SDLC;
import java.io.*;
import java.util.*;


    public class PatronManager {
        private List<Patron> patrons = new ArrayList<>();

        // Load patrons from a file
        public void loadPatrons(String fileName) {
            try (Scanner scanner = new Scanner(new File(fileName))) {
                patrons.clear();
                while (scanner.hasNextLine()) {
                    String[] parts = scanner.nextLine().split(",");
                    if (parts.length == 4) {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        String address = parts[2].trim();
                        double fine = Double.parseDouble(parts[3].trim());
                        patrons.add(new Patron(id, name, address, fine));
                    }
                }
                System.out.println("Patrons loaded successfully.");
            } catch (Exception e) {
                System.out.println("Error loading patrons: " + e.getMessage());
            }
        }

        public void addPatron(Patron p) {
            patrons.add(p);
            System.out.println("Patron added.");
        }

        public void removePatron(int patronID) {
            boolean removed = patrons.removeIf(p -> p.getPatronID() == patronID);
            if (removed) {
                System.out.println("Patron removed.");
            } else {
                System.out.println("Patron not found.");
            }
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
            return patrons.stream().mapToDouble(Patron::getFineAmount).sum();
        }
    }


