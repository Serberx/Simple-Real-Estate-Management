package at.spengergasse.immobilienmakler.testModel;


import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.exception.PersisterException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.model.TextPersister;

public class TestPersisterCSVExportieren {

    public static void testPersistierenCSVNullRef() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern(null);
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenCSVNullPersister() { //immobilienPersister ist bei erzeugeTestdaten() auf null gesetzt.
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten1.CSV");
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenCSVFNFException() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern("K/src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten1.CSV");
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenCSVIOException() { //marker Interface wurde simuliert.
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten1.CSV");
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenCSVGuelig() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.setImmobilienPersister(new TextPersister());
            immobilienmakler.speichern("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten55.CSV");
        } catch(PersisterException|ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestPersisterCSVSave.testPersistierenCSVNullRef();
//        TestPersisterCSVSave.testPersistierenCSVNullPersister();
//        TestPersisterCSVSave.testPersistierenCSVFNFException();
//        TestPersisterCSVSave.testPersistierenCSVIOException();
        TestPersisterCSVExportieren.testPersistierenCSVGuelig();
    }
}
