package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Grundstueck;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.model.Wohnhaus;
import at.spengergasse.immobilienmakler.persistence.BinaerPersister2;
import at.spengergasse.immobilienmakler.persistence.TextPersister2;


public class TestDatenImmobilien {
    public Immobilienmakler testDaten() throws ImmobilienException {
        Immobilienmakler ib1 = new Immobilienmakler("Makler 1");
        Grundstueck g1 = new Grundstueck("Fasangasse 1, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g2 = new Grundstueck("Mamutgasse 2, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g3 = new Grundstueck("Löwengsse 3, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g4 = new Grundstueck("Ludwiggasse 4, 1010 Stadt", 100, 'B', 10000);
        Wohnhaus w1 = new Wohnhaus("Tannenbaumgasse 5, 1010 Stadt", 'A', 10000, 50);
        Wohnhaus w2 = new Wohnhaus("Druckergasse 6, 1010 Stadt", 'B', 10000, 50);
        Wohnhaus w3 = new Wohnhaus("Wohnhausgasse 7, 1010 Stadt", 'C', 10000, 50);
        Wohnhaus w4 = new Wohnhaus("Gassengasse 8, 1010 Stadt", 'D', 10000, 50);

        ib1.add(g1);
        ib1.add(g2);
        ib1.add(g3);
        ib1.add(g4);
        ib1.add(w1);
        ib1.add(w2);
        ib1.add(w3);
        ib1.add(w4);
        return ib1;
    }
    public Immobilienmakler testDaten2() throws ImmobilienException {
        Immobilienmakler ib1 = new Immobilienmakler("Makler 1", new BinaerPersister2());
        Grundstueck g1 = new Grundstueck("Fasangasse 1, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g2 = new Grundstueck("Mamutgasse 2, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g3 = new Grundstueck("Löwengsse 3, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g4 = new Grundstueck("Ludwiggasse 4, 1010 Stadt", 100, 'B', 10000);
        Wohnhaus w1 = new Wohnhaus("Tannenbaumgasse 5, 1010 Stadt", 'A', 10000, 50);
        Wohnhaus w2 = new Wohnhaus("Druckergasse 6, 1010 Stadt", 'B', 10000, 50);
        Wohnhaus w3 = new Wohnhaus("Wohnhausgasse 7, 1010 Stadt", 'C', 10000, 50);
        Wohnhaus w4 = new Wohnhaus("Gassengasse 8, 1010 Stadt", 'D', 10000, 50);

        ib1.add(g1);
        ib1.add(g2);
        ib1.add(g3);
        ib1.add(g4);
        ib1.add(w1);
        ib1.add(w2);
        ib1.add(w3);
        ib1.add(w4);
        return ib1;
    }
    public Immobilienmakler testDaten3() throws ImmobilienException {
        Immobilienmakler ib1 = new Immobilienmakler("Makler 1", new TextPersister2());
        Grundstueck g1 = new Grundstueck("Fasangasse 1, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g2 = new Grundstueck("Mamutgasse 2, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g3 = new Grundstueck("Löwengsse 3, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g4 = new Grundstueck("Ludwiggasse 4, 1010 Stadt", 100, 'B', 10000);
        Wohnhaus w1 = new Wohnhaus("Tannenbaumgasse 5, 1010 Stadt", 'A', 10000, 50);
        Wohnhaus w2 = new Wohnhaus("Druckergasse 6, 1010 Stadt", 'B', 10000, 50);
        Wohnhaus w3 = new Wohnhaus("Wohnhausgasse 7, 1010 Stadt", 'C', 10000, 50);
        Wohnhaus w4 = new Wohnhaus("Gassengasse 8, 1010 Stadt", 'D', 10000, 50);

        ib1.add(g1);
        ib1.add(g2);
        ib1.add(g3);
        ib1.add(g4);
        ib1.add(w1);
        ib1.add(w2);
        ib1.add(w3);
        ib1.add(w4);
        return ib1;
    }

    public Immobilienmakler testDaten4() throws ImmobilienException {
        Immobilienmakler ib1 = new Immobilienmakler("Makler 1");
        Grundstueck g1 = new Grundstueck("Fasangasse 1, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g2 = new Grundstueck("Mamutgasse 2, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g3 = new Grundstueck("Löwengsse 3, 1010 Stadt", 100, 'B', 10000);
        Grundstueck g4 = new Grundstueck("Ludwiggasse 4, 1010 Stadt", 100, 'B', 10000);
        Wohnhaus w1 = new Wohnhaus("Tannenbaumgasse 5, 1010 Stadt", 'A', 10000, 50);
        Wohnhaus w2 = new Wohnhaus("Druckergasse 6, 1010 Stadt", 'B', 10000, 50);
        Wohnhaus w3 = new Wohnhaus("Wohnhausgasse 7, 1010 Stadt", 'C', 10000, 50);
        Wohnhaus w4 = new Wohnhaus("Gassengasse 8, 1010 Stadt", 'D', 10000, 50);

        ib1.add(g1);
        ib1.add(g2);
        ib1.add(g3);
        ib1.add(g4);
        ib1.add(w1);
        ib1.add(w2);
        ib1.add(w3);
        ib1.add(w4);
        return ib1;
    }

}
