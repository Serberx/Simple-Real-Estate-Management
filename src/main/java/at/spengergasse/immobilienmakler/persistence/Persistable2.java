package at.spengergasse.immobilienmakler.persistence;

import java.util.List;

public interface Persistable2<T> {      //Strategy Klasse

    public List<T> laden2(String filename);
    public void speichern2(String filename, List<T> list);
}
