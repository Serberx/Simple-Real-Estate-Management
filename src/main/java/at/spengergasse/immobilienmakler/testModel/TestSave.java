package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


import java.io.File;

public class TestSave {

    public static void testSaveNullRef(){
        try{
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.saveImmobilie(null);
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testSaveFNF(){
        try{
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.saveImmobilie("K/kein/Ordner/Immobilien.ser");
            System.out.println("erfolgreich");

        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testSaveIOException(){
        try{
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.saveImmobilie("src/main/java/at/spengergasse/immobilienmakler/save/Immobilien.ser");
            System.out.println("erfolgreich");

        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testSaveGueltig(){
        try{
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.saveImmobilie("src/main/java/at/spengergasse/immobilienmakler/save/Immobilien.ser");
            System.out.println("erfolgreich");

        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteFile() throws ImmobilienException{
        String datei = null;
        try {
            datei = "src/main/java/at/spengergasse/immobilienmakler/exportieren/immobilien.txt";
            File file = new File(datei);
            file.delete();
        } catch (SecurityException e) {
            throw new ImmobilienException("SecurityException beim Löschen der Daten: " + datei);
        }
    }


    public static void main(String[] args) throws ImmobilienException {
//        TestSave.testSaveNullRef();
//        TestSave.testSaveFNF();
//        TestSave.testSaveIOException();
        TestSave.testSaveGueltig();
//        TestSave.deleteFile();
    }
}