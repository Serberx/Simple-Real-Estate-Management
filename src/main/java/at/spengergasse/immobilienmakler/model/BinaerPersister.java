package at.spengergasse.immobilienmakler.model;

import at.spengergasse.immobilienmakler.exception.PersisterException;


import java.io.*;
import java.util.List;

public class BinaerPersister implements Persistable<Immobilie> {        //Speicher Klassen, concrete classes

    @Override
    @SuppressWarnings ("unchecked")
    public List<Immobilie> laden(String filename) {
//        if( filename != null ) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));) {
            return (List<Immobilie>) objectInputStream.readObject();

        }catch(FileNotFoundException e) {
            throw new PersisterException("FileNotFoundException beim Deserialisieren." + e.getMessage(), e);
        }catch(IOException e) {
            throw new PersisterException("IOException beim Serialisieren." + e.getMessage(), e);
        }catch(ClassNotFoundException e) {
            throw new PersisterException("ClassNotFoundException beim Deserialisieren." + e.getMessage(), e);
        }

//        }else{
//            throw new PersisterException("Null-Ref beim Speichern der Deserialisierung. Datei: " + filename);
//        }
    }

    @Override
    public void speichern(String filename, List<Immobilie> liste) throws PersisterException {
//        if( filename != null ) {
//            if( liste != null ) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(liste);
        }catch(FileNotFoundException e) {
            throw new PersisterException("FileNotFoundException beim Serialisieren. - " + e.getMessage(), e);
        }catch(IOException e) {
            throw new PersisterException("IOException beim Serialisieren. - " + e.getMessage(), e);
        }
//            }else {
//                throw new PersisterException("Null-Ref beim Speichern der Serialisierung. Datei: " + filename);
//            }
//        }else {
//            throw new PersisterException("Null-Ref beim Speichern der Serialisierung. Datei: " + filename);
//        }
    }

}
