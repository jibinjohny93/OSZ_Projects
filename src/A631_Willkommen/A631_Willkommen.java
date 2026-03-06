import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {
        
        // Requirement A6.3.1: Call the greeting method first
        greeting();

        Scanner keyboard = new Scanner(System.in);

        double totalSum = 0.0;
        double amountPaid = 0.0;
        double coin;
        double change;
        double remaining;
        int selection;
        int quantity;

        // Main selection loop
        while (true) {
            // This menu matches your console output exactly
            System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
            System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
            System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
            System.out.println("Tageskarte Regeltarif AB [8,80 EUR] (3)");
            System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
            System.out.println("Bezahlen (9)");
            
            System.out.print("\nIhre Wahl: ");
            selection = keyboard.nextInt();

            if (selection == 9) {
                if (totalSum > 0) {
                    break; 
                } else {
                    System.out.println(" >> Bitte wählen Sie erst eine Fahrkarte aus. <<");
                    continue;
                }
            }

            double price = 0.0;
            if (selection == 1) price = 2.00;
            else if (selection == 2) price = 3.00;
            else if (selection == 3) price = 8.80;
            else if (selection == 4) price = 9.40;
            else {
                System.out.println(" >>falsche Bedienung<<");
                continue;
            }

            // Get number of tickets
            while (true) {
                System.out.print("Anzahl der Tickets: ");
                quantity = keyboard.nextInt();
                if (quantity >= 1 && quantity <= 10) {
                    break;
                } else {
                    System.out.println(" >> Wählen Sie bitte eine Anzahl von 1 bis 10. <<");
                }
            }

            totalSum += price * quantity;
            System.out.printf("Zwischensumme: %.2f €\n\n", totalSum);
        }

        // Payment process
        while (amountPaid < totalSum) {
            remaining = totalSum - amountPaid;
            System.out.printf("Noch zu zahlen: %.2f €\n", remaining);
            System.out.print("Eingabe (0.05 bis 2.00 Euro): ");
            coin = keyboard.nextDouble();

            if (coin == 0.05 || coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1.0 || coin == 2.0) {
                amountPaid += coin;
            } else {
                System.out.println(" >> Kein gültiges Zahlungsmittel");
            }
        }

        // Issue ticket
        System.out.println("\nFahrschein wird ausgegeben");
        System.out.println("========");

        // Change calculation
        change = amountPaid - totalSum;
        if (change > 0.0) {
            System.out.printf("Rückgabe: %.2f Euro \n", change);
            
            // Payout logic
            double[] coins = {2.0, 1.0, 0.5, 0.2, 0.1, 0.05};
            for (double c : coins) {
                while (change >= c) {
                    System.out.printf("%.2f Euro\n", c);
                    change = Math.round((change - c) * 100.0) / 100.0;
                }
            }
        }

        System.out.println("\nGute Fahrt!");
        keyboard.close();
    }

    // A6.3.1: Specific greeting method
    public static void greeting() {
        System.out.println("Herzlich Willkommen!");
        System.out.println(); // Matches the blank line in the console
    }
}