package at.spengergasse.immobilienmakler.testModel;

import at.spengergasse.immobilienmakler.exception.ImmobilienException;
import at.spengergasse.immobilienmakler.model.Constants;
import at.spengergasse.immobilienmakler.model.Grundstueck;
import at.spengergasse.immobilienmakler.model.Immobilienmakler;
import at.spengergasse.immobilienmakler.model.Wohnhaus;


public class TestImmobilienmakler {

    public Immobilienmakler erzeugeTestdaten() throws ImmobilienException {
        Immobilienmakler ib1 = new Immobilienmakler("Makler 2"/*, new BinaerPersister()*/);
        Wohnhaus w1 = new Wohnhaus("Fasangasse 11, 1030 Wien", 'A', 10000, 100);
        Wohnhaus w2 = new Wohnhaus("Hohlweggasse 22, 1154 Wien", 'C', 10000, 300);
        Wohnhaus w3 = new Wohnhaus("Quellenstrasse 33, 5699 Wien", 'B', 10000, 150);
        Grundstueck g1 = new Grundstueck("Thaliastrasse 44, 5566 Wien", 400, 'B', 222);
        Grundstueck g2 = new Grundstueck("DaistdieseStrasse 55, 4555 Wien", 500, 'G', 500);
        Grundstueck g3 = new Grundstueck("DankefürdieStrasse 66, 5252 Wien", 600, 'N', 444);
        ib1.add(g1);
        ib1.add(g2);
        ib1.add(w3);
        ib1.add(w2);
        ib1.add(w1);
        ib1.add(g3);

        return ib1;

    }

    public Immobilienmakler erzeugeTestdaten2() throws ImmobilienException {
        Immobilienmakler ib1 = new Immobilienmakler("Makler 1");
        Wohnhaus w1 = new Wohnhaus("Adresse 1, 1111 Wien", 'C', 10000, 50);
        Wohnhaus w2 = new Wohnhaus("Adresse 6, 1111 Wien", 'A', 10000, 50);
        Wohnhaus w3 = new Wohnhaus("Adresse 2, 1111 Wien", 'B', 10000, 50);
        Grundstueck g1 = new Grundstueck("Adresse 1, 1111 Wien", 10000, 'B', 500);
        Grundstueck g2 = new Grundstueck("Adresse 2, 1111 Wien", 10000, 'B', 500);
        Grundstueck g3 = new Grundstueck("Adresse 2, 1111 Wien", 10000, 'B', 500);
        ib1.add(w1);
        ib1.add(w2);
        ib1.add(w3);
        ib1.add(g1);
        ib1.add(g2);
        ib1.add(g3);

        return ib1;

    }

