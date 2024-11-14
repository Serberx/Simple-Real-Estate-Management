package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestPersisterCSVExportieren2 {

    public static void speichernNullFilename(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten3();
            immobilienmakler.speichern2(null);
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void speichernFNFException(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten3();
            immobilienmakler.speichern2("K/src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void speichernIOException(){      //simulieren wie?
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten3();
            immobilienmakler.speichern2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void speichernPersisterNichtGesetzt(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.speichern2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void speichernPersisterGueltig(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten3();
            immobilienmakler.speichern2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiertNumberFormatException.csv");
            System.out.println( immobilienmakler.toString());

        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestPersisterCSVExportieren2.speichernNullFilename();
//        TestPersisterCSVExportieren2.speichernFNFException();
//        TestPersisterCSVExportieren2.speichernIOException();
//        TestPersisterCSVExportieren2.speichernPersisterNichtGesetzt();
        TestPersisterCSVExportieren2.speichernPersisterGueltig();
    }
}