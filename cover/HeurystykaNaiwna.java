package cover;

import java.util.ArrayList;

public class HeurystykaNaiwna extends WybranyAlgorytm {
    private ArrayList<Integer> wynik = new ArrayList<>();
    private int ilePokrywa = 0; //sprawdzimy potem czy ilość pokrytych elementów jest równa ilości elementów w zbiorze Z

    @Override
    public ArrayList<Integer> Wykonaj(RodzinaZbiorów rodzinaZbiorów, Zapytanie zapytanie) {
        int ilośćZbiorów = rodzinaZbiorów.GetRozmiar();
        int rozmiarZ = -zapytanie.getA();
        for (int i = 1; i < ilośćZbiorów; i++) {
            boolean zbiórUwzględniony = false;
            for (int k = 1; k <= rozmiarZ; k++) {
                if (!zapytanie.Z[k] && rodzinaZbiorów.GetZbiór(i).CzyZawieraLiczbe(k)) {
                    zapytanie.Z[k] = true;
                    ilePokrywa++;
                    if (!zbiórUwzględniony)
                        wynik.add(i);
                    zbiórUwzględniony = true;
                }
            }
        }
        if (ilePokrywa >= rozmiarZ)
            return wynik;
        else
            return null;
    }
}
