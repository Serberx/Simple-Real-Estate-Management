package at.spengergasse.immobilienmakler.model;



import at.spengergasse.immobilienmakler.exception.ImmobilienException;

import java.util.Optional;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.toUpperCase;

public class Grundstueck extends Immobilie {

    private char widmung;
    private double qmPreis;



   /* public Grundstueck(String[] datenArray) throws ImmobilienException{
        super(datenArray);

        //        0            1  2                      3      4  5
        //        Grundstueck; 3; Adresse 65, 1111 Wien; 100.0; B; 212.0
        try{
            String widmungStrung = datenArray[4];
            String QmPreisString = datenArray[5];

            if(widmungStrung != null){
                setWidmung(widmungStrung.charAt(0));
            }else{
                throw new ImmobilienException("Null-Ref beim Parsen der Windmung");
            }
            if(QmPreisString != null){
                setQmPreis(Double.parseDouble(QmPreisString));
            }else{
                throw new ImmobilienException("QmPreisString beim Parsen der Windmung");
            }
        }catch(IndexOutOfBoundsException e){
            throw new ImmobilienException("IndexOutOfBoundsException beim Parsen des Grundstueckes. "+e.getMessage()+ e);
        }

    }*/

    public Grundstueck(String[] dataLine) throws ImmobilienException {       //importImmobileinCsv2
        super(dataLine);
        //            Index         0 1                   2     3 4       5
        //                Grundstueck;0;Gasse 1, 1010 Stadt;100.0;B;10000.0
        try {
            String widmungString = dataLine[4];
//            String qmPreisString = dataLine[5];


            if( widmungString != null && !widmungString.isBlank() ) {
                setWidmung(widmungString.charAt(0));

            }else {
                throw new ImmobilienException("Null-Ref beim Parsen der Widmung.");
            }
//            if( qmPreisString != null ) {
//                setQmPreis(Double.parseDouble(qmPreisString));
//            }else {
//                throw new ImmobilienException("Null-Ref beim Parsen des QmPreises");
//            }

//            Optional<String> widmungStringOptional = Optional.of(dataLine[4]);
            Optional<String> qmPreisOptional = Optional.ofNullable(dataLine[5]);

//            if( widmungStringOptional.isPresent() ) {
//                setWidmung(widmungStringOptional.get().charAt(0));
//            }else {
//                throw new ImmobilienException("Widmung ist nicht vorhanden beim Parsen des Grundstuecks.");
//            }
            if( qmPreisOptional.isPresent() ) {
                setQmPreis(Double.parseDouble(qmPreisOptional.get()));

            }else {
                throw new ImmobilienException("qmPreis ist nicht vorhanden beim Parsen des Grundstuecks.");
            }
////            qmPreisOptional.ifPresent(setQmPreis(Double.parseDouble(qmPreisOptional.toString())));
////            qmPreisOptional.ifPresent(setQmPreis(Double.parseDouble(qmPreisOptional.get())));

        }catch (ArrayIndexOutOfBoundsException e) {
            throw new ImmobilienException("ArrayIndexOutOfBoundsException beim Parsen des Grundstücks." + e.getMessage(), e);
        }catch (NumberFormatException e) {
            throw new ImmobilienException("NumberFormatException beim Parsen des Grundstücks." + e.getMessage(), e);
        }
    }


////    public Grundstueck(String[] datenArray) throws ImmobilienException {
////        super(datenArray);
////        //        0            1  2                      3      4  5
////        //        Grundstueck; 3; Adresse 65, 1111 Wien; 100.0, B, 212.0
////
////        String stringWidmung = datenArray[4];
////        if (stringWidmung != null && !stringWidmung.isBlank()) {
////            setWidmung(stringWidmung.charAt(0));
////        } else {
////            throw new ImmobilienException("Null-Ref beim Parsen der Widmung! ");
////        }
////
////        String stringQmPreis = datenArray[5];_
////        if (stringQmPreis != null) {
////            try {
////                setQmPreis(Integer.parseInt(stringQmPreis));
////            } catch (NumberFormatException e) {
////                throw new ImmobilienException("Fehler beim Parsen des Qm Preises! " + e.getMessage());
////            }
////        }
////
////    }
//
//
//    public Grundstueck(String[] datenArray) throws ImmobilienException {
//        super(datenArray);
//
////        Grundstueck; 3; Adresse 65, 1111 Wien; 100.0, B, 212.0
//        String widmungString = null;
//        String qmPreisString = null;
//
//        try {
//
//            widmungString = datenArray[4];
//            qmPreisString = datenArray[5];
//
//            if (widmungString != null) {
//                setWidmung(widmungString.charAt(0));
//            } else {
//                throw new ImmobilienException("Null-Ref. beim Parsen der Widmung.");
//            }
//
//            if (qmPreisString != null) {
//                setQmPreis(Double.parseDouble(qmPreisString));
//            } else {
//                throw new ImmobilienException("Null-Ref. beim Parsen des qmPreises.");
//            }
//
//
//        }catch (IndexOutOfBoundsException e) {
//            throw new ImmobilienException("IndexOutOfBoundsException beim Parsen der Widmung. " + e.getMessage());
//        } catch (NullPointerException e) {
//            throw new ImmobilienException("NullPointerException beim Parsen des qmPreises");
//        }catch (NumberFormatException e){
//            throw new ImmobilienException("NumberFormatException beim Parsen des qmPreises");
//        }
//
//
//    }

