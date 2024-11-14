package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestExport2 {

    public static void testString(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.exportWohnhaeuser2("src/main/java/at/spengergasse/immobilienmakler/exportierenWohnhaeuser/WohnhaeuserZeilen.CSV");
            System.out.println(immobilienmakler.toString());

        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestExport2.testString();


    }

}
