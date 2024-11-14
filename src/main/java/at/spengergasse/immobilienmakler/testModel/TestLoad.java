package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestLoad extends Exception{

    public /*static*/ void testLoad(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadImmobilie("src/main/java/at/spengergasse/immobilienmakler/save/Immobilien.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testLoadNullRef(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadImmobilie(null);
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testLoadIOException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadImmobilie("src/main/java/at/spengergasse/immobilienmakler/save/Immobilien.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestLoad testLoad = new TestLoad();
        testLoad.testLoad();
//        TestLoad.testLoadNullRef();
//        TestLoad.testLoadIOException();
    }

}
