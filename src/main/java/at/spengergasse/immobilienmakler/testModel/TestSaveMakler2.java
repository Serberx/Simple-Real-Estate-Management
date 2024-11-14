package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestSaveMakler2 {

    public static void testSaveMaklerNullRef(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.saveMakler2(null);
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }public static void testSaveMaklerFNFException(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.saveMakler2("K/src/main/java/at/spengergasse/immobilienmakler/save2");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testSaveMaklerIOException(){     //simuliert
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.saveMakler2("src/main/java/at/spengergasse/immobilienmakler/save2");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testSaveMaklerGueltig(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.saveMakler2("src/main/java/at/spengergasse/immobilienmakler/save2");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestSaveMakler2.testSaveMaklerNullRef();
//        TestSaveMakler2.testSaveMaklerFNFException();
//        TestSaveMakler2.testSaveMaklerIOException();
        TestSaveMakler2.testSaveMaklerGueltig();
    }
}
