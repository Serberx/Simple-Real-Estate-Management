package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestLoadMakler2 {

    public static void testloadMaklerNullRef(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler2(null);
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testloadMaklerFNFException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler2("K/src/main/java/at/spengergasse/immobilienmakler/save2");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testloadMaklerIOException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler2("src/main/java/at/spengergasse/immobilienmakler/save2");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testloadMaklerCNFException(){    //simuliert durch ausklammern der serialVersionUID "invalidClassException"
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler2("src/main/java/at/spengergasse/immobilienmakler/save2");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testloadMaklerGueltig(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler2("src/main/java/at/spengergasse/immobilienmakler/save2");
            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testloadMaklerGueltig2(){    //simuliert durch ausklammern der serialVersionUID "invalidClassException"
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            System.out.println(immobilienmakler.getImmobilien());
//            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestLoadMakler2.testloadMaklerNullRef();
//        TestLoadMakler2.testloadMaklerFNFException();
//        TestLoadMakler2.testloadMaklerIOException();
//        TestLoadMakler2.testloadMaklerCNFException();
        TestLoadMakler2.testloadMaklerGueltig();
//        TestLoadMakler2.testloadMaklerGueltig2();
    }
}
