package at.spengergasse.immobilienmakler.model;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

public abstract class Immobilie implements Comparable<Immobilie>, Serializable  {

    @Serial
    private static final long serialVersionUID = -8990860474646662318L;

    private static Integer zaehler = 1;

    private int identifikationsNr;
    private String adresse;
    private double flaeche;

    /*protected Immobilie(String[] datenArray) throws ImmobilienException {
//        0       1  2        3  4    5      6     7  8
//        Klasse; 3; Adresse 65, 1111 Wien; 100.0; B; 212.0

        if( datenArray.length != 6 ) {
            try {
                String stringIdentifikationsNr = datenArray[1];
                String stringAdresse = datenArray[2] + " " + datenArray[3] + " " + datenArray[4] + " " + datenArray[5];
                String stringFlaeche = datenArray[6];

                if( stringIdentifikationsNr != null ) {
                    this.identifikationsNr = Integer.parseInt(stringIdentifikationsNr);
                }else {
                    throw new ImmobilienException(" Fehler beim Parsen der Identifikationsnummer. ");
                }
                setAdresse(stringAdresse);
                if( stringFlaeche != null ) {
                    setFlaeche(Double.parseDouble(stringFlaeche));
                }else {
                    throw new ImmobilienException(" Fehler beim Parsen der Adresse. ");
                }


            }catch (NumberFormatException e) {
                throw new ImmobilienException("NumberFormatExeption. Wert kann nicht in Zahl umgewandelt werden. " + e.getMessage(), e);
            }catch (ArrayIndexOutOfBoundsException e) {
                throw new ImmobilienException("IndexOutOfBoundException. Wert nicht Vorhanden. ");
            }

        }else {


            try {
                String stringIdentifikationsNr = datenArray[1];
                String stringAdresse = datenArray[2];
                String stringFlaeche = datenArray[3];

                if( stringIdentifikationsNr != null ) {
                    this.identifikationsNr = Integer.parseInt(stringIdentifikationsNr);
                }else {
                    throw new ImmobilienException("Null-Ref beim Parsen der Identifikations Nummer");
                }

                setAdresse(stringAdresse);

                if( stringFlaeche != null ) {
                    setFlaeche(Double.parseDouble(stringFlaeche));
                }else {
                    throw new ImmobilienException("Fehler beim Parsen der Fläche!");
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                throw new ImmobilienException("IndexOutOfBoundsException beim Parsen der Immobilie" + e.getMessage() + e);
            }catch (NumberFormatException e) {
                throw new ImmobilienException("NFException beim Parsen der Flaeche. " + e.getMessage(), e);
            }
        }
    }*/

    protected Immobilie(String[] dataLine) throws ImmobilienException {         //importImmobileinCsv2
        //            Index         0 1                   2     3 4       5
        //                Grundstueck;0;Gasse 1, 1010 Stadt;100.0;B;10000.0
        try {
            String klasseString = dataLine[0];
            String idString = dataLine[1];
            String adressenString = dataLine[2];
            String flaechenString = dataLine[3];

            if( idString != null ) {
                this.identifikationsNr = Integer.parseInt(idString);
            }else{
                throw new ImmobilienException("Null-Ref beim parsen der idString.");
            }
            setAdresse(adressenString);
            if(flaechenString!= null){
                setFlaeche(Double.parseDouble(flaechenString));
            }else{
                throw new ImmobilienException("Null-Ref beim parsen der idString.");
            }

        }catch (ArrayIndexOutOfBoundsException e) {
            throw new ImmobilienException("ArrayIndexOutOfBoundsException beim Parsen der Daten in der Immobilien Klasse. "+ e.getMessage(), e);
        }catch (NumberFormatException e){
            throw new ImmobilienException("NumberFormatExcetpion beim Parsen in der Klasse Immobilie. "+ e.getMessage(), e);
        }
    }

//    protected Immobilie(String[] datenArray) throws ImmobilienException {
////        0            1  2                      3      4  5
////        Grundstueck; 3; Adresse 65, 1111 Wien; 100.0, B, 212.0
//        String idString = datenArray[1];
//        if (idString != null) {
//            try {
//                this.identifikationsNr = Integer.parseInt(idString);
//            } catch (NumberFormatException e) {
//                throw new ImmobilienException("Fehler beim Parsen der Identifikations Nummer! " + e.getMessage());
//            }
//        } else {
//            throw new ImmobilienException("Null-Ref beim Parsen der Identifikations Nummer! ");
//        }
//
//        setAdresse(datenArray[2]);
//
//        String flaecheString = datenArray[3];
//        if (flaecheString != null) {
//            try {
//                setFlaeche(Integer.parseInt(flaecheString));
//            } catch (NumberFormatException e) {
//                throw new ImmobilienException("Fehler beim Parsen der Identifikations Nummer! " + e.getMessage());
//            }
//        } else {
//            throw new ImmobilienException("Null-Ref beim Parsen der Flaeche! ");
//        }
//
//
//    }


//    public Immobilie(String[] datenArray) throws ImmobilienException {
//
////        Grundstueck; 4; Adresse 53, 1111 Wien; 1001.0; G; 100.0
//        String identifikationsString = datenArray[1];
//        String adressenString = datenArray[2];
//        String flaecheString = datenArray[3];
//
//        if(identifikationsString != null) {
//            try {
//                this.identifikationsNr = Integer.parseInt(identifikationsString);
//            }  catch(NumberFormatException e){
//                throw new ImmobilienException("Numberformat Exception beim Parsen der Idendifikationsnummer. "+e.getMessage(), e);
//            }
//        }else{
//            throw new ImmobilienException("Fehler beim Parsen der Identifikationsnummer. ");
//        }
//
//
//        setAdresse(datenArray[2]);
//
//        if(flaecheString != null){
//            setFlaeche(Double.parseDouble(flaecheString));
//        }else{
//            throw new ImmobilienException("Null-Ref beim Parsen der Flaeche.");
//        }
//    }


