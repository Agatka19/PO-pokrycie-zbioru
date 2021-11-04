package cover;

import java.util.ArrayList;

public class CiągBinarny {
    private boolean[] ciągBinarny;

    //ustalamy długość tablicy ciągBinarny
    public void Długość(RodzinaZbiorów rodzinaZbiorów) {
        ciągBinarny = new boolean[rodzinaZbiorów.GetRozmiar()];
    }

    private boolean CzyPokrywa(RodzinaZbiorów rodzinaZbiorów, Zapytanie zapytanie) {
        zapytanie.DługośćZ();
        zapytanie.StwórzZbiórZ();
        int ilePokryte = 0;
        for (int i = 1; i < ciągBinarny.length; i++) {
            if (ciągBinarny[i]) {
                for (int k = 1; k < zapytanie.Z.length; k++) {
                    if (!zapytanie.Z[k] && rodzinaZbiorów.GetZbiór(i).CzyZawieraLiczbe(k)) {
                        zapytanie.Z[k] = true;
                        ilePokryte++;
                    }
                }
            }
        }
        return ilePokryte == zapytanie.Z.length - 1;
    }

    //żeby rozważyć wszystkie możliwe kombinacje wliczanych zbiorów będziemy generować ciągi zero-jedynkowe
    //i jeżeli jest 1 na danym indeksie, to bierzemy zbiór o tym indeksie, a jeżeli 0 - nie bierzemy.
    public void GeneratorBinarny(int i, ArrayList<boolean[]> Optymalne, RodzinaZbiorów rodzinaZbiorów, Zapytanie zapytanie) {
        ciągBinarny[i] = true;
        if (i != 0 && this.CzyPokrywa(rodzinaZbiorów, zapytanie)) {
            boolean[] kopia = ciągBinarny.clone(); //dodajemy kopię do wyniku, bo ciągBinarny cały czas nadpisujemy
            Optymalne.add(kopia);
        }
        if (i < ciągBinarny.length - 1)
            GeneratorBinarny(i + 1, Optymalne, rodzinaZbiorów, zapytanie);
        ciągBinarny[i] = false;
        if (this.CzyPokrywa(rodzinaZbiorów, zapytanie)) {
            boolean[] kopia = ciągBinarny.clone();
            Optymalne.add(kopia);
        }
        if (i < ciągBinarny.length - 1)
            GeneratorBinarny(i + 1, Optymalne, rodzinaZbiorów, zapytanie);
    }
}
