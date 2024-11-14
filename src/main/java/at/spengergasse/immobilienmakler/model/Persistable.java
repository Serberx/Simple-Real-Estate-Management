package at.spengergasse.immobilienmakler.model;

import java.util.List;

public interface Persistable<T> {       //Strategy

    enum Type{SER, TXT, CSV}

    public List<T> laden(String filename);
    public void speichern(String filename, List<T> liste);

}
