package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;



import java.io.File;

public class TestExportierenCsv {

    public static void testExportierenNull() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.exportImmobilienCsv(null);
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testExportierenFNFException() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.exportImmobilienCsv("K:src/main/java/at/spengergasse/immobilienmakler/exportieren/gibtsNicht.txt");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();        }
    }

    public static void testExportierenIOException() { //wurde Simuliert
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.exportImmobilienCsv("src/main/java/at/spengergasse/immobilienmakler/exportieren/ImmobilienDatenCSVNew.txt");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testExportieren() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.exportImmobilienCsv("src/main/java/at/spengergasse/immobilienmakler/exportieren/ImmobilienDatenCSVNew.txt");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void delete() {
        try {
            File file = new File("src/main/java/at/spengergasse/immobilienmakler/model/KeineDaten.txt");
            file.delete();
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
//            immobilienmakler.export("src/main/java/exportieren/ImmobilienDatenCSV.txt");
        } catch (ImmobilienException e) {

        }
    }


    public static void main(String[] args) {
//        TestExportierenCsv.testExportierenNull();
//        TestExportierenCsv.testExportierenFNFException();
        TestExportierenCsv.testExportieren();
//        TestExportierenCsv.delete();
    }
}
