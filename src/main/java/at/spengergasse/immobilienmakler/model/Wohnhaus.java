package at.spengergasse.immobilienmakler.model;



import at.spengergasse.immobilienmakler.exception.ImmobilienException;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.toUpperCase;

public class Wohnhaus extends Immobilie {

    private char kategorie;
    private double einheitswert;

    /*protected Wohnhaus(String[] datenArray) throws ImmobilienException {
        super(datenArray);
        //        0       1  2        3  4    5      6     7  8
        //        Klasse; 3; Adresse 65, 1111 Wien; 100.0; B; 212.0

        if (datenArray.length != 6) {
            try {
                String stringKategorie = datenArray[7];
                String stringEinheitswert = datenArray[8];

                if (stringKategorie != null) {
                    setKategorie(stringKategorie.charAt(0));
                } else {
                    throw new ImmobilienException("Null-Ref beim Umwandelnd der Kategorie. ");
                }

                if (stringEinheitswert != null) {
                    setEinheitswert(Double.parseDouble(stringEinheitswert));
                } else {
                    throw new ImmobilienException("Null-Ref beim Umwandeln des Einheitswertes. ");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ImmobilienException("IndexOutOfBoundsException beim Parsen der Immobilie" + e.getMessage() + e);
            } catch (NumberFormatException e) {
                throw new ImmobilienException("NFException beim Parsen der Flaeche. " + e.getMessage(), e);
            }

        } else {
            //        0         1  2           3      4  5
            //        Wohnhaus; 2; Adresse 34; 120.0; B; 10000.0
            try {
                String kategorieString = datenArray[4];
                String einheitswertString = datenArray[5];

                if (kategorieString != null) {
                    setKategorie(kategorieString.charAt(0));
                } else {
                    throw new ImmobilienException("Null-Ref beim Parsen der Kategorie.");
                }

                if (einheitswertString != null) {
                    setEinheitswert(Double.parseDouble(einheitswertString));
                } else {
                    throw new ImmobilienException("Null-Ref beim Parsen des Einheitswertes.");
                }
            } catch (IndexOutOfBoundsException e) {
                throw new ImmobilienException("IndexOutOfBoundsException beim Parsen der Immobilie." + e.getMessage(), e);
            } catch (NumberFormatException e) {
                throw new ImmobilienException("NumberFormatException beim Parsen der Immobilie." + e.getMessage(), e);
            }
        }
    }*/


    public Wohnhaus(String[] dataLine) throws ImmobilienException {
        super(dataLine);
        //            Index         0 1                   2     3 4       5
        //                Grundstueck;0;Gasse 1, 1010 Stadt;100.0;B;10000.0
        try {
            String kategorieString = dataLine[4];
            String einheitswertString = dataLine[5];

            if( kategorieString != null ) {
                setKategorie(kategorieString.charAt(0));
            }else {
                throw new ImmobilienException("Null-Ref beim Parsen der Kategorie.");
            }
            if( einheitswertString != null ) {
                setEinheitswert(Double.parseDouble(einheitswertString));
            }else {
                throw new ImmobilienException("Null-Ref beim Parsen des einheitswertes.");
            }

        }catch (ArrayIndexOutOfBoundsException e) {
            throw new ImmobilienException("ArrayIndexOutOfBoundsException beim Parsen des Wohnhauses. " + e.getMessage(), e);
        }catch (NumberFormatException e) {
            throw new ImmobilienException("NumberFormatException beim Parsen des Wohnhauses. " + e.getMessage(), e);
        }
    }