    public static void testName() {
        try {
            Immobilienmakler im1 = new Immobilienmakler(null);

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testNameLeerzeichen() {
        try {
            Immobilienmakler im1 = new Immobilienmakler("");

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testNameGueltig() {
        try {
            Immobilienmakler im1 = new Immobilienmakler("Makler 1");
            System.out.println(im1.getName());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAddNull() {
        try {
            Immobilienmakler m1 = new Immobilienmakler("makler1");
            Wohnhaus w1 = new Wohnhaus("Adresse1", 'A', 10000, 50);
            m1.add(null);
            System.out.println(m1.getImmobilien());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAddContainsSame() {
        try {
            Immobilienmakler m1 = new Immobilienmakler("makler1");
            Wohnhaus w1 = new Wohnhaus("Adresse1", 'A', 10000, 50);
            Wohnhaus w2 = new Wohnhaus("Adresse1", 'A', 10000, 50);
            m1.add(w1);
            m1.add(w1);

            System.out.println(m1.getImmobilien());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAddGueltig() {
        try {
            Immobilienmakler m1 = new Immobilienmakler("makler1");
            Wohnhaus w1 = new Wohnhaus("Adresse1", 'A', 10000, 50);
            Wohnhaus w2 = new Wohnhaus("Adresse1", 'A', 10000, 50);
            m1.add(w1);
            m1.add(w2);

            System.out.println(m1.getImmobilien());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testImmobilienListeEmpty() {
        try {
//            Immobilienmakler ib1 = new testImmobilienmakler().erzeugeTestdaten();
            Immobilienmakler ib2 = new Immobilienmakler("Makler2");
            System.out.println(ib2.immobilienListe());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testImmobilienListeGueltig() {
        try {
            Immobilienmakler ib1 = new TestImmobilienmakler().erzeugeTestdaten();
//            Immobilienmakler ib2 = new Immobilienmakler("Makler2");
            System.out.println(ib1.immobilienListe());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testBerechneGesamtwertEmpty() {
        try {
            Immobilienmakler ib1 = new TestImmobilienmakler().erzeugeTestdaten();
            Immobilienmakler ib2 = new Immobilienmakler("Makler 2");
            ib2.berechneGesamtwert();
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testRemovePosEmpty() {
        try {
            Immobilienmakler ib1 = new TestImmobilienmakler().erzeugeTestdaten();
            Immobilienmakler ib2 = new Immobilienmakler("Makler 2");
            ib2.remove(5);

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testRemovePosLow() {
        try {
            Immobilienmakler ib1 = new TestImmobilienmakler().erzeugeTestdaten();
//            Immobilienmakler ib2 = new Immobilienmakler("Makler 2");
            ib1.remove(-1);

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testRemovePosHigh() {
        try {
            Immobilienmakler ib1 = new TestImmobilienmakler().erzeugeTestdaten();
//            Immobilienmakler ib2 = new Immobilienmakler("Makler 2");
            ib1.remove(6);

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testRemovePosGueltig() {
        try {
            Immobilienmakler ib1 = new TestImmobilienmakler().erzeugeTestdaten();
//            Immobilienmakler ib2 = new Immobilienmakler("Makler 2");
            System.out.println(ib1.immobilienListe());
            ib1.remove(2);
            System.out.println(ib1.immobilienListe());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testRemovePosGueltig2() {
        try {
            Immobilienmakler ib1 = new TestImmobilienmakler().erzeugeTestdaten();
//            Immobilienmakler ib2 = new Immobilienmakler("Makler 2");
            System.out.println(ib1.immobilienListe());
            ib1.remove(4);
            System.out.println(ib1.immobilienListe());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeAdresseNull() {
        try {
            Immobilienmakler makler = new TestImmobilienmakler().erzeugeTestdaten();
            makler.remove(null);
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeAdresseEmpty() {
        try {
            Immobilienmakler makler = new TestImmobilienmakler().erzeugeTestdaten();
            makler.remove("");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeAdresseKleine2Zeichen() {
        try {
            Immobilienmakler makler = new TestImmobilienmakler().erzeugeTestdaten();
            makler.remove("A");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeAdresseKleine2Zeichen2() {
        try {
            Immobilienmakler makler = new TestImmobilienmakler().erzeugeTestdaten();
            makler.remove("Aa");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeAdresseLeereCollection() {
        try {
//            Immobilienmakler makler = new testImmobilienmakler().erzeugeTestdaten();
            Immobilienmakler makler = new Immobilienmakler("Makler1");
            Grundstueck grundstueck = new Grundstueck("Adresse 2, 1010 Ort", 100, 'B', 30);
            Wohnhaus w1 = new Wohnhaus("Adresse1", 'A', 10000, 50);
            makler.remove("Adresse1");
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();

        }
    }

    public static void testRemoveAdrsseGueltig1() {
        try {
            Immobilienmakler immo = new TestImmobilienmakler().erzeugeTestdaten2();
            System.out.println(immo.remove("Adresse 1, 1111 Wien"));
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeFlaecheLow() {
        try {
            Immobilienmakler makler = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(makler.remove(Constants.MIN_FLAECHE_WOHNHAUS - 1));
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeFlaecheHigh() {
        try {
            Immobilienmakler immo = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immo.remove(Constants.MAX_FLAECHE_GRUNDSTUECK * 2 + 1));
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeFlaecheEmpty() {
        try {
            Immobilienmakler immo = new Immobilienmakler("Makler1");
            immo.remove(200.0);
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeFlaecheGueltig() {
        try {
            Immobilienmakler immo = new Immobilienmakler("Makler1");
            immo.remove(200.0);
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testBerechneGesamtProvisionEmpty() {
        try {
//            Immobilienmakler immo = new testImmobilienmakler().erzeugeTestdaten();
            Immobilienmakler immo = new Immobilienmakler("Makler1");
            System.out.println(immo.berechneGesamtProvision());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testBerechneGesamtProvisionGueltig() {
        try {
            Immobilienmakler immo = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immo.berechneGesamtProvision());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testSortiereVerkehrswert() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immobilienmakler.toString());
            immobilienmakler.sortiereVerkehrswert();
            System.out.println(immobilienmakler.toString());

        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    public static void testAdresseSortierenAufsteigend() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immobilienmakler.toString());
            immobilienmakler.sortiereAdresse();
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAdresseSortierenFalse() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immobilienmakler.toString());
            immobilienmakler.sortiereAdresse(false);
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testAdresseSortierenTrue() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immobilienmakler.toString());
            immobilienmakler.sortiereAdresse(true);
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testSortierenFlaeche() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immobilienmakler.toString());
            immobilienmakler.sortiereFlaeche(true);
            System.out.println(immobilienmakler.toString());
            immobilienmakler.sortiereFlaeche(false);
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testSortierenFlaecheNat() {
        try {
            Immobilienmakler immobilienmakler = new TestImmobilienmakler().erzeugeTestdaten();
            System.out.println(immobilienmakler.toString());
            immobilienmakler.sortiereFlaecheNatuerlichesSortieren();
            System.out.println(immobilienmakler.toString());
        } catch (ImmobilienException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        TestImmobilienmakler.testName();
//        TestImmobilienmakler.testNameLeerzeichen();
//        TestImmobilienmakler.testAddNull();
//        TestImmobilienmakler.testNameGueltig();
//        TestImmobilienmakler.testAddContainsSame();
//        TestImmobilienmakler.testAddGueltig();
//        TestImmobilienmakler.testImmobilienListeEmpty();
//        TestImmobilienmakler.testImmobilienListeGueltig();
//        TestImmobilienmakler.testBerechneGesamtwertEmpty();
//        TestImmobilienmakler.testRemovePosEmpty();
//        TestImmobilienmakler.testRemovePosLow();
//        TestImmobilienmakler.testRemovePosHigh();
//        TestImmobilienmakler.testRemovePosGueltig();
//        TestImmobilienmakler.testRemovePosGueltig2();
//        TestImmobilienmakler.removeAdresseNull();
//        TestImmobilienmakler.removeAdresseEmpty();
//        TestImmobilienmakler.removeAdresseKleine2Zeichen();
//        TestImmobilienmakler.removeAdresseLeereCollection();
//        TestImmobilienmakler.testRemoveAdrsseGueltig1();
//        TestImmobilienmakler.removeFlaecheLow();
//        TestImmobilienmakler.removeFlaecheHigh();
//        TestImmobilienmakler.removeFlaecheEmpty();
//        TestImmobilienmakler.testBerechneGesamtProvisionEmpty();
//        TestImmobilienmakler.testBerechneGesamtProvisionGueltig();
        TestImmobilienmakler.testSortiereVerkehrswert();
//          TestImmobilienmakler.testAdresseSortierenAufsteigend();//
//        TestImmobilienmakler.testAdresseSortierenFalse();
//        TestImmobilienmakler.testAdresseSortierenTrue();
//        TestImmobilienmakler.testSortierenFlaeche();
//        TestImmobilienmakler.testSortierenFlaecheNat();


    }
}
