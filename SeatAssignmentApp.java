/* This application is used to assign passengers to seats on an airplane. */


import java.util.Scanner;

/* This application uses a scanner. */

public class SeatAssignmentApp {

    /* This line begins the execution of this java application.  */

    private static Scanner input = new Scanner(System.in);

    /* This line sets up the scanner. */

    public static void main(String[] args) {

        /* This is the entry point of the application. */

        System.out.println("Please enter the number of rows on the airplane:");
        int rows = parseIntInput();
        Airplane plane = new Airplane(rows);

        /* These lines instruct the user to input the amount of rows the plane has, 
           and stores the info. */

        boolean running = true;
        while (running) {
            printMenu();
            String choice = input.nextLine();
            if (choice.equals("1")) {
                addPassenger(plane);
            } else if (choice.equals("2")) {
                findPassenger(plane);
            } else if (choice.equals("3")) {
                removePassenger(plane);
            } else if (choice.equals("4")) {
                displayPassengers(plane);
            } else if (choice.equals("5")) {
                displayEmptySeats(plane);
            } else if (choice.equals("6")) {
                running = false;
            } else {
                    System.out.println("Error! Invalid option.");
            }
        }
    }

    /* These lines set up the menu and what happens when each choice is input. 
       It loops until user chooses to exit. */

    private static void printMenu() {
        System.out.println("\n1. Add a Passenger");
        System.out.println("2. Find a Passenger");
        System.out.println("3. Remove a Passenger");
        System.out.println("4. Display ALL Passengers");
        System.out.println("5. Display Empty Seats");
        System.out.println("6. Exit program");
        System.out.print("Please choose an option: ");
    }

    /* These lines print the menu options. */

    private static void addPassenger(Airplane plane) {
        System.out.print("Please enter passenger ID: ");
        String id = input.nextLine();
        System.out.print("Please enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Please enter last name: ");
        String lastName = input.nextLine();

        Passenger p = new Passenger(id, firstName, lastName);
        if (!p.isValidPassenger()) {
            System.out.println("Error! Invalid passenger details.");
            return;
        }

        /* These lines indicate what happens when option 1 is chosen, 
           prompting the user to input the passengers id and name and 
           storing it in the appropriate variables. If the data isnt 
           valid an error message is diaplayed. */

        System.out.print("Please enter a row number: ");
        int row = parseIntInput();
        System.out.print("Please enter a column number (0-3): ");
        int col = parseIntInput();

        /* These lines ask the user to input data and it converts the data 
           into an integer and stores it in a variable. */

        if (plane.addPassenger(p, row, col)) {
            System.out.println("Passenger added successfully.");
        } else {
            System.out.println("Error! Failed to add passenger.");
        }
    }

    /* These lines make the code try to add the passenger if successful it prints out a confirmation, 
       and an error message if it wasn't. */

    private static void findPassenger(Airplane plane) {
        System.out.print("Please enter row number: ");
        int row = parseIntInput();
        System.out.print("Please enter column number: ");
        int col = parseIntInput();

        /* These lines are a helper method that tells the program to find a passenger 
           and display a passenger by seat location. They prompt the user to input a 
           row and column to find that passeger.  */

        Passenger p = plane.getPassenger(row, col);
        if (p != null) {
            System.out.println("Passenger found: " + p);
        } else {
            System.out.println("Sorry, there is no passenger in that seat.");
        }
    }

    /* These lines retrieve the passenger from the given seat. If the seat is 
       occupied it will print the passengers information, if not it will display an error message. */

    private static void removePassenger(Airplane plane) {
        System.out.print("Please enter row number: ");
        int row = parseIntInput();
        System.out.print("Please enter column number: ");
        int col = parseIntInput();

        /* These lines are a helper method that tells the program to remove a passenger by seat location.
           They prompt the user to input the row and column number to remove a passenger from that seat.  */

        Passenger p = plane.removePassenger(row, col);
        if (p != null) {
            System.out.println("Passenger removed: " + p);
        } else {
            System.out.println("Sorry, there is no passenger in that seat.");
        }
    }

    /* These lines retrieve the passenger from the given seat and if the seat is occupied it 
       removes them from the seat. If not it displays an error message. */

    private static void displayPassengers(Airplane plane) {
        for (int i = 0; i < plane.getRowCount(); i++) {
            for (int j = 0; j < plane.getColumnCount(); j++) {
                Passenger p = plane.getPassenger(i, j);
                if (p != null) {
                    System.out.println("Row: " + i + ", Column: " + j + ", " + p);
                }
            }
        }
    }

    /* These lines are a helper method to display all passengers in the plane. It 
       loops through every seat and if a passenger is there it displays their info.  */

    private static void displayEmptySeats(Airplane plane) {
        for (int i = 0; i < plane.getRowCount(); i++) {
            for (int j = 0; j < plane.getColumnCount(); j++) {
                if (!plane.isOccupied(i, j)) {
                    System.out.println("Row " + i + ", column " + j);
                }
            }
        }
    }

    /* These lines are a helper method to display all empty seats in the plane. It 
       loops through every seat and if a passenger is not there it displays the seat
       
       info.  */

    private static int parseIntInput() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }

        /* These lines are a private method used to safely read an integer from the user.
           And it parses the the integer. if the input is not a valid integer it returns -1.
           to indicate invalid input.  */

    }
}