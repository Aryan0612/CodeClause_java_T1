import java.util.Scanner;

public class AirlineReservationSystem {
    private static boolean[] seats = new boolean[10];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter 1 for First Class");
            System.out.println("Enter 2 for Economy");
            int choice = scanner.nextInt();

            if (choice == 1) {
                if (reserveSeat("First Class")) {
                    break;
                }
            } else if (choice == 2) {
                if (reserveSeat("Economy")) {
                    break;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean reserveSeat(String seatClass) {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter your date of travel (dd/mm/yyyy): ");
        String date = scanner.next();

        System.out.print("Enter the airline name: ");
        String airline = scanner.next();

        if (seatClass.equals("First Class")) {
            for (int i = 0; i < 5; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    System.out.println("First Class seat reserved. Seat number: " + (i + 1));
                    System.out.println("Name: " + name);
                    System.out.println("Date of travel: " + date);
                    System.out.println("Airline: " + airline);
                    return true;
                }
            }

            System.out.println("First Class is full. Would you like to reserve an Economy seat instead? (y/n)");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("y")) {
                return reserveSeat("Economy");
            } else {
                return false;
            }
        } else if (seatClass.equals("Economy")) {
            for (int i = 5; i < 10; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    System.out.println("Economy seat reserved. Seat number: " + (i + 1));
                    System.out.println("Name: " + name);
                    System.out.println("Date of travel: " + date);
                    System.out.println("Airline: " + airline);
                    return true;
                }
            }

            System.out.println("Economy is full. Would you like to reserve a First Class seat instead? (y/n)");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("y")) {
                return reserveSeat("First Class");
            } else {
                return false;
            }
        } else {
            System.out.println("Invalid seat class. Please try again.");
            return false;
        }
    }
}
