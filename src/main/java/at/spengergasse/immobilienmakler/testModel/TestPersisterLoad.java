package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.BinaerPersister;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestPersisterLoad {

    public static void testPersisterNullRef(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 5"/*, new BinaerPersister()*/); // Wieso: "java: no suitable constructor found for Immobilienmakler(java.lang.String,model.BinaerPersister)" obwohl es einen Konstructor dafür gibt?
            immobilienmakler.setImmobilienPersister(new BinaerPersister());
            immobilienmakler.laden("src/main/java/at/spengergasse/immobilienmakler/savePersister/ImmobilienDaten55.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestPersisterLoad.testPersisterNullRef();
    }
}
