package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;


public class TestImport2 {

    public static void testImportierenWohnaeuserNull(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser2(null);
//            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage()   );
            e.printStackTrace();
        }
    }
    public static void testImportierenWohnaeuserFNFException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser2("K/src/main/java/at/spengergasse/immobilienmakler/exportierenWohnhaeuser/Wohnhaeuser2.CSV");
//            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage()   );
            e.printStackTrace();
        }
    }
    public static void testImportierenWohnaeuserIOException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser2("src/main/java/at/spengergasse/immobilienmakler/exportierenWohnhaeuser/Wohnhaeuser2.CSV");
//            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage()   );
            e.printStackTrace();
        }
    }
    public static void testImportierenWohnaeuserArrayIOOBException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser2("src/main/java/at/spengergasse/immobilienmakler/exportierenWohnhaeuser/WohnhaeuserArrayIOOBException.CSV");
//            System.out.println(immobilienmakler.toString());
        }catch (ImmobilienException e){
            System.out.println(e.getMessage()   );
            e.printStackTrace();
        }
    }

    public static void testImportierenWohnaeuserFalscheSubklasse(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser2("src/main/java/at/spengergasse/immobilienmakler/exportierenWohnhaeuser/WohnhaeuserFalscheSubklasse.CSV");
            System.out.println(immobilienmakler.toString());

        }catch (Exception e){
            System.out.println(e.getMessage()   );
            e.printStackTrace();
        }
    }
    public static void testImportierenWohnaeuserNumberFormatException(){
        try{
            Immobilienmakler immobilienmakler = new Immobilienmakler("Makler 1");
            immobilienmakler.importWohnhaeuser2("src/main/java/at/spengergasse/immobilienmakler/exportierenWohnhaeuser/WohnhaeuserZeilen.CSV");
            System.out.println(immobilienmakler.toString());

        }catch (Exception e){
            System.out.println(e.getMessage()   );
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        TestImport2.testImportierenWohnaeuserNull();
//        TestImport2.testImportierenWohnaeuserFNFException();
//        TestImport2.testImportierenWohnaeuserIOException();
//        TestImport2.testImportierenWohnaeuserArrayIOOBException();
//        TestImport2.testImportierenWohnaeuserFalscheSubklasse();
        TestImport2.testImportierenWohnaeuserNumberFormatException();
    }

}
