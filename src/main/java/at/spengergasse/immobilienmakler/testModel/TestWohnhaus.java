package at.spengergasse.immobilienmakler.testModel;


import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.model.Wohnhaus;
import org.junit.Test;
//import org.junit.jupiter.api.Test;


public class TestWohnhaus {

   /* public static Wohnhaus erzeugeTestdaten()throws ImmobilienException{

                Wohnhaus w1 = new Wohnhaus(null,'A',   10000, 50 );     //adresse null
                Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ",'E',   10000, 50 ); //adresse ok, kategorie fail,
                Wohnhaus w3 = new Wohnhaus("Spengergasse 5, 1050 Wien ",'A',   9999, 50 ); //kategorie ok, einheitswert fail niedrig
                Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ",'A',   50000001, 50 ); //kategorie ok, einheitswert fail hoch
                Wohnhaus w5 = new Wohnhaus("Spengergasse 5, 1050 Wien ",'A',   10000, 48 );  //einheitswert ok, flaeche fail niedrig
                Wohnhaus w6 = new Wohnhaus("Spengergasse 5, 1050 Wien ",'A',   10000, 5001 ); //flaeche fail hoch

    }*/

  /*  public static void testAdresseNull() {
        try {
            Wohnhaus w1 = new Wohnhaus(null, 'A', 10000, 50);
            System.out.println(w1.getAdresse());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAdresseIsBlank() {
        try {
            Wohnhaus w1 = new Wohnhaus(" ", 'A', 10000, 50);
            System.out.println(w1.getAdresse());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAdresseOK() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 10000, 50);
            System.out.println(w2.getAdresse());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieFail() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'F', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieFailLowerCase() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'f', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOKLowerCase() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'a', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOK_A() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOK_B() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'B', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOK_C() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'C', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOK_D() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'D', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOK_a() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'a', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOK_b() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'b', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testKategorieOK_c() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'c', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void testKategorieOK_d() {
        try {
            Wohnhaus w2 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'd', 10000, 50);
            System.out.println(w2.getKategorie());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void testEinheitswertLow() {
        try {
            Wohnhaus w3 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 9999, 50);
//            Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ",'A',   50000001, 50 );
            System.out.println(w3.getEinheitswert());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testEinheitswertHigh() {
        try {
//            Wohnhaus w3 = new Wohnhaus("Spengergasse 5, 1050 Wien ",'A',   9999, 50 );
            Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 50000001, 50);
            System.out.println(w4.getEinheitswert());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void testFlaecheLow() {
        try {
            Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 50000000, 49);
            System.out.println(w4.getFlaeche());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void testFlaecheHight() {
        try {
            Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 50000000, 5001);
            System.out.println(w4.getFlaeche());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void testFlaecheGueltig() {
        try {
            Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 50000000, 300);
            System.out.println(w4.getFlaeche());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testBerechneEinheitswert() {
        try {
            Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 10000, 50);
            System.out.println(w4.berechneVerkehrswert());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }*/

    @Test
    public void testToString() {
        try {
            Wohnhaus w4 = new Wohnhaus("Spengergasse 5, 1050 Wien ", 'A', 10000, 50);
            Immobilienmakler im1 = new Immobilienmakler();
            im1.add(w4);
//            assert();
//            System.out.println(w4.toString());
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) {
//        testWohnhaus.testAdresseNull();
//        testWohnhaus.testAdresseIsBlank();
//        testWohnhaus.testAdresseOK();
//        testWohnhaus.testKategorieFail();
//        testWohnhaus.testKategorieFailLowerCase();
//        testWohnhaus.testKategorieOKLowerCase();
//        testWohnhaus.testKategorieOK_A();
//        testWohnhaus.testKategorieOK_B();
//        testWohnhaus.testKategorieOK_C();
//        testWohnhaus.testKategorieOK_D();
//        testWohnhaus.testKategorieOK_a();
//        testWohnhaus.testKategorieOK_b();
//        testWohnhaus.testKategorieOK_c();
//        testWohnhaus.testKategorieOK_d();
//        testWohnhaus.testEinheitswertLow();
//        testWohnhaus.testEinheitswertHigh();
//        testWohnhaus.testFlaecheLow();
//        testWohnhaus.testFlaecheHight();
        TestWohnhaus.testFlaecheGueltig();
//        testyyWohnhaus.testBerechneEinheitswert();
//        testWohnhaus.testToString();
    }*/
}
