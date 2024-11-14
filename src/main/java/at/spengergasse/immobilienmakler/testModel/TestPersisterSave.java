package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.exception.PersisterException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;



public class TestPersisterSave {

    public static void testPersistierenNullRef() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern(null);
        } catch(PersisterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenNullPersister() { //immobilienPersister ist auf null gesetzt.
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten1.ser");
        } catch(PersisterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenFNFException() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern("K/src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten1.ser");
        } catch(PersisterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenIOException() { //marker Interface wurde simuliert.
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten1.ser");
        } catch(PersisterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPersistierenGuelig() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            immobilienmakler.speichern("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten55.ser");
        } catch(PersisterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestPersister.testPersistierenNullRef();
//        TestPersister.testPersistierenNullPersister();
//        TestPersister.testPersistierenFNFException();
//        TestPersister.testPersistierenIOException();
        TestPersisterSave.testPersistierenGuelig();
    }
}
