package at.spengergasse.immobilienmakler.testModel;


import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.exception.PersisterException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.model.TextPersister;

public class TestPersisterCSVImportieren {

    public static void testPersistierenLoadCSVNull() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 11");
            immobilienmakler.setImmobilienPersister(new TextPersister());
            immobilienmakler.laden(null);
            System.out.println(immobilienmakler.toString());
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenLoadCSVNull_Persist() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 11");
            immobilienmakler.setImmobilienPersister(null);
            immobilienmakler.laden("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten55.CSV");
            System.out.println(immobilienmakler.toString());
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testPersistierenLoadCSVWohnhaeuserDaten() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 11");
            immobilienmakler.setImmobilienPersister(new TextPersister());
            immobilienmakler.laden("src/main/java/at/spengergasse/immobilienmakler/savePersister/WohnhausDaten22.txt");
            System.out.println(immobilienmakler.toString());
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenLoadCSVGuelig() {
        try {
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 11");
            immobilienmakler.setImmobilienPersister(new TextPersister());
            immobilienmakler.laden("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten55.CSV");
            System.out.println(immobilienmakler.toString());
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestPersisterCSVLoad.testPersistierenLoadCSVNull();
//        TestPersisterCSVLoad.testPersistierenLoadCSVNull_Persist();
        TestPersisterCSVImportieren.testPersistierenLoadCSVWohnhaeuserDaten();
//        TestPersisterCSVLoad.testPersistierenLoadCSVGuelig();
    }
}