    public Wohnhaus(String adresse, char kategorie, double einheitswert, double flaeche) throws ImmobilienException {
        super(adresse);
        setFlaeche(flaeche);
        setKategorie(kategorie);
        setEinheitswert(einheitswert);
    }
    public Wohnhaus() {}
//
////    public Wohnhaus(String[] datenArray) throws ImmobilienException {
////        super(datenArray);
//////        0         1  2           3      4  5
//////        Wohnhaus; 2; Adresse 34; 120.0; B; 10000.0
////        String stringKategorie = datenArray[4];
////        if (stringKategorie != null && !stringKategorie.isBlank()) {
////            setKategorie(stringKategorie.charAt(0));
////        } else {
////            throw new ImmobilienException("Null-Ref beim Parsen der Widmung! ");
////        }
////
////        String stringEinheitswert = datenArray[5];
////        if (stringEinheitswert != null) {
////            try {
////                setEinheitswert(Integer.parseInt(stringEinheitswert));
////            } catch (NumberFormatException e) {
////                throw new ImmobilienException("Fehler beim Parsen des Qm Preises! " + e.getMessage());
////            }
////        }
////    }
//
//    public Wohnhaus(String[] datenArray) throws ImmobilienException {
//        super(datenArray);
//
//        try {
////            Wohnhaus; 2; Adresse 34; 120.0; B; 10000.0
//
//            String kategorieString = datenArray[4];
//            String einheitswertString = datenArray[5];
//
//            if (kategorieString != null) {
//                setKategorie(kategorieString.charAt(0));
//            } else {
//                throw new ImmobilienException("Nul-Ref beim Parsen der Kategorie.");
//            }
//
//            if (einheitswertString != null) {
//                setEinheitswert(Double.parseDouble(einheitswertString));
//            } else {
//                throw new ImmobilienException("Nul-Ref beim Parsen der Einheitswert.");
//            }
//        } catch (IndexOutOfBoundsException e) {
//            throw new ImmobilienException("IndexOutOfBoundsException beim Parsen des Einheitswertes.");
//        } catch (NullPointerException e){
//            throw new ImmobilienException("NullPointerException beim Parsen des Einheitswertes.");
//        }catch (NumberFormatException e){
//            throw new ImmobilienException("NumberFormatException beim Parsen des Einheitswertes.");
//        }
//    }


    //getter
    public char getKategorie() {
        return this.kategorie;
    }

    public double getEinheitswert() {
        return this.einheitswert;
    }

    //setter
    public void setKategorie(char kategorie) throws ImmobilienException {
        if( isLowerCase(kategorie) ) {
            kategorie = toUpperCase(kategorie);
        }
        switch(kategorie) {
            case 'A','B','C','D':
                this.kategorie = kategorie;
                break;
            default:
                throw new ImmobilienException("Eingabe nur \"A\", \"B\", \"C\", \"D\" ");
        }
    }

    public void setEinheitswert(double einheitswert) throws ImmobilienException {
        if( einheitswert>=10000 && einheitswert<=50000000 ) {
            this.einheitswert = einheitswert;
        }else {
            throw new ImmobilienException("Einheitswert muss zwischen 10000 und 50000000 sein. Ihre Eingabe: " + einheitswert);
        }
    }

    public void setFlaeche(double flaeche) throws ImmobilienException {
        if( flaeche>=Constants.MIN_FLAECHE_WOHNHAUS && flaeche<=Constants.MAX_FLAECHE_WOHNHAUS ) {
            super.setFlaeche(flaeche);
        }else {
            throw new ImmobilienException("Fläche muss zwischen 50 und 5000 m2 sein. Ihre Eingabe: " + flaeche);
        }
    }

    //weitereMethoden
    @Override
    public double berechneVerkehrswert() {
        double tempVW = 0;
        int faktor = 0;
        if( this.einheitswert>=10000 && this.einheitswert<=50000000 ) {

            switch(this.kategorie) {
                case 'A':
                    faktor = 5;
                    break;
                case 'B':
                    faktor = 3;
                    break;
                case 'C':
                    faktor = 2;
                    break;
                case 'D':
                    faktor = 1;
                    break;
                default:
                    System.out.println("Kategorie muss vor dem berechnen des Verkehrswertes gesetzt werden.");
            }
        }
        return faktor*einheitswert;

    }

    //printMethoden

    @Override
    public String toStringCsv() {
        String csvDaten = super.toStringCsv() + Constants.COMMA + kategorie + Constants.COMMA + einheitswert;
        return csvDaten;

    }

