package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.enumeration.PersisterType;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilie;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.persistence.BinaerPersister2;
import at.spengergasse.immobilienmakler.persistence.Persistable2;



public class TestPersisterSave2 {

    public static void speichernNullFilename(){
        try{
//           model.Immobilienmakler makler = new model.Immobilienmakler("Makler");    //impliziter Import
//           makler.speichern2(null);

            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.speichern2(null);
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void speichernFNFException(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten2();
            immobilienmakler.speichern2("K/src/main/java/save2/ImmobiliendatenPersistiert.ser");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void speichernIOException(){      //simuliert
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten2();
            immobilienmakler.speichern2("src/main/java/save2/ImmobiliendatenPersistiert.ser");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void speichernPersisterNichtGesetzt(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.speichern2("src/main/java/save2/ImmobiliendatenPersistiert.ser");
        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
//    @Test
    public static void speichernPersisterGueltig(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten2();
            immobilienmakler.speichern2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiertMap999.ser");
            System.out.println( immobilienmakler.toString());

        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
//    @Test
    public static void speichernPersisterGueltigMapTest(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten4();
            immobilienmakler.speichern2Map("src\\main\\java\\at\\spenger gasse\\immobilienmakler\\save2\\ImmobiliendatenPersistiertMap999.csv", PersisterType.CSV);
            System.out.println( immobilienmakler.toString());
            Persistable2<Immobilie> hallo =  new BinaerPersister2();

        }catch (ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
//        TestPersisterSave2.speichernNullFilename();
//        TestPersisterSave2.speichernFNFException();
//        TestPersisterSave2.speichernIOException();
//        TestPersisterSave2.speichernPersisterNichtGesetzt();
//        TestPersisterSave2.speichernPersisterGueltig();
        TestPersisterSave2.speichernPersisterGueltigMapTest();

    }
}
