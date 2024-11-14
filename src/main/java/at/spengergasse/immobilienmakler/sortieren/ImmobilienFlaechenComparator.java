package at.spengergasse.immobilienmakler.sortieren;

import at.spengergasse.immobilienmakler.model.Immobilie;


import java.util.Comparator;

public class ImmobilienFlaechenComparator implements Comparator<Immobilie> {

    public int compare(Immobilie immo1, Immobilie immo2){
        double flaech1 = immo1.getFlaeche();
        double flaech2 = immo2.getFlaeche();

        return Double.compare(flaech1,flaech2);
    }
}