    public String toStringFormat() {
        String csvDatenTemp = super.toStringCsv() + ";" + this.kategorie + ";" + this.einheitswert;

//        StringBuilder build = new StringBuilder();
//        build.append(super.toStringCsv()).append(";").append(this.kategorie).append(";").append(this.einheitswert).toString();
//        String[] a = build.toString().split(Constants.COMMA);


        int[] indexDaten = new int[csvDatenTemp.length()];
        int zaehler = 1;

        for( int i = 0; i<csvDatenTemp.length() - 1; i++ ) {

            if( csvDatenTemp.charAt(i) == ';' ) {
                indexDaten[zaehler] = i - 1;
                zaehler++;
                indexDaten[zaehler] = ( i );
                zaehler++;
//                indexDaten[zaehler] = (i+1);
//                zaehler++;
            }
        }
        indexDaten[zaehler] = csvDatenTemp.length();

//        ArrayList<Integer> a = new ArrayList<>();
//        ArrayList<Integer> b = new ArrayList<>();
//
//        for(int i=0;i<indexDaten.length;i++){
//            do {
//                a.add(indexDaten[i]);
//                i++;
//                if(indexDaten[i]==0&&indexDaten[i+1]==0){
//                    break;
//                }
//            }while(indexDaten[i] != indexDaten[i+1]);
//        }

        String[] csvDaten = csvDatenTemp.split(Constants.COMMA);
        String csvDaten2 = "";
        String[] identifikation = {"Klasse", "Identifikationsnummer", "Adresse", "Fläche", "Kategorie", "Einheitswert"};

        csvDaten2 = "Stelle " + indexDaten[0] + "-" + ( indexDaten[1] ) + ": " + identifikation[0] + ": " + csvDaten[0] + "\n";
        csvDaten2 += "Stelle " + indexDaten[3] + ": " + identifikation[1] + ": " + csvDaten[1] + "\n";
        csvDaten2 += "Stelle " + ( indexDaten[4] + 1 ) + "-" + ( indexDaten[5] ) + ": " + identifikation[2] + ": " + csvDaten[2] + "\n";
        csvDaten2 += "Stelle " + ( indexDaten[6] + 1 ) + "-" + ( indexDaten[7] ) + ": " + identifikation[3] + ": " + csvDaten[3] + "\n";
        csvDaten2 += "Stelle " + ( indexDaten[9] ) + ": " + identifikation[4] + ": " + csvDaten[4] + "\n";
        csvDaten2 += "Stelle " + ( indexDaten[10] + 1 ) + "-" + ( indexDaten[11] - 1 ) + ": " + identifikation[5] + ": " + csvDaten[5];

//        csvDaten2 += String.format("Stelle %1$3s-%2$s: %3$s: %4$s ", indexDaten[0], indexDaten[1], identifikation[0], csvDaten[0]);
//        csvDaten2 += String.format("\nStelle %1$5s: %2$s: %3$s ", indexDaten[3] , identifikation[1] , csvDaten[1]);
//        csvDaten2 += String.format("\nStelle %1$s-%2$s: %3$s: %4$s ", indexDaten[4]+1, indexDaten[5], identifikation[2], csvDaten[2]);
//        csvDaten2 += String.format("\nStelle %1$s-%2$s: %3$s: %4$s ", indexDaten[6]+1, indexDaten[7], identifikation[3], csvDaten[3]);
//        csvDaten2 += String.format("\nStelle %1$5s: %2$s: %3$s ", indexDaten[9] , identifikation[4] , csvDaten[4]);
//        csvDaten2 += String.format("\nStelle %1$s-%2$s: %3$s: %4$s ", indexDaten[10]+1, indexDaten[11]-1, identifikation[5], csvDaten[5]);


        return csvDaten2;
    }

