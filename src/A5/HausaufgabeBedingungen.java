package A5;

import java.util.Scanner;

public class HausaufgabeBedingungen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Teil 1: 2 Zahlen
        System.out.println("------- Teil 1 -------");
        System.out.print("Bitte 1. Zahl eingeben: ");
        int zahl1 = scan.nextInt();
        System.out.print("Bitte 2. Zahl eingeben: ");
        int zahl2 = scan.nextInt();

        // 1. Alltagsbeispiel
        System.out.println("Aufgabe 1 (Alltag): Wenn ich nach Birkenwerder fahre, nehme ich die S-Bahn.");

        // 2. Gleiche Zahlen
        if (zahl1 == zahl2) {
            System.out.println("Aufgabe 2: Beide Zahlen sind genau gleich!");
        }

        // 3. 2. Zahl groesser als 1. Zahl
        if (zahl2 > zahl1) {
            System.out.println("Aufgabe 3: Die zweite Zahl ist groesser als die erste.");
        }

        // 4. If-Else
        if (zahl1 >= zahl2) {
            System.out.println("Aufgabe 4: Die erste Zahl ist groesser oder gleich der zweiten.");
        } else {
            System.out.println("Aufgabe 4: Die zweite Zahl ist wohl doch groesser...");
        }

        System.out.println("\n---------------------------\n");

        // Teil 2: 3 Zahlen testen
        System.out.println("------- Teil 2 -------");
        System.out.print("Jetzt die 1. Zahl: ");
        int z1 = scan.nextInt();
        System.out.print("Und die 2. Zahl: ");
        int z2 = scan.nextInt();
        System.out.print("Zuletzt die 3. Zahl: ");
        int z3 = scan.nextInt();

        // 1. && (Und) Bedingung
        if (z1 > z2 && z1 > z3) {
            System.out.println("Aufgabe 1: Die 1. Zahl ist der Boss (groesser als die anderen beiden).");
        }

        // 2. || (Oder) Bedingung
        if (z3 > z2 || z3 > z1) {
            System.out.println("Aufgabe 2: Die 3. Zahl ist groesser als die erste ODER zweite Zahl.");
        }

        scan.close();
    }
}