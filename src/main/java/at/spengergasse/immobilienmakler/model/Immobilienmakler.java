package at.spengergasse.immobilienmakler.model;

import at.spengergasse.immobilienmakler.enumeration.PersisterType;
import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.exception.PersisterException;
import at.spengergasse.immobilienmakler.exception.PersisterException2;
import at.spengergasse.immobilienmakler.persistence.BinaerPersister2;
import at.spengergasse.immobilienmakler.persistence.Persistable2;
import at.spengergasse.immobilienmakler.persistence.TextPersister2;
import at.spengergasse.immobilienmakler.sortieren.ImmobilieAdresseComparator;
import at.spengergasse.immobilienmakler.sortieren.ImmobilienFlaechenComparator;
import at.spengergasse.immobilienmakler.sortieren.ImmobilienIdentifikationsNrComparator;

import java.io.*;
import java.util.*;


public class Immobilienmakler {     //Konrext Klasse

    private String name;
    private List<Immobilie> immobilienListe;
    //    private Map<Persistable.Type, Persistable<List<Immobilie>>> immobilienPersisterMap;
    private Persistable<Immobilie> immobilienPersister;     //In der Context Klasse die Strategy Implementation.
    private Persistable2<Immobilie> immobilienPersister2;
    private Map<PersisterType, Persistable2<Immobilie>> persistable2Map;        ////// 1.

    public Immobilienmakler(){
        this.immobilienListe = new ArrayList<Immobilie>();
        initPersister();
    }

    public Immobilienmakler(String name) throws ImmobilienException {
        setName(name);
        this.immobilienListe = new ArrayList<Immobilie>();
        initPersister();        ////// 3.

    }

    public void initPersister() {        ////// 2.
        this.persistable2Map = new HashMap<>();
        persistable2Map.put(PersisterType.SER, new BinaerPersister2());
        persistable2Map.put(PersisterType.CSV, new TextPersister2());
    }

    protected Immobilienmakler(String name, Persistable<Immobilie> persister) throws ImmobilienException {
        setName(name);
        immobilienListe = new ArrayList<>();
        setImmobilienPersister(persister);

    }

    public Immobilienmakler(String name, Persistable2<Immobilie> persister) throws ImmobilienException {
        setName(name);
        immobilienListe = new ArrayList<>();
        setImmobilienPersister2(persister);
        initPersister();
    }