    /*public String toStringFormat2() {
        String formatDaten = super.toStringCsv() + Constants.COMMA
                + kategorie + Constants.COMMA
                + einheitswert + Constants.COMMA;

        String[] datenArray = formatDaten.split(Constants.COMMA);
        ArrayList<Integer> laengenArray = new ArrayList<>(datenArray.length);
        ArrayList<Integer> indexArray = new ArrayList<>(datenArray.length);

        for (int i = 0; i < datenArray.length; i++) {

            laengenArray.add(datenArray[i].length());

//            System.out.println(laengenArray.get(i));
//             [0]          [1]           [2]          [3]          [4]          [5]
//              8            1            31            5            1            7         laengenArray
//         0-   8,          9-10 ,       11-42,      43-48,         49-50,      51-58

//            System.out.println(indexArray.add(laengenArray.get(i)));
        }

        int zahl1 = laengenArray.get(0) + 1; //9
        int zahl2 = zahl1 + laengenArray.get(1); //10
        int zahl3 = zahl2 + 1; //11
        int zahl4 = zahl3 + laengenArray.get(2); //42
        int zahl5 = zahl4 + 1; //43
        int zahl6 = zahl5 + laengenArray.get(3); //48
        int zahl7 = zahl6 + 1; //49
        int zahl8 = zahl7 + laengenArray.get(4); //50
        int zahl9 = zahl8 + 1; //51
        int zahl10 = zahl9 + laengenArray.get(5); //58


        String zeile = "Stelle 0-" + laengenArray.get(0) + ": Klasse" + ": " + this.getClass().getSimpleName() + "\n"
                + "Stelle " + zahl1 + "-" + zahl2 + ": Identifikationsnummer" + ": " + super.getIdentifikationsNr() + "\n"
                + "Stelle " + zahl3 + "-" + zahl4 + ": Adresse" + ": " + super.getAdresse() + "\n"
                + "Stelle " + zahl5 + "-" + zahl6 + ": Fläche" + ": " + super.getFlaeche() + "\n"
                + "Stelle " + zahl7 + "-" + zahl8 + ": Kategorie" + ": " + this.kategorie + "\n"
                + "Stelle " + zahl9 + "-" + zahl10 + ": Einheitswert" + ": " + this.einheitswert + "\n";


        return zeile;

    }



    public String toStringFormat3() throws ImmobilienException {
        String csvDaten = super.toStringCsv() + Constants.COMMA
                + this.kategorie + Constants.COMMA
                + this.einheitswert;
        ArrayList<Integer> indexTemp = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>(indexTemp);
        String[] identifikation = {"Klasse", "Identifikationsnummer", "Adresse", "Fläche", "Kategorie", "Einheitswert"};
        String daten = "";

        try {
            indexTemp.add(0);
            for (int i = 0; i < csvDaten.length(); i++) {


                if (csvDaten.charAt(i) == Constants.COMMA_CHAR) {
                    indexTemp.add(i - 1);
                    indexTemp.add(i + 1);
                }
            }
            indexTemp.add(csvDaten.length());


            for (Integer integerTemp : indexTemp) {
                boolean doppel = false;

                for (Integer check : index) {
                    if (integerTemp == check) {
                        doppel = true;
                    }
                }
                if (!doppel) {
                    index.add(integerTemp);
                }
            }
            int zaehler1 = 0;


            String[] csvDatenArray = csvDaten.split(Constants.COMMA);




                for (int h = 0; h < index.size(); h++) {    //TODO
                    if (csvDatenArray[h].length() > 1) {
                        daten += "Stelle " + index.get(h) + "-" + index.get(h + zaehler1) + ":" + identifikation[zaehler1] + ": " + csvDatenArray[h] + "\n";
                        zaehler1++;
                    } else {
                        daten += "Stelle " + index.get(h + zaehler1) + ":" + identifikation[zaehler1] + ": " + csvDatenArray[h] + "\n";
                        zaehler1++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }catch (IndexOutOfBoundsException e){
            e.getMessage();
        }


            System.out.println(index.toString());

            return daten;
        }

    public String toStringFormat4() throws ImmobilienException {
        String csvDaten = super.toStringCsv() + Constants.COMMA
                + this.kategorie + Constants.COMMA
                + this.einheitswert;

        String[] gesplittet = csvDaten.split(Constants.COMMA);

        for (int i=0;i<gesplittet.length;i++){
            System.out.println(gesplittet[i]);
        }

        return csvDaten;
    }*/

    public String toStringCsv2() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toStringCsv2()).append(Constants.COMMA).append(kategorie).append(Constants.COMMA).append(einheitswert).toString();
        return builder.toString();
    }

    public String toStringFormat2() {
        String daten = toStringCsv2();

        int zaehler = 1;
        int[] index = new int[daten.split(Constants.COMMA).length+1];

        for( int i = 0; i<daten.length(); i++ ) {
            if( daten.charAt(i) == Constants.COMMA_CHAR ){
                index[zaehler] = i-1;
                zaehler++;
            }
            index[zaehler] = daten.length()-1;
        }

//        for(int k = 0; k<index.length; k++){
//            System.out.println(index[k]);
//        }
//        0      7 9 11                 31  33 36 38 40    46
//        Wohnhaus;0;Adresse 1, 1010 Stadt; 50.0 ; A; 10000.0
        StringBuilder builder = new StringBuilder();
        builder.append("Stelle   ").append(index[0]).append("-").append(index[1]).append(": ").append(super.getClass().getSimpleName()).append("\n")
                .append("Stelle     ").append(index[2]).append(": ").append(super.getIdentifikationsNr()).append("\n")
                .append("Stelle ").append(index[2]+2).append("-").append(index[3]).append(": ").append(super.getAdresse()).append("\n")
                .append("Stelle ").append(index[3]+2).append("-").append(index[4]).append(": ").append(super.getFlaeche()).append("\n")
                .append("Stelle    ").append(index[5]).append(": ").append(getKategorie()).append("\n")
                .append("Stelle ").append(index[5]+2).append("-").append(index[6]).append(": ").append(getEinheitswert());

      return builder.toString();

    }


    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        return build.append("ID: ").append(getIdentifikationsNr()).append(" || ").append("Wohnhaus ").append("@ ").append(super.toString()).append(" -> ").append("Kat. ").append(this.kategorie).append(", € ").append(berechneVerkehrswert()).toString();
    }


}
