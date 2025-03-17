import java.util.Scanner;
import java.util.regex.Pattern;


// Main class for managing cinema tickets
public class CinemaManagement {
    public static final int rows = 3;
    public static final int seatsPerRow = 16;
    public static final int[][] seats = new int[rows][seatsPerRow];
    public static Ticket[] tickets = new Ticket[rows * seatsPerRow];
    public static int ticketCount = 0;

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the London Lumiere.");

        // Loop for menu options
        while (running) {
            System.out.println("\nWelcome to the London Lumiere");
            System.out.println("------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("  1) Buy a ticket");
            System.out.println("  2) Cancel a ticket");
            System.out.println("  3) See seating plan");
            System.out.println("  4) Find first seat available");
            System.out.println("  5) Print tickets information and total price");
            System.out.println("  6) Search ticket");
            System.out.println("  7) Sort tickets by price");
            System.out.println("  8) Exit");
            System.out.println("------------------------------------------------");
            System.out.println("Select Option:\n");

            int choice = getUserInputRange(scanner);
            switch (choice) {
                case 1:
                    buy_ticket(scanner);
                    break;
                case 2:
                    cancel_ticket(scanner);
                    break;
                case 3:
                    seating_plan();
                    break;
                case 4:
                    find_first_available();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket(scanner);
                    break;
                case 7:
                    sort_tickets();
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    System.out.println("Thank you for your co-operation.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
        System.exit(0);
    }

    public static int getUserInputRange(Scanner scanner) {
        int userInput;
        while (true) {
            System.out.println("Please enter a number between 1-7 to select options(enter 8 to Exit.)\n");

            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput >= 1 && userInput <= 8) {
                    break; // Exit from the loop if inputs are within the range
                } else {
                    System.out.println("Entered input is out of range. Please try again.");
                }
            } else {
                System.out.println("Entered input is not an integer. Please try again.");
                scanner.next();
            }
        }
        return userInput;
    }

