package at.spengergasse.immobilienmakler.sortieren;

import at.spengergasse.immobilienmakler.model.Immobilie;


import java.util.Comparator;


public class ImmobilieAdresseComparator implements Comparator<Immobilie> {

    @Override
    public int compare(Immobilie immobilie1, Immobilie immobilie2){
        String adresse1 = immobilie1.getAdresse();
        String adresse2 = immobilie2.getAdresse();

        return adresse1.compareTo(adresse2);
    }
}
