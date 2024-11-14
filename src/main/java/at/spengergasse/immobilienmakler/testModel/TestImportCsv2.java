package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestImportCsv2 {

    public static void testImportierenNull(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler Ernst Huber");
            immobilienmakler.importImmobileinCsv2(null);
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenFNFException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler Ernst Huber");
            immobilienmakler.importImmobileinCsv2("K/src/main/java/at/spengergasse/immobilienmakler/exportieren2/ImmobilienDaten.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenIOException(){ //TODO simulieren , Frage wie?
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler Ernst Huber");
            immobilienmakler.importImmobileinCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren2/Immobilien.CSV");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenFalscheSubklasse(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler Ernst Huber");
            immobilienmakler.importImmobileinCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren2/ImmobilienFlascheSubklasse.CSV");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenNumberFormatException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler Ernst Huber");
            immobilienmakler.importImmobileinCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren2/ImmobilienNumberFormatException.CSV");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenArrayIOOBException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler Ernst Huber");
            immobilienmakler.importImmobileinCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren2/ImmobilienNumberArrayIOOBException.CSV");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenGueltig(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler Ernst Huber");
            immobilienmakler.importImmobileinCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren2/Immobilien.CSV");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        TestImportCsv2.testImportierenNull();
//        TestImportCsv2.testImportierenFNFException();
//        TestImportCsv2.testImportierenIOException();
//        TestImportCsv2.testImportierenFalscheSubklasse();
//        TestImportCsv2.testImportierenNumberFormatException();
//        TestImportCsv2.testImportierenArrayIOOBException();
        TestImportCsv2.testImportierenGueltig();

    }
}
