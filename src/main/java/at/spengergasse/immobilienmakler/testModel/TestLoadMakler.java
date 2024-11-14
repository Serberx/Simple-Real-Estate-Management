package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


import java.io.IOException;

public class TestLoadMakler {

    public static void testLoadMaklerNullRef(){
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler(null);
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testLoadMaklerFNFException(){
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler("K/src/main/java/exportieren/");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testLoadMaklerIOException(){
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler("src/main/java/at/spengergasse/immobilienmakler/save/");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testLoadMaklerGueltig(){
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.loadMakler("src/main/java/at/spengergasse/immobilienmakler/save/");
            System.out.println(immobilienmakler.toString());

//            immobilienmakler.setZeitPunkt();
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        TestLoadMakler.testLoadMaklerNullRef();
//        TestLoadMakler.testLoadMaklerFNFException();
//        TestLoadMakler.testLoadMaklerIOException();
        TestLoadMakler.testLoadMaklerGueltig();

    }
}