    public Persistable2<Immobilie> getPersisterMap(PersisterType type) {        ////// 4.

        return persistable2Map.get(type);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Immobilie> getImmobilien() throws ImmobilienException {
        return (ArrayList<Immobilie>) immobilienListe;
    }

    public List<Immobilie> getAll()/* throws ImmobilienException */{
//        if(immobilienListe != null) {
            return new ArrayList<>(immobilienListe);
//        }else{
//            throw new ImmobilienException("Null-Ref bei getAll()");
//        }
    }

    public Immobilie getId(Integer id)throws ImmobilienException{
        Immobilie tempImmobilie = null;
        if(id != null){
            for(Immobilie ib : immobilienListe){
                if(id.equals(ib.getIdentifikationsNr())){
                    tempImmobilie = ib;
                }
            }
        }else{
            throw new ImmobilienException("Null-Ref bei getId() übergeben!");
        }
        if(tempImmobilie != null){
            return tempImmobilie;
        }else{
            throw new ImmobilienException("Keine Immobilie mit dieser Id "+id+" vorhanden!");
        }
    }

    public Persistable<Immobilie> getImmobilienPersister() {
        return this.immobilienPersister;
    }

    public Persistable2<Immobilie> getImmobilienPersister2() {
        return this.immobilienPersister2;
    }

    public void setImmobilienPersister(Persistable<Immobilie> persister) {
        if( persister != null ) {
            this.immobilienPersister = persister;
        }else {
            throw new PersisterException("Null-Ref bei \"setImmobilienPersister()\"");
        }
    }

    public void setImmobilienPersister2(Persistable2<Immobilie> persister2) {
        if( persister2 != null ) {
            this.immobilienPersister2 = persister2;
        }else {
            throw new PersisterException2("Null-Ref bei \"setImmobilienPersister\"");
        }

    }

    public void setName(String name) throws ImmobilienException {
        if( name != null ) {
            if( !name.isBlank() ) {
                this.name = name;
            }else {
                throw new ImmobilienException("Leerzeichen bei setName().");
            }
        }else {
            throw new ImmobilienException("Null-Ref. bei setName().");
        }
    }


    public void add(Immobilie immobilie) throws ImmobilienException {
        if( immobilie != null ) {
            if( !immobilienListe.contains(immobilie) ) {
                immobilienListe.add(immobilie);
            }else {
                throw new ImmobilienException("Immobilie existiert bereits in der Kollektion!");
            }
        }else {
            throw new ImmobilienException("Null-Ref. bei add()");
        }
    }

    public String immobilienListe() throws ImmobilienException {
        String liste = "";
        if( !immobilienListe.isEmpty() ) {
            for( Immobilie ib1 : immobilienListe ) {
                liste += ib1.toString() + "\n";
            }
        }else {
            throw new ImmobilienException("Immobilien Liste ist leer.");
        }
        return liste;
    }

    public double berechneGesamtwert() throws ImmobilienException {
        double gesamtWert = 0;
        if( !immobilienListe.isEmpty() ) {
            for( Immobilie ib : immobilienListe ) {
                gesamtWert += ib.berechneVerkehrswert();
            }
        }else {
            throw new ImmobilienException("Immobilien Liste ist leer!");
        }
        return gesamtWert;
    }

    public boolean remove(int pos) throws ImmobilienException {
        if( !immobilienListe.isEmpty() ) {
            if( pos>=0 && pos<=immobilienListe.size() - 1 ) {
                Iterator<Immobilie> iter = immobilienListe.iterator();
                Immobilie ib1;
                while( iter.hasNext() ) {
                    ib1 = iter.next();
                    if( immobilienListe.indexOf(ib1) == pos ) {
                        iter.remove();
                        return true;
                    }
                }
            }else {
                throw new ImmobilienException("pos muss zwische 0 und " + ( immobilienListe.size() - 1 ) + " liegen. Ihre Eingabe: " + pos);
            }
        }else {
            throw new ImmobilienException("Immobilie Liste ist leer!");
        }
        return false;
    }

    public int remove(String adresse) throws ImmobilienException {
        int zaehler = 0;
        if( adresse != null ) {
            if( !adresse.isEmpty() && adresse.length()>2 ) {
                if( !immobilienListe.isEmpty() ) {
                    Iterator<Immobilie> iterator = immobilienListe.iterator();
                    Immobilie immo;
                    while( iterator.hasNext() ) {
                        immo = iterator.next();
                        if( immo.getAdresse().equals(adresse) ) {
                            iterator.remove();
                            zaehler++;
                        }
                    }

                }else {
                    throw new ImmobilienException("Immobilien Liste ist leer.");
                }
            }else {
                throw new ImmobilienException("Leerzeichen Übergabe oder Länge von Adresse ist kleiner als 2 Zeichen bei remove(adresse).");
            }
        }else {
            throw new ImmobilienException("Null-Ref. bei remove(adresse).");
        }
        return zaehler;
    }

    public int remove(double flaeche) throws ImmobilienException {
        int anzahl = 0;
        if( flaeche>=Constants.MIN_FLAECHE_WOHNHAUS && flaeche<=( Constants.MAX_FLAECHE_GRUNDSTUECK*2 ) ) {
            if( !immobilienListe.isEmpty() ) {
                Iterator<Immobilie> iter = immobilienListe.iterator();
                Immobilie immo;
                while( iter.hasNext() ) {
                    immo = iter.next();
                    if( immo.getFlaeche()<flaeche ) {
                        iter.remove();
                        anzahl++;
                    }
                }
            }else {
                throw new ImmobilienException("Liste ist leer!");
            }
        }else {
            throw new ImmobilienException("Flaeche muss zwische " + Constants.MIN_FLAECHE_WOHNHAUS + " und " + ( Constants.MAX_FLAECHE_GRUNDSTUECK + 1 ) + " sein. Übergebener Parameter ist: " + flaeche);
        }

        return anzahl;
    }

    public boolean removeEntity(Immobilie immobilie) throws ImmobilienException{
        if(immobilie != null){
            return removeID(immobilie.getIdentifikationsNr());
        }else{
            throw new ImmobilienException("Null-Ref bei removeEntity()");
        }
    }


    public boolean removeID(Integer id)throws ImmobilienException{
        if(id != null){
            Iterator<Immobilie> iter = immobilienListe.iterator();
            while(iter.hasNext()){
               if(iter.next().getIdentifikationsNr().equals(id)){
                   iter.remove();
                   return true;
               }
            }
            return false;
        }else{
            throw new ImmobilienException("Null-Ref bei removeId().");
        }
    }

    public double berechneGesamtProvision() throws ImmobilienException {
        double provisionGrundstueck = 0.0;
        double provisionWohnhaus = 0.0;
        if( !immobilienListe.isEmpty() ) {
            for( Immobilie immo : immobilienListe ) {
                if( immo instanceof Grundstueck ) {
                    provisionGrundstueck += immo.berechneVerkehrswert();
                }else {
                    provisionWohnhaus += immo.berechneVerkehrswert();
                }
            }
        }else {
            throw new ImmobilienException("Liste ist leer!");
        }
        System.out.println(provisionGrundstueck + " und " + provisionWohnhaus);
        return ( ( provisionGrundstueck*0.03 ) + ( provisionWohnhaus*0.05 ) );
    }

    public void sortiereVerkehrswert() {
        Collections.sort(immobilienListe);
    }

    public void sortiereAdresse() {
        Collections.sort(immobilienListe, new ImmobilieAdresseComparator());
    }

    public void sortiereAdresse(boolean asc) {
        if( asc ) {
            Collections.sort(immobilienListe, new ImmobilieAdresseComparator());
        }else {
            Collections.sort(immobilienListe, new ImmobilieAdresseComparator().reversed());
        }
    }

    public void sortiereFlaeche(boolean asc) {
        if( asc ) {
            Collections.sort(immobilienListe, new ImmobilienFlaechenComparator());
        }else {
            Collections.sort(immobilienListe, new ImmobilienFlaechenComparator().reversed());
        }
    }

    public void sortiereFlaecheNatuerlichesSortieren() {
        Collections.sort(immobilienListe);
    }

    public void sortiereIdentifikationsNr(boolean asc) {
        if( asc ) {
            Collections.sort(immobilienListe, new ImmobilienIdentifikationsNrComparator());
        }else {
            Collections.sort(immobilienListe, new ImmobilienIdentifikationsNrComparator().reversed());
        }
    }

    public void saveImmobilie(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));

            ) {
                objectOutputStream.writeObject(immobilienListe);

            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FNF Exception beim Speichern der Datei: " + filename + e.getMessage(), e);
            }catch (IOException e) {
                throw new ImmobilienException("IO Exception beim Speichern der Datei: " + filename + e.getMessage(), e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Speichern der Datei: " + filename);
        }
    }

    public void loadImmobilie(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));) {
                Object o = objectInputStream.readObject();
                immobilienListe = (List<Immobilie>) o;
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FNF Exception beim Laden der Datei: " + e.getMessage(), e);
            }catch (IOException e) {
                throw new ImmobilienException("IOException beim Laden der Datei: " + e.getMessage(), e);
            }catch (ClassNotFoundException e) {
                throw new ImmobilienException("ClassNotFoundException beim Laden der Datei: " + e.getMessage(), e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Laden der Datei: " + filename);
        }
    }

    public void exportImmobilienCsv(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
                for( Immobilie immobilie : immobilienListe ) {
                    bufferedWriter.write(immobilie.toStringCsv() + Constants.LINE_BREAK);
                }
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FNF Exception beim exportieren der Datei: " + e.getMessage(), e);
            }catch (IOException e) {
                throw new ImmobilienException("IOException beim exportieren der Datei: " + e.getMessage(), e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim exportieren der Datei: " + filename);
        }
    }

    public void importieren(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                String line = bufferedReader.readLine();
                int zeile = 1;

                while( line != null ) {
                    try {
                        String[] datenArray = line.split(Constants.COMMA);

                        switch(datenArray[0]) {
                            case "Grundstueck":
                                immobilienListe.add(new Grundstueck(datenArray));
                                break;
                            case "Wohnhaus":
                                immobilienListe.add(new Wohnhaus(datenArray));
                                break;
                            default:
                                throw new ImmobilienException("Klasse \"" + datenArray[0] + "\" wird nicht unterstützt!");
                        }

                    }catch (ImmobilienException e) {
                        System.err.println("Fehler beim Einlesen der Daten - Zeile " + zeile + ".  " + e.getMessage());
                    }

                    line = bufferedReader.readLine();
                    zeile++;
                }

            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FNF Exception beim Improtieren der Datei: " + e.getMessage(), e);
            }catch (IOException e) {
                throw new ImmobilienException("IOException beim Importieren der Datei: " + e.getMessage(), e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Importieren der Datei: " + filename);
        }
    }

    public void exportWohnhaeuser(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename));) {
                for( Immobilie immobilie : immobilienListe ) {
                    if( immobilie instanceof Wohnhaus ) {
                        bw.write(( (Wohnhaus) immobilie ).toStringFormat());
                    }
                }
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                throw new ImmobilienException("FileNotFoundException beim Exportieren des Formates: Datei: " + filename);
            }

        }else {
            throw new ImmobilienException("Null-Ref beim Exportieren des Formates! Datei: " + filename);
        }
    }

    public void importWohnhaeuser(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
                String line = br.readLine();
                int zeile = 1;
                int zaehler = 0;

                String[] wHausArray = new String[100];

                while( line != null ) {

                    try {

                        String[] datenArray2 = line.split(Constants.SPACE);
                        ArrayList<String> datenArray3 = new ArrayList<String>();
                        String[] datenArray4 = new String[datenArray2.length];


                        //doppelpunkt in den Strings entfernen ----
                        try {
                            for( int g = 0; g<datenArray2.length; g++ ) {

                                String[] datenArray = datenArray2[g].split(Constants.COLON);
                                datenArray3.add(datenArray[0]);
                            }
                            //----

                            for( int i = 0; i<1; i++ ) {
                                if( !datenArray3.get(2).equals("Adresse") ) {
                                    wHausArray[zaehler] = datenArray3.get(3);
//                                    System.out.println(wHausArray[zaehler]);
                                    zaehler++;

                                }else {
                                    for( int b = 3; b<( datenArray3.size() ); b++ ) {
                                        wHausArray[zaehler] = datenArray3.get(b);
                                        zaehler++;
                                    }
                                }
                            }

                            if( datenArray3.get(2).equals("Einheitswert") ) {
                                immobilienListe.add(new Wohnhaus(wHausArray));
                                wHausArray = new String[100];
                                zaehler    = 0;

                            }
                        }catch (IndexOutOfBoundsException e) {
                            throw new ImmobilienException("IOBException beim Importieren der Datein. ");
                        }

                    }catch (ImmobilienException e) {
                        throw new ImmobilienException("Fehler beim Importieren der Daten: " + filename + ", Zeile: " + zeile + " " + e.getMessage(), e);
                    }

                    line = br.readLine();
                    zeile++;

                }

            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FileNotFoundException beim Importieren der Wohnhaeuser. Datei: " + filename);
            }catch (IOException e) {
                throw new ImmobilienException("IOException beim Importieren der Wohnhauser. Datei: " + filename);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Importieren der Wohnhaeuser. Datei: " + filename);
        }
    }

    public void exportWohnhaeuser_2(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                for( Immobilie immobilie : immobilienListe ) {
                    if( immobilie instanceof Wohnhaus ) {
                        bw.write(( (Wohnhaus) immobilie ).toStringFormat() + "\n");

                    }
                }
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FNFException beim Wohnhaus-Exportieren. Datei: " + filename);
            }catch (IOException e) {
                throw new ImmobilienException("IOException beim Wohnhaus-Exportieren. Datei: " + filename);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Importieren der Wohnhaeuser. Datei: " + filename);
        }
    }

    /*public void netTest(String filename) throws ImmobilienException {
        int zaehler = 1;

        while(true) {
            System.out.println(zaehler);
            try {
                URL url = new URL("https://www.mein-kampfsport-verein.com/");
                Scanner s = new Scanner(url.openStream(), "UTF-8");
//            BufferedReader bufferedReader = new BufferedReader(s);
                try (
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))
                ) {

                        String line = s.nextLine();
                       while (line != null) {
                           try {
                               for (int i = 0; i < s.nextLine().length(); i++) {
                                   bufferedWriter.write(s.nextLine() + "\n");
                               }
                           } catch (ArrayIndexOutOfBoundsException e) {
                               e.printStackTrace();
                           }

                           line = s.nextLine();
                       }



                }
                s.close();


            } catch (MalformedURLException e) {
                throw new ImmobilienException("Parsende URL ist falsch!");
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            }catch (IllegalArgumentException e){
                throw new ImmobilienException("IllegalArgumentException beim warten des Aufrufs.");
            }catch (InterruptedException e){
                throw new ImmobilienException("InterruptedException beim warten des Aufrufs.");
            }
            zaehler++;
        }
    }

    public void importierennetUrl(String filename) throws ImmobilienException {
        if (filename != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                String line = bufferedReader.readLine();
                int zeile = 1;

                while (line != null) {
                    try {
                        String[] datenArray = line.split(",");

                        for(int i = 0; i< datenArray.length;i++){
                           String wort = datenArray[i];

                           if(wort.contains("Password") || wort.contains("password")){
                               System.out.println(datenArray[i]);

                            }

                           *//*for(int j = 0; j<datenArray[i].length(); j++){
                              if(wort.charAt(j) == 'L' && wort.charAt(j+1) == 'o' && wort.charAt(j+2) == 'g' && wort.charAt(j+3) == 'i' && wort.charAt(j+3) == 'i'){
                                  System.out.println(zeile);
                                  System.out.println(wort);
                              }
                              }*//*
                           zeile++;
                           }





                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Fehler beim Einlesen der Daten - Zeile " + zeile + ".  " + e.getMessage());
                    }

                    line = bufferedReader.readLine();
                    zeile++;
                }

            } catch (FileNotFoundException e) {
                throw new ImmobilienException("FNF Exception beim Improtieren der Datei: " + e.getMessage(), e);
            } catch (IOException e) {
                throw new ImmobilienException("IOException beim Importieren der Datei: " + e.getMessage(), e);
            }
        } else {
            throw new ImmobilienException("Null-Ref beim Importieren der Datei: " + filename);
        }
    }*/

    public void saveMakler(String pathname) throws ImmobilienException {
        if( pathname != null ) {
            String pathnameAusgabe = pathname + this.name + ".ser";
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathnameAusgabe));) {
                objectOutputStream.writeObject(this.immobilienListe);
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FNFException beim Speichern des Pathnames! Pathname: " + pathname + " " + e.getMessage());
            }catch (IOException e) {
                throw new ImmobilienException("IOException beim Speichern des Pathnames! Pathname: "/* + pathname + " " */ + e.getMessage());
            }

        }else {
            throw new ImmobilienException("Null-Ref beim Speichern des Pathnames! Pathname: " + pathname);
        }
    }

    public void loadMakler(String filename) throws ImmobilienException {


        if( filename != null ) {
            String maklerName = this.name;
            String pathname = filename;
            String loadData = filename + maklerName + ".ser";


            try(
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(loadData))

            ) {
                Object o = objectInputStream.readObject();

                this.immobilienListe = (List<Immobilie>) o;
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("FileNotFoundException beim Laden des Maklers! " + e.getMessage());
            }catch (IOException e) {
                throw new ImmobilienException("IOException beim Laden des Maklers!" + e.getMessage());
            }catch (ClassNotFoundException e) {
                throw new ImmobilienException("ClassNotFoundException beim Laden des Maklers!" + e.getMessage());
            }


        }else {
            throw new ImmobilienException("Null-Ref beim Speichern des Pathnames! Pathname: " + filename);
        }
    }

