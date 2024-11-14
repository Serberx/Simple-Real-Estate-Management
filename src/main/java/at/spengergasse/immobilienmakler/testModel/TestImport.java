package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestImport {

    public static void testImportierenGueltig() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser("src/main/java/at/spengergasse/immobilienmakler/exportieren/WohnhausDaten22.txt");
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testImportierenNullRef() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser(null);
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static final void main(String[] args) {
        TestImport.testImportierenGueltig();
//        TestImport.testImportierenNullRef();
    }


}
