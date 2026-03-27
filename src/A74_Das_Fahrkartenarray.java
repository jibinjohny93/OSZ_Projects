/*
 * A7.4: Das Fahrkartenarray
 */
import java.util.Scanner;

public class A74_Das_Fahrkartenarray {

	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);

		// Arrays to manage ticket names and prices
		String[] ticketNamen = {
			"Einzelfahrschein AB", "Einzelfahrschein BC", "Einzelfahrschein ABC",
			"Kurzstrecke AB", "Tageskarte AB", "Tageskarte BC", "Tageskarte ABC",
			"4-Fahrten-Karte AB", "4-Fahrten-Karte BC", "4-Fahrten-Karte ABC",
			"Kleingruppen-Tageskarte AB", "Kleingruppen-Tageskarte BC", "Kleingruppen-Tageskarte ABC"
		};
		double[] ticketPreise = {
			3.0, 3.5, 3.8, 2.0, 8.6, 9.2, 10.0, 9.4, 12.6, 13.8, 25.5, 26.0, 26.5
		};

		begruessung(ticketNamen, ticketPreise);
		double zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur, ticketNamen, ticketPreise);
		double eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		fahrkartenAusgeben();
		rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtbetrag);

		tastatur.close();
	}

	// Dynamic menu based on the provided arrays
	public static void begruessung(String[] namen, double[] preise) {
		System.out.println("Herzlich Willkommen!");
		System.out.println("\nWählen Sie eine Fahrkarte aus:");
		for (int i = 0; i < namen.length; i++) {
			// Specific formatted output: name [price] (selection number)
			System.out.printf("%s [%.2f] (%d)\n", namen[i], preise[i], i + 1);
		}
	}

	// Captures selection and quantity using the arrays
	public static double fahrkartenbestellungErfassen(Scanner tastatur, String[] namen, double[] preise) {
		int auswahl;
		int anzahlTickets;

		System.out.print("Ihre Auswahl: ");
		auswahl = tastatur.nextInt();

		System.out.print("Anzahl der Tickets: ");
		anzahlTickets = tastatur.nextInt();

		// Calculate total based on array index (selection number - 1)
		return preise[auswahl - 1] * anzahlTickets;
	}

	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen = 0.0;
		double eingeworfeneMuenze;

		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag;
	}

	public static void fahrkartenAusgeben() {
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
	}

	public static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag) {
		double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;

		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			// Rounding to prevent floating point precision issues during subtraction
			rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;

			while (rueckgabebetrag >= 2.0) {
				System.out.println("2 Euro");
				rueckgabebetrag -= 2.0;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 1.0) {
				System.out.println("1 Euro");
				rueckgabebetrag -= 1.0;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 0.5) {
				System.out.println("50 Cent");
				rueckgabebetrag -= 0.5;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 0.2) {
				System.out.println("20 Cent");
				rueckgabebetrag -= 0.2;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 0.1) {
				System.out.println("10 Cent");
				rueckgabebetrag -= 0.1;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 0.05) {
				System.out.println("5 Cent");
				rueckgabebetrag -= 0.05;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
	}
}