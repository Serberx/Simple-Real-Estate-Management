package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;

public class TestSave2 {

    public static void testSaveNullRef() {
        try {
            Immobilienmakler ib1 = new TestDatenImmobilien().testDaten();
            ib1.saveImmobilien2(null);
        }catch (ImmobilienException e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testSaveFNFException(){
        try{
            Immobilienmakler ib1 = new  TestDatenImmobilien().testDaten();
            ib1.saveImmobilien2("K/H/Save/ImmobilienDaten1.ser");
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testSaveIOException(){ //simuliert
        try{
//            File file = new File("src/main/java/save2");
//            file.mkdir();
            Immobilienmakler ib1 = new  TestDatenImmobilien().testDaten();
            ib1.saveImmobilien2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobilienDaten1.ser");
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testSaveGueltig(){
        try{
            Immobilienmakler ib1 = new  TestDatenImmobilien().testDaten();
            ib1.saveImmobilien2("src\\main\\java\\at\\spengergasse\\immobilienmakler\\save2\\ImmobilienDaten44.ser");
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testGetAll(){
        try{
            Immobilienmakler ib1 = new  TestDatenImmobilien().testDaten();
            System.out.println(ib1.getId(2));
            System.out.println(ib1.getId(0));
            System.out.println(ib1.getId(null));
            System.out.println(ib1.getId(8));
            }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static  void main(String[] args){
//        TestSave2.testSaveNullRef();
//        TestSave2.testSaveFNFException();
//        TestSave2.testSaveIOException();
//        TestSave2.testSaveGueltig();
        TestSave2.testGetAll();
    }
}
