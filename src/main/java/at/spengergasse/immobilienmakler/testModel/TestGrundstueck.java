package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Grundstueck;

public class TestGrundstueck {

    public static void testAdresse(){
        try {
            Grundstueck g1 = new Grundstueck(null, 100, 'B', 10);
            System.out.println(g1.getAdresse());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAdresseLeerzeichen() {
        try {
            Grundstueck g1 = new Grundstueck(" ", 100, 'B', 10);
            System.out.println(g1.getAdresse());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testWidmungB() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1/1, 1111 Wien ", 100, 'B', 10);
            System.out.println(g1.getWidmung());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testWidmungG() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1/1, 1111 Wien ", 100, 'G', 10);
            System.out.println(g1.getWidmung());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testWidmungN() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1/1, 1111 Wien ", 100, 'N', 10);
            System.out.println(g1.getWidmung());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Ungueltiger Wert Enum in der Tesklasse. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testQmPreisLow() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 100, 'B', 0);
            System.out.println(g1.getQmPreis());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testQmPreisHigh() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 100, 'B', 10000.1);
            System.out.println(g1.getQmPreis());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testQmPreisGueltig() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 100, 'B', 500);
            System.out.println(g1.getQmPreis());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testFlaecheLow() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 99, 'B', 500);
            System.out.println(g1.getQmPreis());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testFlaecheHigh() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 100000.1, 'B', 500);
            System.out.println(g1.getQmPreis());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testFlaecheGueltig() {
        try {
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 10000, 'B', 500);
            System.out.println(g1.getQmPreis());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testBerechneVerkehrswert(){
        try{
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 10000, 'B', 500);
            System.out.println(g1.berechneVerkehrswert());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testBerechneVerkehrswert2(){
        try{
            Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 1000, 'B', 10);
            System.out.println(g1.berechneVerkehrswert());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        testGrundstueck.testAdresse();
//        testGrundstueck.testAdresseLeerzeichen();
//        testGrundstueck.testWidmungB();
//        testGrundstueck.testWidmungG();
//        testGrundstueck.testWidmungN();
//        testGrundstueck.testQmPreisLow();
//        testGrundstueck.testQmPreisHigh();
//        testGrundstueck.testQmPreisGueltig();
//        testGrundstueck.testFlaecheLow();
//        testGrundstueck.testFlaecheHigh();
//        testGrundstueck.testFlaecheGueltig();
//        testGrundstueck.testBerechneVerkehrswert();
//        testGrundstueck.testBerechneVerkehrswert2();
    }
}
