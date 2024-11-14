package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;

public class TestSaveMakler  {

    public static void testSaveMaklerGueltig(){
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten2();
           immobilienmakler.saveMakler("src/main/java/at/spengergasse/immobilienmakler/save/");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testSaveMaklerNullRef(){
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
           immobilienmakler.saveMakler(null);
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testSaveMaklerFNFException(){
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
           immobilienmakler.saveMakler("K/src/main/java/at/spengergasse/immobilienmakler/save/");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testSaveMaklerIOException(){
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
           immobilienmakler.saveMakler("src/main/java/at/spengergasse/immobilienmakler/save/");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static final void main(String[] args){
        TestSaveMakler.testSaveMaklerGueltig();
//        TestSaveMakler.testSaveMaklerNullRef();
//        TestSaveMakler.testSaveMaklerFNFException();
//        TestSaveMakler.testSaveMaklerIOException();
    }
}
