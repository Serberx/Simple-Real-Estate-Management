package at.spengergasse.immobilienmakler.persistence;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.exception.PersisterException2;
import at.spengergasse.immobilienmakler.model.Constants;
import at.spengergasse.immobilienmakler.model.Grundstueck;
import at.spengergasse.immobilienmakler.model.Immobilie;
import at.spengergasse.immobilienmakler.model.Wohnhaus;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TextPersister2 implements Persistable2<Immobilie> {        //Kontext Klasse

    @Override
    public List<Immobilie> laden2(String filename) {
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))
        ) {
            List<Immobilie> immobilies = new ArrayList<>();
            Optional<String> dataLine = Optional.ofNullable(bufferedReader.readLine());
            int zeile = 1;
            while( dataLine.isPresent() ) {
                try {
                    String[] dataArray = dataLine.get().split(Constants.COMMA);
                    switch(dataArray[0]) {
                        case "Grundstueck":
                            immobilies.add(new Grundstueck(dataArray));
                            break;
                        case "Wohnhaus":
                            immobilies.add(new Wohnhaus(dataArray));
                            break;
                        default:
                            throw new PersisterException2("Subklasse " + dataArray[0] + " wird leider nicht unterstützt! Zeile: " + zeile);
//                        default:System.err.println ("Subklasse "+dataArray[0]+" wird leider nicht unterstützt! Zeile: "+zeile);
                    }
                }catch (ImmobilienException | PersisterException2 e) {
//                    throw new PersisterException2("Fehler in der Zeile: "+zeile+". "+ e.getMessage(), e);
                    System.err.println("Fehler in der Zeile: " + zeile + ". " + e.getMessage());
                }


                dataLine = Optional.ofNullable(bufferedReader.readLine());
                zeile++;
            } return immobilies;
        }catch (FileNotFoundException e) {
            throw new PersisterException2("Datei " + filename + " wurden beim Importieren nicht gefunden! ", e);
        }catch (IOException e) {
            throw new PersisterException2("Lese und Schreibfehler beim Importieren der Datei: " + filename + ". " + e.getMessage(), e);
        }

    }

    @Override
    public void speichern2(String filename, List<Immobilie> list) {
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))
        ) {
            for( Immobilie immobilie : list ) {
                bufferedWriter.write(immobilie.toStringCsv2() + Constants.LINE_BREAK);
            }
        }catch (FileNotFoundException e) {
            throw new PersisterException2("Datei " + filename + " wurden beim Exportieren nicht gefunden! " + e.getMessage(), e);
        }catch (IOException e) {
            throw new PersisterException2("Lese und Schreibfehler beim Exportieren der Datei: " + filename + ". ", e);
        }
    }

}