//    public void save()

//    public void speichern(Persistable.Type type, String filename)throws ImmobilienException{
//        Persistable<List<Immobilie>> persister = getPersister(type);
//        if(persister == null){
//            throw new ImmobilienException("Persister "+type+ " nicht gefunden");
//        }
//        persister.speichern(filename, immobilienListe);
//
//    }

//    public Persistable<List<Immobilie>> getPersister(Persistable.Type type){
//        return immobilienPersisterMap.get(type);
//    }


    public void speichern(String filename) throws ImmobilienException {
        if( filename != null ) {
            Persistable<Immobilie> persist = getImmobilienPersister();
            if( persist != null ) {
                persist.speichern(filename, this.immobilienListe);

            }else {
                throw new ImmobilienException("Null-Ref beim persist/speicher!");
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Speichern der Datei: " + filename);
        }
    }

    public void laden(String filename) throws ImmobilienException {
        if( filename != null ) {
            Persistable<Immobilie> persist = getImmobilienPersister();
            if( persist != null ) {
                immobilienListe.clear();
                immobilienListe.addAll(getImmobilienPersister().laden(filename));
            }else {
                throw new ImmobilienException("Null-Ref beim persist/Laden!");
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Laden. - " + filename);
        }
    }

    public void saveImmobilien2(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            ) {
                oos.writeObject(immobilienListe);
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei : \"" + filename + "\" konnte nicht gefunden werden! ", e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese oder Schreibfehler beim Speichern der Datei: \"" + filename + "\"!");
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Speichern der Datei: " + filename + ".");
        }
    }

 /*   //////////////////////////////////////////////////////////////
    public static void saveImmobilienTest(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            ) {
                oos.writeObject(immobilienListe);
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei : \"" + filename + "\" konnte nicht gefunden werden! ", e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese oder Schreibfehler beim Speichern der Datei: \"" + filename + "\"!");
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Speichern der Datei: " + filename + ".");
        }
    }
    //////////////////////////////////////////////////////////////*/

    public void loadImmobilien2(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))
            ) {
                Object o = ois.readObject();
                this.immobilienListe = (List<Immobilie>) o;
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei \"" + filename + "\" nicht gefunden!");
            }catch (IOException e) {
                throw new ImmobilienException("Lese oder Schreibfehler beim Laden der Datei: \"" + filename + "\"!");
            }catch (ClassNotFoundException e) {
                throw new ImmobilienException("Klassen Kollision beim Laden der Datei: \"" + filename + "\"!");
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Laden der Datei: " + filename);
        }
    }


    public void exportImmobilienCsv2(String filename) throws ImmobilienException {

        if( filename != null ) {
            try(
                    BufferedWriter bw = new BufferedWriter(new FileWriter(filename))
            ) {
                for( Immobilie immobilie : immobilienListe ) {
                    bw.write(immobilie.toStringCsv2() + Constants.LINE_BREAK);
                }
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei \"" + filename + "\" konnte beim Exportieren nicht gefunden werden!", e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese oder Schreibfehler beim Exportieren der Datei \"" + filename + "\"", e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Exportieren der Daten: " + filename);
        }
    }

    public void importImmobileinCsv2(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))
            ) {


                int zeile = 1;
                String line = bufferedReader.readLine();
                while( line != null ) {
                    //            Index         0 1                   2     3 4       5
                    //                Grundstueck;0;Gasse 1, 1010 Stadt;100.0;B;10000.0
                    try {
                        String[] dataLine = line.split(Constants.COMMA);
                        switch(dataLine[0]) {
                            case "Grundstueck":
                                immobilienListe.add(new Grundstueck(dataLine));
                                break;
                            case "Wohnhaus":
                                immobilienListe.add(new Wohnhaus(dataLine));
                                break;
                            default:
                                throw new ImmobilienException("Subklasse \"" + dataLine[0] + "\" in der Zeile >" + zeile + "< wird leider nicht unterstützt!");
                        }
                    }catch (ImmobilienException e) {
                        System.out.println("Fehler beim Einlesen der Daten in der Zeile :" + zeile + ". " + e.getMessage());
//                       throw new ImmobilienException("Fehler beim Einlesen der Daten in der Zeile :"+zeile+". "+ e.getMessage(),e );
                    }
                    line = bufferedReader.readLine();
                    zeile++;
                }
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei \"" + filename + "\" konnte beim Importieren nicht gefunden werden!", e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese oder Schreibfehler beim Importieren der Datei \"" + filename + "\"", e);
            }

        }else {
            throw new ImmobilienException("Null-Ref beim Importieren der Daten: " + filename);
        }
    }

    public void exportWohnhaeuser2(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))
            ) {
                for( Immobilie immobilie : immobilienListe ) {
                    if( immobilie instanceof Wohnhaus ) {
                        bufferedWriter.write(( (Wohnhaus) immobilie ).toStringFormat2() + "\n");
                    }
                }
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei \"" + filename + "\" konnte beim Exportieren der Wohnhäuser nicht gefunden werden!", e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese oder Schreibfehler beim Exportieren der Wohnhäuser. Datei: \"" + filename + "\"", e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Laden der Wohnhäuser. Dateiname: " + filename);
        }
    }


    public void importWohnhaeuser2(String filename) throws ImmobilienException {
        if( filename != null ) {
            try(
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))
            ) {
                String dataLine = bufferedReader.readLine();
                int zeile = 1;
                int zaehler = 0;
                int klassenZeile = 1;
                String[] datenArray;
                String[] wohnhausDaten = new String[6];
                int[] fehlerhafteZeilen = new int[6];

                while( dataLine != null ) {
                    try {
                        datenArray             = dataLine.split(Constants.COLON);
                        wohnhausDaten[zaehler] = datenArray[1].trim();
                        zaehler++;


                        if( wohnhausDaten[0].equals("Wohnhaus") ) {

                            if( zaehler == 6 ) {
                                zaehler = 0;
//                                if( wohnhausDaten[0].equals("Wohnhaus") ) {
                                immobilienListe.add(new Wohnhaus(wohnhausDaten));
                                klassenZeile++;

//                                }else {
//                                    throw new ImmobilienException("Übergebene Klasse " + wohnhausDaten[0] + " wird nicht unterstützt!");
//                                }
                            }
                        }else {
                            fehlerhafteZeilen[zaehler - 1] = zeile;
                            if( zaehler == 6 ) {
                                zaehler = 0;
                                if( fehlerhafteZeilen[5] != 0 ) {
                                    throw new ImmobilienException("Übergebene Klasse \"" + wohnhausDaten[0] + "\" wird nicht unterstützt! \n" + "Die Zeilen " + fehlerhafteZeilen[0] + ", " + fehlerhafteZeilen[1] + ", " + fehlerhafteZeilen[2] + ", " + fehlerhafteZeilen[3] + ", " + fehlerhafteZeilen[4] + ", " + fehlerhafteZeilen[5] + ", konnten nicht der Liste hinzugefügt werden.");
                                }
                            }
                        }


                    }catch (ImmobilienException e) {
                        System.err.println("Fehler/Stop in der Zeile \"" + zeile + "\". " + e.getMessage());
                        System.err.println(klassenZeile + ". zu Importierende Klasse fehlerhaft.");
                    }catch (ArrayIndexOutOfBoundsException e) {
                        throw new ImmobilienException("ArrayIndexOutOfBoundsException in der Zeile: " + zeile + " beim Importieren der Wohnhäuser. Datei: \"" + filename + "\" " + e.getMessage());
                    }
                    dataLine = bufferedReader.readLine();

                    zeile++;
                }
                if( dataLine == null ) {
                    dataLine = bufferedReader.readLine();
                }

            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei \"" + filename + "\" konnte beim Importieren der Wohnhäuser nicht gefunden werden!", e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese oder Schreibfehler beim Importieren der Wohnhäuser. Datei: \"" + filename + "\"", e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Importieren der Wohnhäuser. Datei: " + filename);
        }
    }

    public void saveMakler2(String pathname) throws ImmobilienException {
        if( pathname != null ) {
            String pathnameMakler = pathname + "/" + this.name + ".ser";
            try(
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathnameMakler))
            ) {
                objectOutputStream.writeObject(this.immobilienListe);
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei konnte nicht gefunden werden. Datei: " + pathnameMakler + e.getMessage(), e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese und Schreibfehler beim Speichern der Datei: " + pathnameMakler + " " + e.getMessage(), e);
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Pathname. Datei: " + pathname);
        }
    }

    public void loadMakler2(String filename) throws ImmobilienException {
        if( filename != null ) {
            String dateiName = filename;
            String pathname = dateiName + "/" + this.name + ".ser";
            try(
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname))
            ) {
                Object o = objectInputStream.readObject();
                this.immobilienListe = (List<Immobilie>) o;
            }catch (FileNotFoundException e) {
                throw new ImmobilienException("Datei konnte nicht gefunden werden. Datei: " + pathname + e.getMessage(), e);
            }catch (IOException e) {
                throw new ImmobilienException("Lese und Schreibfehler beim Speichern der Datei: " + pathname + " " + e.getMessage(), e);
            }catch (ClassNotFoundException e) {
                throw new ImmobilienException("Klasse konnte nicht gefunden werden. Datei: " + pathname + e.getMessage(), e);
            }


        }else {
            throw new ImmobilienException("Null-Ref beim Laden der Datei " + filename);
        }
    }

    public void speichern2(String filename) throws ImmobilienException {
        if( filename != null ) {
            if( getImmobilienPersister2() != null ) {
                this.immobilienPersister2.speichern2(filename, this.immobilienListe);
            }else {
                throw new PersisterException2("Persister ist nicht gesetzt! .");
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Persistieren der Daten: " + filename);
        }
    }

    public void speichern2Map(String filename, PersisterType type) throws ImmobilienException {
        if( filename != null ) {
            if( getPersisterMap(type) != null ) {
                getPersisterMap(type).speichern2(filename, this.immobilienListe);
            }else {
                throw new PersisterException2("Persister ist nicht gesetzt! .");
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Persistieren der Daten: " + filename);
        }
    }

    public void laden2(String filename) throws ImmobilienException {
        if( filename != null ) {
            if( getImmobilienPersister2() != null ) {
                immobilienListe.clear();
                immobilienListe.addAll(this.immobilienPersister2.laden2(filename));
            }else {
                throw new PersisterException2("Persister ist nicht gesetzt! .");
            }

        }else {
            throw new ImmobilienException("Null-Ref beim Laden der Datei: " + filename);
        }
    }

    public void laden2Map(String filename, PersisterType type) throws ImmobilienException {
        if( filename != null ) {
            if( type != null ) {
                immobilienListe.clear();
                immobilienListe.addAll(getPersisterMap(type).laden2(filename));
            }
        }else {
            throw new ImmobilienException("Null-Ref beim Laden der Datei: " + filename);
        }
    }

    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(this.name).append(", derzeit ").append(immobilienListe.size()).append(" Immobilien\n");
        for( Immobilie immo : immobilienListe ) {
            build.append(immo.toString()).append("\n");
        }
        return build.toString();
    }



}



