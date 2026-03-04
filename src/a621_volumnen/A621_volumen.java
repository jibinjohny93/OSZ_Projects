package a621_volumnen;

public class A621_volumen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        double erstesVolumen = volumenWuerfel(3.0);
        System.out.println("Volumen von Wuerfel 1: " + erstesVolumen);
        
        double zweitesVolumen = volumenWuerfel(5.5);
        System.out.println("Volumen von Wuerfel 2: " + zweitesVolumen);
    }

    public static double volumenWuerfel(double seitenlaenge) {
        double volumen = seitenlaenge * seitenlaenge * seitenlaenge;
        return volumen; 
		

	}

}
