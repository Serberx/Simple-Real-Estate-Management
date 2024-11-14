package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.persistence.TextPersister2;


public class TestPersisterCSVImportieren2 {

    public static void testPeristerLoadNull(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new TextPersister2());
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
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadFNFException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new TextPersister2());
            immobilienmakler.laden2("K/src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadIOException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new TextPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadCNFException(){ //Wie wirft man eine ClassNotFoundException
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new TextPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadUngueltigeKlasse(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new TextPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiertUngueltigeKlasse.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadAIOOBException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new TextPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiertArrayIOOBException.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadNFException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.setImmobilienPersister2(new TextPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiertNumberFormatException.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void testPeristerLoadGueltig(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1", new TextPersister2());
//            immobilienmakler.setImmobilienPersister2(new BinaerPersister2());
            immobilienmakler.laden2("src/main/java/at/spengergasse/immobilienmakler/save2/ImmobiliendatenPersistiert.csv");
            System.out.println(immobilienmakler.toString());
        }catch(ImmobilienException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestPersisterCSVImportieren2.testPeristerLoadNull();
//        TestPersisterCSVImportieren2.testPeristerLoadKeinPersister();
//        TestPersisterCSVImportieren2.testPeristerLoadFNFException();
//        TestPersisterCSVImportieren2.testPeristerLoadIOException();
//        TestPersisterCSVImportieren2.testPeristerLoadCNFException();
//        TestPersisterCSVImportieren2.testPeristerLoadUngueltigeKlasse();
//        TestPersisterCSVImportieren2.testPeristerLoadAIOOBException();
//        TestPersisterCSVImportieren2.testPeristerLoadNFException();
        TestPersisterCSVImportieren2.testPeristerLoadGueltig();
    }
}
