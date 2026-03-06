/*
 * Fahrkartenautomat_M1
 * A6.3: Methoden
 */
import java.util.Scanner;

class Fahrkartenautomat_M1 {

	// method to say hello to user
	public static void begruessung() {
		System.out.println("Herzlich Willkommen!\n");
	}

	// method to get ticket choice and amount
	public static double fahrkartenbestellungErfassen(Scanner tastatur) {
		double priceForTicket = 0; 
		int anzahlTickets = 0;
		boolean inputOk = false;
		int userWahl = 0; 
		double zuZahlenderBetrag;

		System.out.println("Wählen Sie ihre Wunschfahrkarte für Birkenwerder AB aus:"); 
		System.out.println("Kurzstrecke AB [2,00 EUR] (1)"); 
		System.out.println("Einzelfahrschein AB [3,00 EUR] (2)"); 
		System.out.println("Tageskarte Regeltarif AB [8,80 EUR] (3)");
		System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)\n"); 
		
		while (inputOk == false) { 
			System.out.print("Ihre Wahl: "); 
			userWahl = tastatur.nextInt();
			if (userWahl >= 1 && userWahl <= 4) { 
				inputOk = true;
			} else { 
				System.out.println(" >>falsche Eingabe<< ");
			} 
		} 
		
		// assign the price
		if (userWahl == 1) priceForTicket = 2.0;
		else if (userWahl == 2) priceForTicket = 3.0; 
		else if (userWahl == 3) priceForTicket = 8.8;
		else if (userWahl == 4) priceForTicket = 9.4; 	 
		
		// how many tickets
		inputOk = false; // reset boolean
		
		while (inputOk == false) { 
			System.out.print("Anzahl der Tickets: ");
			anzahlTickets = tastatur.nextInt();
			if (anzahlTickets >= 1 && anzahlTickets <= 10) {
				inputOk = true;
			} else {
				System.out.println(" >> Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<\n");
			}
		} 
		
		zuZahlenderBetrag = priceForTicket * anzahlTickets;
		return zuZahlenderBetrag;
	}

	// user inserts coins here
	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double totalPaid = 0.0;
		double stillToPayAmount = 0.0;
		double einwurf;

		while (totalPaid < zuZahlenderBetrag) {
			stillToPayAmount = zuZahlenderBetrag - totalPaid;
			System.out.printf("Noch zu zahlen: %4.2f Euro\n", stillToPayAmount);

			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			einwurf = tastatur.nextDouble();
			totalPaid = totalPaid + einwurf;
		}
		return totalPaid;
	}

	// printing the ticket with dashed line
	public static void fahrkartenAusgeben() {
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 24; i++) {
			System.out.print("-");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
	}

	// calculate and give change back to user
	public static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag) {
		double rueckgeld;
		rueckgeld = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		
		if (rueckgeld > 0.0) {
			System.out.format("Der Rückgabebetrag in Höhe von %4.2f Euro \n", rueckgeld);
			System.out.println("wird in folgenden Münzen ausgezahlt:");
			
			// doing the coin calculation
			while (rueckgeld >= 2.0) { 
				System.out.println("2 Euro");
				rueckgeld = Math.round(rueckgeld * 100.0) / 100.0;
				rueckgeld = rueckgeld - 2.0;
			}
			while (rueckgeld >= 1.0) { 
				System.out.println("1 Euro");
				rueckgeld = Math.round(rueckgeld * 100.0) / 100.0;
				rueckgeld = rueckgeld - 1.0;
			}
			while (rueckgeld >= 0.5) { 
				System.out.println("50 Cent");
				rueckgeld = Math.round(rueckgeld * 100.0) / 100.0;
				rueckgeld = rueckgeld - 0.5;
			}
			while (rueckgeld >= 0.2) { 
				System.out.println("20 Cent");
				rueckgeld = Math.round(rueckgeld * 100.0) / 100.0;
				rueckgeld = rueckgeld - 0.2;
			}
			while (rueckgeld >= 0.1) { 
				System.out.println("10 Cent");
				rueckgeld = Math.round(rueckgeld * 100.0) / 100.0;
				rueckgeld = rueckgeld - 0.1;
			}
			while (rueckgeld >= 0.05) { 
				System.out.println("5 Cent");
				rueckgeld = Math.round(rueckgeld * 100.0) / 100.0;
				rueckgeld = rueckgeld - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
	}

	public static void main(String[] args) {
		double zuzahlenderBetrag;
		double eingezahlterGesamtbetrag;
		Scanner tastatur = new Scanner(System.in);

		begruessung();
		zuzahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuzahlenderBetrag);
		fahrkartenAusgeben();
		rueckgeldAusgeben(zuzahlenderBetrag, eingezahlterGesamtbetrag);

		tastatur.close();
	}
}