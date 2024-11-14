package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestLoad2 {

    public static void testLoadNullRef(){
        try {
            Immobilienmakler ib1 = new Immobilienmakler("Makler 2");
            ib1.loadImmobilien2(null);
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testLoadFNFException(){
        try {
            Immobilienmakler ib1 = new Immobilienmakler("Makler 2");
            ib1.loadImmobilien2("K/src/main/java/at/spengergasse/immobilienmakler/save2/ImmobilienDaten1.ser");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testLoadIOException(){ //simuliert
        try {
            Immobilienmakler ib1 = new Immobilienmakler("Makler 2");
            ib1.loadImmobilien2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobilienDaten1.ser");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testLoadGueltig(){
        try {
            Immobilienmakler ib1 = new Immobilienmakler("Makler 2");
            ib1.loadImmobilien2("src\\main\\java\\at\\spengergasse\\immobilienmakler\\save2\\ImmobilienDaten44.ser");
            System.out.println(ib1.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
//        TestLoad2.testLoadNullRef();
//        TestLoad2.testLoadFNFException();
//        TestLoad2.testLoadIOException();
        TestLoad2.testLoadGueltig();
    }
}
