package at.spengergasse.immobilienmakler.model;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.exception.PersisterException;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextPersister implements Persistable<Immobilie> {       //Speicher Klassen, concrete classes


    @Override
    public List<Immobilie> laden(String filename) {

        List<Immobilie> immobilieListe = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            String line = bufferedReader.readLine();
            while( line != null ) {
                String[] datenArray = line.split(Constants.COMMA);
                switch(datenArray[0]) {
                    case "Wohnhaus":
                        immobilieListe.add(new Wohnhaus(datenArray));
                        break;
                    case "Grundstueck":
                        immobilieListe.add(new Grundstueck(datenArray));
                        break;
                }
               line = bufferedReader.readLine();
            }

        }catch (FileNotFoundException e) {
            throw new PersisterException("Datei "+filename+" nicht gefunden!", e);
        }catch (IOException e) {
           throw new PersisterException("IO-Exception beim Lesen und Schreiben der Datei! "+filename+". ",e);
        }catch (ImmobilienException e) {
            throw new PersisterException("Klasse nicht unterstuetzt! ", e);
        }
        return immobilieListe;
    }

    @Override
    public void speichern(String filename, List<Immobilie> liste) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for( Immobilie list1 : liste ) {
                bufferedWriter.write(list1.toStringCsv() + Constants.LINE_BREAK);
            }
        }catch (FileNotFoundException e) {
            throw new PersisterException("FileNotFoundException beim Exportieren. - " + e.getMessage(), e);
        }catch (IOException e) {
            throw new PersisterException("IOException beim Exportieren. - " + e.getMessage(), e);
        }
    }

}
