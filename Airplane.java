/* This class is used to tell the main application the data for the airplane. */

public  class Airplane {

    /* This line begins the execution of this java application.  */

    private Passenger[][] seats;

    /* This line declares the 2D array of seats */

    public Airplane(int rows) {

        /* This line is the constructor and takes the integer rows and specifies 
           the amount of rows in the plane. */

        if (rows < 6 || rows > 50) {
            rows = 6;
        }

        /* This row checks the number of rows input into the main application. It 
           tells the application if the rows arent within this range it will default to 6. */

        seats = new Passenger[rows][4];
    }

    /* This line initializes the array for seat using the number of rows input and the default of 4 columns. */

    public int getRowCount() {
        return seats.length;
    }

    /* These lines return the number of rows in the airplane. */

    public int getColumnCount() {
        return seats[0].length;
    }

    /* These lines return the number of columns in the airplane. */

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }

    /* These lines establish a private helper method that checks whether the rows and 
       columns are within the bounds of the array. */

    public boolean addPassenger(Passenger p, int row, int col) {
        if (isInBounds(row, col) && seats[row][col] == null && p != null && p.isValidPassenger()) {
            seats[row][col] = p;
            return true;
        }
        return false;
    }

    /* These lines tell the app to add a passenger to a specific seat. */

    public Passenger removePassenger(int row, int col) {
        if (isInBounds(row, col)) {
            Passenger temp = seats[row][col];
            seats[row][col] = null;
            return temp;
        }
        return null;
    }

    /*These lines tell the app to remove a passenger from a specific seat. */

    public Passenger getPassenger(int row, int col) {
        if (isInBounds(row, col)) {
            return seats[row][col];
        }
        return null;
    }

    /* These lines get a passenger from a specific seat. */

    public boolean isOccupied(int row, int col) {
        return isInBounds(row, col) && seats[row][col] != null;
    }

    /* These lines check if a seat is occupied. */

}