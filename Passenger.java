/* This class is used to store the names and info for the passengers in the seat assignment app */

public class Passenger {

    /* This line begins the execution of this java application.  */

    private int id;
    private String firstName;
    private String lastName;
    private boolean validPassenger;

    /* These lines are instance variables and they store the data for the passengers ID 
       name and sets a boolean flag to determine the validity of the passengers data. */

    public Passenger(String idStr, String firstName, String lastName) {

        /* This line is the constructor that has the paramters for idstr, firstname and lastname. */

        try {
            this.id = Integer.parseInt(idStr);

            /* These lines are the try block. This trys to turn the string into an integer. */

            if (this.id <= 0 || firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
                validPassenger = false;
            } else {
                this.firstName = firstName;
                this.lastName = lastName;
                validPassenger = true;
            }

            /* These lines check to make sure the data is valid. if its not valid it changes valid 
               passenger to false indicating invalid data. if it is valid it assigns the appropriate 
               data to the intance variables and sets validPassenger to true. */

        } catch (NumberFormatException e) {
            validPassenger = false;
        }
    }

    /* These lines indicate what happens when the idstr fails, changing validPassenger to false. */

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /* These lines are getter methods and returns the ID, first name and last name. */

    public boolean isValidPassenger() {
        return validPassenger;
    }

    /* These lines are the method that check if the data is valid and returns the value of valid Passenger. */

    @Override
    public String toString() {
        return "Passenger ID number " + id + ": "+"Name: " + firstName + ", " + lastName;
    }
    /* These lines tell the program to override the tostring method and print the data in a specific format. */

}