    public static void buy_ticket(Scanner scanner) {
        System.out.println("Buy a Seat...\n");
        int rowNumber, seatNumber;

        // Prompt user for a valid row number
        while (true) {
            System.out.println("Enter the row number (1, 2, or 3):");
            if (scanner.hasNextInt()) {
                rowNumber = scanner.nextInt();
                if (rowNumber >= 1 && rowNumber <= 3) {
                    break;
                } else {
                    System.out.println("Invalid row number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        // Prompt user for a valid seat number
        while (true) {
            System.out.println("Enter the seat number (1 to 16):");
            if (scanner.hasNextInt()) {
                seatNumber = scanner.nextInt();
                if (seatNumber >= 1 && seatNumber <= 16) {
                    if (seats[rowNumber - 1][seatNumber - 1] == 0) {
                        seats[rowNumber - 1][seatNumber - 1] = 1; // Mark seat as sold
                        System.out.println("The seat has been booked.");
                        break;
                    } else {
                        System.out.println("This seat is not available.");
                    }
                } else {
                    System.out.println("Invalid seat number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
        //Regex Patterns
        String namePattern = "^[A-Za-z]{3,}(\\s[A-Za-z]{3,})?$";
        String surnamePattern = "^[A-Za-z]{3,}(\\s[A-Za-z]{3,})?$";
        String emailPattern = "^[A-Za-z0-9+.]+@(.+)$";

        //Get person details
        String name = "";
        String surname = "";
        String email = "";

        scanner.nextLine();

        // Validate name
        while (true) {
            System.out.println("Enter your name:");
            name = scanner.nextLine();
            if (Pattern.matches(namePattern, name)) {
                break;
            } else {
                System.out.println("Invalid name format. Please enter a valid name.");
            }
        }

        //Validate surname
        while (true) {
            System.out.println("Enter your surname:");
            surname = scanner.nextLine();
            if (Pattern.matches(surnamePattern, surname)) {
                break;
            } else {
                System.out.println("Invalid name format. Please enter a valid surname.");
            }
        }

        //Validate email
        while (true) {
            System.out.println("Enter your email:");
            email = scanner.nextLine();
            if (Pattern.matches(emailPattern, email)) {
                break;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }


        //Calculate price based on row number
        double price;
        if (rowNumber == 1) {
            price = 12.0;
        } else if (rowNumber == 2) {
            price = 10.0;
        } else {
            price = 8.0;
        }

        //Create & adding ticket to the list
        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(rowNumber, seatNumber, price, person);
        tickets[ticketCount++] = ticket;
        System.out.println("The seat has been booked.");
    }

    public static void cancel_ticket(Scanner scanner) {
        System.out.println("Cancel a Seat...\n");
        int rowNumber, seatNumber;

        // Prompt user for a valid row number
        while (true) {
            System.out.println("Enter the row number (1, 2, or 3):");
            if (scanner.hasNextInt()) {
                rowNumber = scanner.nextInt();
                if (rowNumber >= 1 && rowNumber <= 3) {
                    break;
                } else {
                    System.out.println("Invalid row number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        // Prompt user for a valid seat number
        while (true) {
            System.out.println("Enter the seat number (1 to 16):");
            if (scanner.hasNextInt()) {
                seatNumber = scanner.nextInt();
                if (seatNumber >= 1 && seatNumber <= 16) {
                    if (seats[rowNumber - 1][seatNumber - 1] == 1) {
                        seats[rowNumber - 1][seatNumber - 1] = 0; // Mark seat as available

                        //Remove the corresponding ticket from the tickets Arraylist
                        removeTicket(rowNumber, seatNumber);

                        System.out.println("The seat has been cancelled.");
                        break;
                    } else {
                        System.out.println("This seat is already available.");
                    }
                } else {
                    System.out.println("Invalid seat number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static void removeTicket(int rowNumber, int seatNumber) {
        for (int i = 0; i < ticketCount; i++) {
            Ticket ticket = tickets[i];
            if (ticket.getRow() == rowNumber && ticket.getSeat() == seatNumber) {
                for (int j = i; j < ticketCount - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--ticketCount] = null;
                return;
            }
        }
    }

    public static void seating_plan() {
        System.out.println("\nSeating Plan:\n");
        System.out.println("************************************************");
        System.out.println("*                    Screen                    *");
        System.out.println("************************************************\n");
        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.print(seats[i][j] == 0 ? "O " : "X ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
        System.out.println("Screen this way");
        System.out.println("------------------------------------------------");
    }

    public static void find_first_available() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (seats[i][j] == 0) {
                    System.out.println("First available seat: Row " + (i + 1) + " Seat " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    public static void print_tickets_info() {
        System.out.println("\nTickets Information:");
        System.out.println("------------------------------------------------");
        double totalPrice = 0.0;
        for (int i = 0; i < ticketCount; i++) {
            System.out.println(tickets[i]);
            totalPrice += tickets[i].getPrice();
        }
        System.out.println("------------------------------------------------");
        System.out.println("Total Price: £" + totalPrice);
    }

    public static void search_ticket(Scanner scanner) {
        System.out.println("\nSearch for a Ticket:");
        System.out.println("------------------------------------------------");
        int rowNumber;
        int seatNumber;

        //Prompts user for a valid row number
        while (true) {
            System.out.println("Enter the row number (1, 2, or 3):\n");
            if (scanner.hasNextInt()) {
                rowNumber = scanner.nextInt();
                if (rowNumber >= 1 && rowNumber <= 3) {
                    break;
                } else {
                    System.out.println("Invalid row number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }


        }

        //Prompt user for a valid seat number
        while (true) {
            System.out.println("Enter the seat number (1 to 16):");
            if (scanner.hasNextInt()) {
                seatNumber = scanner.nextInt();
                if (seatNumber >= 1 && seatNumber <= 16) {
                    break;
                } else {
                    System.out.println("Invalid seat number. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        //Check if the seat is booked
        if (seats[rowNumber - 1][seatNumber - 1] == 1) {
            //Search for the ticket
            Ticket foundTicket = null;
            for (int i = 0; i < ticketCount; i++) {
                if (tickets[i].getRow() == rowNumber && tickets[i].getSeat() == seatNumber) {
                    foundTicket = tickets[i];
                    break;
                }
            }

            if (foundTicket != null) {
                System.out.println("Ticket found:");
                System.out.println(foundTicket);
                System.out.println("Person Information:");
                System.out.println(foundTicket.getPerson());
            } else {
                System.out.println("Error found: Ticket not found in the system.");
            }
        } else {
            System.out.println("This seat is available.");
        }

    }

    public static void sort_tickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets to sort.");
            return;
        }

        //Bubble sort algorithm
        for (int i = 0; i < ticketCount - 1; i++) {
            for (int j = 0; j < ticketCount - i - 1; j++) {
                if (tickets[j].getPrice() > tickets[j + 1].getPrice()) {
                    //Swap tickets
                    Ticket temp = tickets[j];
                    tickets[j] = tickets[j + 1];
                    tickets[j + 1] = temp;
                }
            }
        }
        //Print sorted tickets
        System.out.println("\nSorted tickets by price (Ascending order):");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < ticketCount; i++) {

            System.out.println(tickets[i]);
        }
        System.out.println("------------------------------------------------");
    }
}
