package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here

        //Get the row and seat number
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        UtilityClass util = new UtilityClass(rows, seats);

        //Display the menu
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                        return;
                case 1:
                        printSeatingArrangement(util);
                        break;
                case 2:
                        while (true) {
                            System.out.println("Enter a row number:");
                            util.rowNumber = scanner.nextInt();
                            System.out.println("Enter a seat number in that row:");
                            util.seatNumber = scanner.nextInt();
                            if (util.rowNumber > util.rows || util.seatNumber > util.seats) {
                                System.out.println("Wrong input");
                            } else if (util.seating[util.rowNumber-1][util.seatNumber-1] == 'B') {
                                System.out.println("That ticket has already been purchased!");
                            } else {
                                System.out.println("Ticket price: $" + util.getTicketPrice());
                                util.currentIncome += util.getTicketPrice();
                                util.updateSeating(util.rowNumber, util.seatNumber);
                                break;
                            }
                        }
                        break;

                case 3:
                        util.displayStatistics();
            }
        }
    }

    public static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }


    public static void printSeatingArrangement(UtilityClass util) {

        System.out.println("Cinema:");
        System.out.print("  ");
        for(int i = 1; i <= util.seats; i++) {
            System.out.print( " " + i);
        }
        System.out.println();
        for (int i = 0; i < util.rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < util.seats; j++) {
                    System.out.print(util.getSeating()[i][j] + " ");
                }
            System.out.println("");
        }

    }
}