    public Grundstueck() {}

    public Grundstueck(String adresse, double flaeche, char widmung, double qmPreis) throws ImmobilienException {
        super(adresse);
        setFlaeche(flaeche);
        setWidmung(widmung);
        setQmPreis(qmPreis);
    }

    //getter
    public char getWidmung() {
        return this.widmung;
    }

    public double getQmPreis() {
        return this.qmPreis;
    }

    //setter
    public void setWidmung(char widmung) throws ImmobilienException {
        if( isLowerCase(widmung) ) {
            widmung = toUpperCase(widmung);
        }
        switch(widmung) {
            case 'B', 'G', 'N', '?':
                this.widmung = widmung;
                break;
            default:
                throw new ImmobilienException("Widmung darf nur \"B\", \"G\", \"N\", \"?\" enthalten!");
        }
    }

    public void setQmPreis(double qmPreis) throws ImmobilienException {
        if( qmPreis>=1 && qmPreis<=10000 ) {
            this.qmPreis = qmPreis;
        }else {
            throw new ImmobilienException("QmPreis muss zwischen 1 und 10000 sein. Ihre Eingabe: " + qmPreis);
        }
    }

    public void setFlaeche(double flaeche) throws ImmobilienException {
        if( flaeche>=Constants.MIN_FLAECHE_GRUNDSTUECK && flaeche<=Constants.MAX_FLAECHE_GRUNDSTUECK ) {
            super.setFlaeche(flaeche);
        }else {
            throw new ImmobilienException("Flaeche muss zwischen 100 und 100000 sein. Ihre Eingabe: " + flaeche);
        }
    }


    @Override
    public double berechneVerkehrswert() {
        double wert;
        wert = qmPreis*super.getFlaeche();
        switch(this.widmung) {
            case 'B':
                return wert*2;
            case 'N':
                return wert/2;
            case 'G', '?':
                return wert;
            default:
                return wert;
        }
    }

    @Override
    public String toStringCsv() {
        String csvDaten = super.toStringCsv() + Constants.COMMA + this.widmung + Constants.COMMA + this.qmPreis;
        return csvDaten;
    }

    public String toStringCsv2() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toStringCsv2()).append(Constants.COMMA).append(widmung).append(Constants.COMMA).append(qmPreis).toString();
        return builder.toString();
    }


    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        return build.append("ID: ").append(getIdentifikationsNr()).append(" || ").append("Grundstueck").append(" @ ").append(super.toString()).append(" -> ").append(this.widmung == 'B' ? "Bauland" : ( this.widmung == 'N' ? "Naturschutz" : ( this.widmung == 'G' ? "Grünland" : "Widmung unbekannt" ) )).append(", €").append(berechneVerkehrswert()).toString();
    }


}
