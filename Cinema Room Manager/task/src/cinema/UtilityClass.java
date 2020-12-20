package cinema;

import java.util.Arrays;

public class UtilityClass {
    int rows;
    int seats;
    char[][] seating;
    int rowNumber;
    int seatNumber;
    int currentIncome = 0;

    UtilityClass(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        this.setSeating();
    }

    public char[][] getSeating() {
        return seating;
    }

    public void setSeating() {
        this.seating = new char[this.rows][this.seats];
        for (char[] arr : this.seating) {
            Arrays.fill(arr, 'S');
        }
    }

    public void updateSeating(int rowNumber, int seatNumber) {
        seating[rowNumber-1][seatNumber-1] = 'B';
    }

    public int getTicketPrice() {
        int totalNumberOfSeats = rows * seats;
        if (totalNumberOfSeats <= 60) {
            return 10;
        } else {
            int front = rows / 2;
            if (rowNumber <= front) {
                return 10;
            } else {
                return 8;
            }
        }
    }

    public int calculateTotalIncome() {
        int totalNumberOfSeats = this.rows * seats;
        if (totalNumberOfSeats <= 60) {
            return totalNumberOfSeats * 10;
        } else {
            int front = rows / 2;
            return (front * seats * 10) + ((rows - front) * seats * 8);
        }
    }

    public void displayStatistics() {
        int numberOfPurchasedTickets = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (seating[i][j] == 'B') {
                    numberOfPurchasedTickets++;
                }
            }
        }
        int totalNumberOfSeats = rows * seats;
        double percentage = (double) (numberOfPurchasedTickets * 100) / totalNumberOfSeats;
        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.println("%");
        System.out.println("Current income: $" + this.currentIncome);
        System.out.println("Total income: $" + calculateTotalIncome());
    }
}
