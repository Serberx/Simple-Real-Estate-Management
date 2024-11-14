package at.spengergasse.immobilienmakler.persistence;

import at.spengergasse.immobilienmakler.exception.PersisterException2;
import at.spengergasse.immobilienmakler.model.Immobilie;


import java.io.*;
import java.util.List;

public class BinaerPersister2 implements Persistable2<Immobilie> {       //Kontext Klasse

    @Override
    public List<Immobilie> laden2(String filename) {
            try(
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))
                    ){
                Object o = objectInputStream.readObject();
                return (List<Immobilie>) o;
            }catch (FileNotFoundException e) {
               throw new PersisterException2("Datei "+filename+" wurden beim Speichern nicht gefunden! ", e);
            }catch (IOException e) {
                throw new PersisterException2("Lese und Schreibfehler beim Laden der Datei: "+filename+". ", e);
            }catch (ClassNotFoundException e) {
               throw new PersisterException2("Klasse nicht gefunden. Datei: "+filename, e);
            }
    }

    @Override
    public void speichern2(String filename, List<Immobilie> list) {
        try(
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))
                ){
            objectOutputStream.writeObject(list);
        }catch (FileNotFoundException e) {
            throw new PersisterException2("Datei "+filename+" wurden beim Speichern nicht gefunden! "+e.getMessage(), e);
        }catch (IOException e) {
            throw new PersisterException2("Lese und Schreibfehler beim Speichern der Datei: "+filename+". "+e.getMessage(), e);
        }
    }

}
