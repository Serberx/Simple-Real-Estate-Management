package at.spengergasse.immobilienmakler.sortieren;

import at.spengergasse.immobilienmakler.model.Immobilie;


import java.util.Comparator;

public class ImmobilienIdentifikationsNrComparator implements Comparator<Immobilie> {


    @Override
    public int compare(Immobilie immobilie1, Immobilie immobilie2){
        int ident1 = immobilie1.getIdentifikationsNr();
        int ident2 = immobilie2.getIdentifikationsNr();

        return Integer.compare(ident1, ident2);
    }


}