    protected Immobilie(String adresse) throws ImmobilienException {
        super();
        setAdresse(adresse);
        this.identifikationsNr = zaehler++;

    }
    public Immobilie(){

    }


    //getter
    public Integer getIdentifikationsNr() {
        return this.identifikationsNr;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public double getFlaeche() {
        return this.flaeche;
    }

    //setter
    public void setAdresse(String adresse) throws ImmobilienException {
        if( adresse != null ) {
            if( !adresse.isBlank() ) {
                this.adresse = adresse;
            }else {
                throw new ImmobilienException("Leerzeichen bei setAdresse().");
            }
        }else {
            throw new ImmobilienException("Null-Ref. bei setAdresse().");
        }
    }

    public void setFlaeche(double flaeche) throws ImmobilienException {
        this.flaeche = flaeche;
    }

    public void setIdentifikationsNr(Integer id) throws ImmobilienException{
        if(id != null){
            if(getIdentifikationsNr() == 0){
                this.identifikationsNr = zaehler++;

            }
            if(getIdentifikationsNr() > 0){
            this.identifikationsNr = getIdentifikationsNr();
            }
        }else{
            throw new ImmobilienException("Null-Ref bei setIdendifikationsnNR()");
        }
    }

    //weitereMethoden
    public abstract double berechneVerkehrswert();

    public int compareTo(Immobilie immobilie) {
        if( immobilie != null ) {
            if( immobilie.berechneVerkehrswert()>this.berechneVerkehrswert() ) {
                return 1;
            }else {
                if( immobilie.berechneVerkehrswert()<this.berechneVerkehrswert() ) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }else {
            System.out.println("Null-Ref. bei compareTo.");
            return -99;  //Muss in späteren weiter beachtet werden.
        }

    }


//    public int compareTo(Immobilie immobilie){
//        if(immobilie != null){
//            if(this.getFlaeche()  < immobilie.getFlaeche()){
//                return 1;
//            }else{
//                if(this.getFlaeche()  > immobilie.getFlaeche()){
//                   return -1;
//                }else{
//                  return  0;
//                }
//            }
//        }else{
//            System.out.println("Null-Ref bei CompareTo.");
//            return 1;
//        }
//    }

    public String toStringCsv() {
        String csvDaten = this.getClass().getSimpleName() + Constants.COMMA + this.identifikationsNr + Constants.COMMA + this.adresse + Constants.COMMA + this.flaeche;
        return csvDaten;
    }


    public String toStringCsv2() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName()).append(Constants.COMMA).append(identifikationsNr).append(Constants.COMMA).append(adresse).append(Constants.COMMA).append(flaeche);
        return builder.toString();
    }


    public String toString() {
        StringBuilder build = new StringBuilder();
        return build.append(adresse).append(" | ").append(flaeche).append(" m2").toString();
    }


}

