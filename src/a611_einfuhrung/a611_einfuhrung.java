import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {
        
        // A6.3.1: Method call
        begruessung();

        Scanner tastatur = new Scanner(System.in);

        double gesamtsumme = 0.0;
        double eingezahlterGesamtbetrag = 0.0;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;
        int wahl;
        int anzahlTickets;

        // Auswahl-Schleife
        while (true) {
            System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
            System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
            System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
            System.out.println("Tageskarte Regeltarif AB [8,80 EUR] (3)");
            System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
            System.out.println("Bezahlen (9)");
            
            System.out.print("\nIhre Wahl: ");
            wahl = tastatur.nextInt();

            if (wahl == 9) {
                if (gesamtsumme > 0) {
                    break; 
                } else {
                    System.out.println(" >> Bitte wählen Sie erst eine Fahrkarte aus, bevor Sie bezahlen. <<");
                    continue;
                }
            }

            double ticketPreis = 0.0;
            if (wahl == 1) {
                ticketPreis = 2.00;
            } else if (wahl == 2) {
                ticketPreis = 3.00;
            } else if (wahl == 3) {
                ticketPreis = 8.80;
            } else if (wahl == 4) {
                ticketPreis = 9.40;
            } else {
                System.out.println(" >>falsche Bedienung<<");
                continue;
            }

            while (true) {
                System.out.print("Anzahl der Tickets: ");
                anzahlTickets = tastatur.nextInt();
                if (anzahlTickets >= 1 && anzahlTickets <= 10) {
                    break;
                } else {
                    System.out.println(" >> Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<");
                }
            }

            gesamtsumme += ticketPreis * anzahlTickets;
            System.out.printf("Zwischensumme: %.2f €\n\n", gesamtsumme);
        }

        // Geldeinwurf
        while (eingezahlterGesamtbetrag < gesamtsumme) {
            nochZuZahlen = gesamtsumme - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %.2f €\n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();

            if (eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.1 || eingeworfeneMuenze == 0.2 || 
                eingeworfeneMuenze == 0.5 || eingeworfeneMuenze == 1.0 || eingeworfeneMuenze == 2.0) {
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            } else {
                System.out.println(" >> Kein gültiges Zahlungsmittel");
            }
        }

        System.out.println("\nFahrschein wird ausgegeben");
        System.out.println("========");

        rueckgabebetrag = eingezahlterGesamtbetrag - gesamtsumme;
        if (rueckgabebetrag > 0.0) {
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro \n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) {
                System.out.println("2 Euro");
                rueckgabebetrag = Math.round((rueckgabebetrag - 2.0) * 100.0) / 100.0;
            }
            while (rueckgabebetrag >= 1.0) {
                System.out.println("1 Euro");
                rueckgabebetrag = Math.round((rueckgabebetrag - 1.0) * 100.0) / 100.0;
            }
            while (rueckgabebetrag >= 0.5) {
                System.out.println("50 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.5) * 100.0) / 100.0;
            }
            while (rueckgabebetrag >= 0.2) {
                System.out.println("20 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.2) * 100.0) / 100.0;
            }
            while (rueckgabebetrag >= 0.1) {
                System.out.println("10 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.1) * 100.0) / 100.0;
            }
            while (rueckgabebetrag >= 0.05) {
                System.out.println("5 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.05) * 100.0) / 100.0;
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein vor Fahrtantritt entwerten zu lassen!");
        System.out.println("Wir wünschen Ihnen eine gute Fahrt.");
        
        tastatur.close();
    }

    // Methode für A6.3.1
    public static void begruessung() {
        System.out.println("Herzlich Willkommen!");
        System.out.println();
    }
}