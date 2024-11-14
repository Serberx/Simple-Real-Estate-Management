package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestExportCsv2 {

    public static void test() {

        try {
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.exportImmobilienCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren/ImmobilienDaten44.csv");


        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testExportierenNull() {
        try {
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.exportImmobilienCsv2(null);
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testExportierenFNFException() {
        try {
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.exportImmobilienCsv2("/K/gibt/es/nicht/Ordner");
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testExportierenIOException() {
        try {

            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.exportImmobilienCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren2/Immobilien.CSV");
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testExportierenGueltig() {
        try {

            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.exportImmobilienCsv2("src/main/java/at/spengergasse/immobilienmakler/exportieren2/ImmobilienFailParse.CSV");
            immobilienmakler.toString();
        }catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        TestExportCsv2.test();
//        TestExportCsv2.testExportierenNull();
//        TestExportCsv2.testExportierenFNFException();
//        TestExportCsv2.testExportierenIOException();
        TestExportCsv2.testExportierenGueltig();


    }

}
