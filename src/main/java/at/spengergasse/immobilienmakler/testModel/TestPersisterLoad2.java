package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.enumeration.PersisterType;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.persistence.BinaerPersister2;


public class TestPersisterLoad2 {

    public static void testPeristerLoadNull(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
//            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2(null);
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadKeinPersister(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
//            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadFNFException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2("K/src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadIOException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadCNFException(){ //Wie wirft man eine ClassNotFoundException
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadGueltig(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1", new BinaerPersister2());
//            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiertMap999.ser");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadGueltigMapTest(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 222");
//            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2Map("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiertMap999.csv", PersisterType.CSV);
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testGetAll(){
        try{
            Immobilienmakler immobilienmakler = new TestDatenImmobilien().testDaten();
            immobilienmakler.getAll();
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestPersisterLoad2.testPeristerLoadNull();
//        TestPersisterLoad2.testPeristerLoadKeinPersister();
//        TestPersisterLoad2.testPeristerLoadFNFException();
//        TestPersisterLoad2.testPeristerLoadIOException();
//        TestPersisterLoad2.testPeristerLoadCNFException();
//        TestPersisterLoad2.testPeristerLoadGueltig();
//        TestPersisterLoad2.testPeristerLoadGueltigMapTest();
        TestPersisterLoad2.testGetAll();
    }
}
