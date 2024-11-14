package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestImportieren {

    public static void testImportierenNull() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importieren(null);
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenFNF() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importieren("src/main/keineDatei");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportierenClassFail() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importieren("src/main/java/at/spengergasse/immobilienmakler/exportieren/ImmobilienDatenCSVNew.txt");

            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testImportieren() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importieren("src/main/java/at/spengergasse/immobilienmakler/exportieren/ImmobilienDatenCSVNew.txt");

            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static final void main(String[] args){
//        TestImportieren.testImportierenNull();
//        TestImportieren.testImportierenFNF();
//        TestImportieren.testImportierenClassFail();
        TestImportieren.testImportieren();
    }

}
