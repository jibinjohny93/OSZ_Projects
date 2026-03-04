package A622_Passwort;

public class A622_Passwort {

    public static void main(String[] args) {
        System.out.println("Suche nach den 4 gueltigen Passwoertern...");
        
        // Wir testen alle Zahlen von 1 bis 1000
        for (int i = 1; i <= 1000; i++) {
            if (checkPasscode(i)) {
                System.out.println("Gueltige Zahl gefunden: " + i);
            }
        }
        
        System.out.println("Suche beendet.");
    }

    // Kopierte Methode aus der Aufgabe
    public static boolean checkPasscode(int H4X0R) {
        boolean result = false; 
        for (int E1337 = 42; E1337 <= (52 ^ (0x6c)); E1337 += (3 << (14 % 6))) { 
            if (result = ((++E1337 | E1337 + (2 >>> 1)) ^ (1 + H4X0R)) == (123456789 & 0)){
                break; 
            }
        } 
        return result;
    }
}