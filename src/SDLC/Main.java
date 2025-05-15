package SDLC;
import java.util.Scanner;

//helllo


    public class Main {
        private static final Scanner scanner = new Scanner(System.in);
        private static final PatronManager manager = new PatronManager();

        public static void main(String[] args) {
            displayMenu();
        }

        public static void displayMenu() {
            System.out.print("Enter path to patron data file: ");
            String filePath = scanner.nextLine();
            manager.loadPatrons(filePath);
            manager.listPatrons();

            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add new patron");
                System.out.println("2. Remove patron");
                System.out.println("3. List all patrons");
                System.out.println("4. Calculate total fines");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                choice = Integer.parseInt(scanner.nextLine());

                handleUserSelection(choice);
            } while (choice != 5);
        }

        public static void handleUserSelection(int choice) {
            switch (choice) {
                case 1:
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
                    break;
                case 2:
                    System.out.print("Enter ID of patron to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    manager.removePatron(removeId);
                    manager.listPatrons();
                    break;
                case 3:
                    manager.listPatrons();
                    break;
                case 4:
                    System.out.printf("Total fines: $%.2f\n", manager.calculateTotalFines());
                    break;
                case 5:
                    System.out.println("Exiting LMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }


