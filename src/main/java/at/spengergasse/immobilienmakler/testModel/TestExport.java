package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.model.Wohnhaus;


public class TestExport {

    public static void testExportFormatNull() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
//          immobilienmakler.exportWohnhaeuser(null);
          immobilienmakler.exportWohnhaeuser2(null);
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testExportFormatFNFException() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
//          immobilienmakler.exportWohnhaeuser("K:src/main/java/exportieren/WohnhausDaten.txt");
          immobilienmakler.exportWohnhaeuser2("K:src/main/java/at/spengergasse/immobilienmakler/exportieren/WohnhausDaten.txt");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testExportFormatIOException() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
//          immobilienmakler.exportWohnhaeuser("src/main/java/exportieren/WohnhausDaten.txt");
          immobilienmakler.exportWohnhaeuser2("src/main/java/at/spengergasse/immobilienmakler/exportieren/WohnhausDaten3.txt");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testExportFormatGueltig() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
          immobilienmakler.exportWohnhaeuser2("src/main/java/at/spengergasse/immobilienmakler/exportieren/WohnhausDaten22.txt");
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testWohnhausInhaltFormat3() {
        try {
            Wohnhaus wohnhaus = new Wohnhaus("Adresse", 'A', 10000, 100);
            System.out.println(wohnhaus.toStringFormat());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }




//    public static void delete(){
//        File file = new File("src/main/java/exception/WohnhausDaten.txt");
//        file.delete();
//    }

    public static void main(String[] args) {
//        TestExport.testExportFormatNull();
//        TestExport.testExportFormatFNFException();
//        TestExport.testExportFormatIOException();
        TestExport.testExportFormatGueltig();
//        TestExport.testWohnhausInhaltFormat3();

//        TestExport.delete();
    }
}
