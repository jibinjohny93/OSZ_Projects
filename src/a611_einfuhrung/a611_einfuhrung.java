import java.util.Scanner;

class TicketMachine {
    public static void main(String[] args) {
        
        // A6.3.1: Calling the greeting method at the start
        greeting();

        Scanner keyboard = new Scanner(System.in);

        double totalSum = 0.0;
        double totalPaid = 0.0;
        double insertedCoin;
        double changeAmount;
        double stillToPay;
        int choice;
        int ticketCount;

        // Selection loop for multiple tickets
        while (true) {
            System.out.println("Please choose your ticket for Berlin AB:");
            System.out.println("Short distance AB [2.00 EUR] (1)");
            System.out.println("Single ticket AB [3.00 EUR] (2)");
            System.out.println("Day pass Regular AB [8.80 EUR] (3)");
            System.out.println("4-Trip-Ticket AB [9.40 EUR] (4)");
            System.out.println("Pay now (9)");
            
            System.out.print("\nYour choice: ");
            choice = keyboard.nextInt();

            // Exit loop to start payment
            if (choice == 9) {
                if (totalSum > 0) {
                    break; 
                } else {
                    System.out.println(" >> Please select a ticket before paying. <<");
                    continue;
                }
            }

            // Setting the price based on choice
            double ticketPrice = 0.0;
            if (choice == 1) {
                ticketPrice = 2.00;
            } else if (choice == 2) {
                ticketPrice = 3.00;
            } else if (choice == 3) {
                ticketPrice = 8.80;
            } else if (choice == 4) {
                ticketPrice = 9.40;
            } else {
                System.out.println(" >> Invalid selection <<");
                continue;
            }

            // Asking for ticket quantity
            while (true) {
                System.out.print("Number of tickets: ");
                ticketCount = keyboard.nextInt();
                if (ticketCount >= 1 && ticketCount <= 10) {
                    break;
                } else {
                    System.out.println(" >> Please choose between 1 and 10 tickets. <<");
                }
            }

            // Update the total sum
            totalSum += ticketPrice * ticketCount;
            System.out.printf("Intermediate total: %.2f €\n\n", totalSum);
        }

        // Payment process
        while (totalPaid < totalSum) {
            stillToPay = totalSum - totalPaid;
            System.out.printf("Still to pay: %.2f €\n", stillToPay);
            System.out.print("Insert coin (0.05 to 2.00 Euro): ");
            insertedCoin = keyboard.nextDouble();

            // Checking for valid coins
            if (insertedCoin == 0.05 || insertedCoin == 0.1 || insertedCoin == 0.2 || 
                insertedCoin == 0.5 || insertedCoin == 1.0 || insertedCoin == 2.0) {
                totalPaid += insertedCoin;
            } else {
                System.out.println(" >> Invalid coin");
            }
        }

        // Issuing the ticket
        System.out.println("\nTicket is being issued");
        System.out.println("========");

        // Calculating and paying out change
        changeAmount = totalPaid - totalSum;
        if (changeAmount > 0.0) {
            System.out.printf("Your change of %.2f Euro \n", changeAmount);
            System.out.println("will be paid in the following coins:");

            // Returning coins from largest to smallest
            while (changeAmount >= 2.0) {
                System.out.println("2 Euro");